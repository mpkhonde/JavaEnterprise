package se.projektarbete.studentapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // Konstruktor för att koppla ihop servicen med vårt repository
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Skapar och sparar en ny student i databasen
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Hämtar info om en student som text (baserat på ID)
    @Override
    public String getStudentInfo(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            return "Student: " + student.get().getName();
        } else {
            return "Student med id " + id + " hittades inte.";
        }
    }

    // Hämtar en student som objekt
    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Samma som getStudentInfo, men kvar för kompatibilitet
    @Override
    public String getStudent(Long id) {
        return getStudentInfo(id);
    }

    // Returnerar alla studenter i databasen
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Sparar (eller uppdaterar) en student
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Tar bort en student om ID:t finns, annars returneras false
    @Override
    public boolean deleteStudentById(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
