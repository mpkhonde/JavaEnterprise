package se.projektarbete.studentapi;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@Service
@Profile("dev") // används när man kör projektet i utvecklingsläge
public class InMemoryStudentService implements StudentService {

    // En enkel "databas" i minnet där vi sparar studenter
    private final Map<Long, String> students = new HashMap<>();

    // Lägger in några teststudenter direkt när tjänsten startar
    public InMemoryStudentService() {
        students.put(1L, "Student: Sara");
        students.put(2L, "Student: Moise");
        students.put(3L, "Student: Alex");
    }

    // Hämtar studentens namn baserat på id
    @Override
    public String getStudentInfo(Long id) {
        return students.getOrDefault(id, "Student med id " + id + " hittades inte.");
    }

    // Samma som ovan men returnerar tom sträng om ingen hittas
    @Override
    public String getStudent(Long id) {
        return students.getOrDefault(id, "");
    }

    // Skapar ett Student-objekt baserat på information i minnesmappen
    @Override
    public Student getStudentById(long id) {
        String name = students.get(id);
        if (name == null) return null;

        // Eftersom vi inte använder riktig databas, "mockar" vi fram objektet
        return new Student(id, name);
    }

    // Returnerar alla studenter som en lista
    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        for (Map.Entry<Long, String> entry : students.entrySet()) {
            list.add(new Student(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    // Sparar eller uppdaterar en student i minnesmappen
    @Override
    public Student saveStudent(Student student) {
        students.put(student.getId(), student.getName());
        return student;
    }

    // Gör samma sak som saveStudent, men namnet används ibland för tydlighet
    @Override
    public Student createStudent(Student student) {
        students.put(student.getId(), student.getName());
        return student;
    }

    // Tar bort en student om ID:t finns, annars returneras false
    @Override
    public boolean deleteStudentById(long id) {
        if (students.containsKey(id)) {
            students.remove(id);
            return true;
        }
        return false;
    }
}
