package se.projektarbete.studentapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Enkel testklass för JpaStudentService – testar logiken utan riktig databas
public class JpaStudentServiceTest {

    private StudentRepository studentRepository;
    private JpaStudentService jpaStudentService;

    @BeforeEach
    void setUp() {
        // Skapar ett fejk-repository (mock) så att vi kan testa servicen isolerat
        studentRepository = Mockito.mock(StudentRepository.class);
        jpaStudentService = new JpaStudentService(studentRepository);
    }

    // Testar att en student sparas korrekt via JPA-servicen
    @Test
    void testSaveStudent() {
        Student student = new Student(1L, "Sara");
        when(studentRepository.save(student)).thenReturn(student);

        Student saved = jpaStudentService.saveStudent(student);

        assertNotNull(saved);
        assertEquals("Sara", saved.getName());
        System.out.println("Test OK: studenten sparades som förväntat.");
    }

    // Testar att en befintlig student kan hämtas med sitt ID
    @Test
    void testGetStudentByIdFound() {
        Student student = new Student(1L, "Anna");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student result = jpaStudentService.getStudentById(1L);

        assertNotNull(result);
        assertEquals("Anna", result.getName());
        System.out.println("Test OK: studenten hämtades korrekt.");
    }

    // Testar att metoden hanterar fallet när studenten inte finns
    @Test
    void testGetStudentByIdNotFound() {
        when(studentRepository.findById(99L)).thenReturn(Optional.empty());

        Student result = jpaStudentService.getStudentById(99L);

        assertNull(result);
        System.out.println("Test OK: saknad student hanterades korrekt.");
    }

    // Testar att getStudentInfo() returnerar rätt textsträng
    @Test
    void testGetStudentInfo() {
        Student student = new Student(1L, "Erik");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        String info = jpaStudentService.getStudentInfo(1L);

        assertTrue(info.contains("Erik"));
        assertTrue(info.contains("1"));
        System.out.println("Test OK: getStudentInfo() gav rätt resultat.");
    }
}
