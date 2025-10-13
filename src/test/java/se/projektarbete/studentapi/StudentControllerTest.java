package se.projektarbete.studentapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Enkel testklass för att testa StudentController utan att köra hela Spring
public class StudentControllerTest {

    private StudentController studentController;
    private StudentService studentService;

    @BeforeEach
    void setup() {
        // Skapar en fejkad (mockad) version av StudentService så vi kan testa controllern isolerat
        studentService = Mockito.mock(StudentService.class);
        studentController = new StudentController(studentService);
    }

    // Testar att controllern returnerar rätt svar när en student hittas
    @Test
    void testGetStudent_ReturnsExpectedResponse() {
        Long id = 1L;
        when(studentService.getStudentInfo(id)).thenReturn("Student: Sara");

        ResponseEntity<String> response = studentController.getStudent(id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Student: Sara", response.getBody());
        System.out.println("Test OK: Controller returnerade korrekt studentinfo.");
    }

    // Testar fallet när ingen student hittas (ska fortfarande ge svar, men med felmeddelande)
    @Test
    void testGetStudent_WhenNotFound_ReturnsMessage() {
        Long id = 99L;
        when(studentService.getStudentInfo(id)).thenReturn("Student med id 99 hittades inte.");

        ResponseEntity<String> response = studentController.getStudent(id);

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("hittades inte"));
        System.out.println("Test OK: Controller hanterade fallet 'student saknas'.");
    }

    // Testar att /home-metoden returnerar rätt vy-namn
    @Test
    void testHome_ReturnsHomeView() {
        // Här behövs egentligen mockning av studentlistan, men vi testar bara returnvärdet
        String result = studentController.home(mock(org.springframework.ui.Model.class));
        assertEquals("home", result);
        System.out.println("Test OK: Controller returnerade vyn 'home'.");
    }
}
