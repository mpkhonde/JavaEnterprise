package se.projektarbete.studentapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

// Integrationstest för att verifiera att API och vyer fungerar tillsammans
@SpringBootTest
@AutoConfigureMockMvc
public class StudentApiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    // Testar att /home returnerar en HTML-sida med rätt titel
    @Test
    void testHomeEndpoint_ReturnsHtmlPage() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>Studenthantering</title>")))
                .andDo(result ->
                        System.out.println("Test OK: /home returnerade HTML-sida med rätt titel.")
                );
    }

    // Testar att /student/{id} svarar korrekt (status 200)
    @Test
    void testStudentEndpoint_ReturnsInfo() throws Exception {
        mockMvc.perform(get("/student/1"))
                .andExpect(status().isOk())
                .andDo(result ->
                        System.out.println("Test OK: /student/1 anrop fungerade som förväntat.")
                );
    }
}
