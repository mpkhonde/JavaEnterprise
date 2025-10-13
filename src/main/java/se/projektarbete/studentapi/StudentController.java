package se.projektarbete.studentapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    // Konstruktor – Spring injicerar automatiskt rätt StudentService (JPA eller InMemory beroende på profil)
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Visar startsidan (home.html) med alla studenter
    @GetMapping("/home")
    public String home(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "home"; // pekar på filen home.html i templates-mappen
    }

    // Hämtar info om en viss student (via API)
    @GetMapping("/student/{id}")
    @ResponseBody
    public ResponseEntity<String> getStudent(@PathVariable Long id) {
        String info = studentService.getStudentInfo(id);
        return ResponseEntity.ok(info);
    }

    // Skapar en ny student (anropas via POST från JavaScript)
    @PostMapping("/student")
    @ResponseBody
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        Student saved = studentService.saveStudent(student);
        return ResponseEntity.ok("Student '" + saved.getName() + "' sparades med ID " + saved.getId());
    }

    // Tar bort en student baserat på ID
    @DeleteMapping("/student/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);

        if (student == null) {
            return ResponseEntity.status(404).body("Ingen student hittades med ID: " + id);
        }

        boolean deleted = studentService.deleteStudentById(id);

        if (deleted) {
            return ResponseEntity.ok("Studenten med ID " + id + " har tagits bort.");
        } else {
            return ResponseEntity.status(500).body("Kunde inte ta bort studenten med ID: " + id);
        }
    }

    // Ny endpoint – används av script.js för att visa alla studenter på sidan
    @GetMapping("/students")
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
