package se.projektarbete.studentapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Testar InMemoryStudentService (den som körs utan riktig databas)
public class InMemoryStudentServiceTest {

    private InMemoryStudentService inMemoryStudentService;

    @BeforeEach
    void setup() {
        inMemoryStudentService = new InMemoryStudentService();
    }

    // Testar att getStudentInfo() returnerar förväntat meddelande
    @Test
    void testGetStudentInfo_ReturnsExpectedMessage() {
        Long id = 5L;
        String result = inMemoryStudentService.getStudentInfo(id);

        assertNotNull(result);
        assertTrue(result.contains("hittades inte")); // anpassat efter faktisk metod i din kod
        System.out.println("Test OK: getStudentInfo() gav korrekt svar.");
    }

    // Testar att getStudent() returnerar tom sträng när studenten inte finns
    @Test
    void testGetStudent_ReturnsEmptyString() {
        Long id = 10L;
        String result = inMemoryStudentService.getStudent(id);

        assertEquals("", result);
        System.out.println("Test OK: getStudent() returnerade tom sträng som väntat.");
    }

    // Testar att en ny student kan sparas i minnet
    @Test
    void testCreateStudent_SavesAndReturnsStudent() {
        Student student = new Student(4L, "Testare");
        Student result = inMemoryStudentService.createStudent(student);

        assertNotNull(result);
        assertEquals("Testare", result.getName());
        System.out.println("Test OK: createStudent() sparade studenten korrekt.");
    }
}
