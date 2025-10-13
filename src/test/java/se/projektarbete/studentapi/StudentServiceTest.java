package se.projektarbete.studentapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

// Enkel testklass för StudentService (utan riktig databas)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService studentService;

    @BeforeEach
    void setup() {
        // Initierar mock-objekten innan varje test
        MockitoAnnotations.openMocks(this);
        studentService = new StudentServiceImpl(studentRepository);
    }

    // Testar att en student sparas korrekt via servicen
    @Test
    void testCreateStudent() {
        Student student = new Student(null, "Sara");

        // Här "låtsas" vi att databasen returnerar en student med id=1 när vi sparar
        when(studentRepository.save(any(Student.class)))
                .thenReturn(new Student(1L, "Sara"));

        Student saved = studentService.createStudent(student);

        assertNotNull(saved);
        assertEquals("Sara", saved.getName());
        System.out.println("Test OK: studenten sparades korrekt.");
    }
}
