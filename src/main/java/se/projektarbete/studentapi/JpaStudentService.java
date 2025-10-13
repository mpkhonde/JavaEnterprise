package se.projektarbete.studentapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Primary
@Service
@Profile("prod")
public class JpaStudentService implements StudentService {

    private final StudentRepository studentRepository;

    // Konstruktor för att injicera repository (Spring sköter detta automatiskt)
    @Autowired
    public JpaStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Hämtar information om en student baserat på id och returnerar det som text
    @Override
    public String getStudentInfo(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            // Om studenten hittas i databasen
            return "Student: " + student.get().getName() + " (id = " + id + ")";
        } else {

            // Om ingen student med det ID:t finns
            return "Student med id " + id + " hittades inte i databasen (JPA).";
        }
    }

    // Anropar samma metod som ovan, men behåller gränssnittets struktur
    @Override
    public String getStudent(Long id) {
        return getStudentInfo(id);
    }

    // Returnerar studentobjektet direkt (eller null om det inte finns)
    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Hämtar en lista på alla studenter i databasen
    @Override
    public java.util.List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Sparar (eller uppdaterar) en student i databasen
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Alias för saveStudent – gör samma sak, men namnet kan användas för tydlighet
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Tar bort en student baserat på ID
    @Override
    public boolean deleteStudentById(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        // Returnerar false om studenten inte finns
        return false;
    }
}
