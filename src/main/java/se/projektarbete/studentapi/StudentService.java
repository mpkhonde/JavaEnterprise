package se.projektarbete.studentapi;

import java.util.List;

// Bestämmer vilka metoder alla StudentService-klasser ska ha
public interface StudentService {

    // Hämtar info om en student som text
    String getStudentInfo(Long id);

    // Samma som ovan men används för kompatibilitet i vissa delar av koden
    String getStudent(Long id);

    // Returnerar en student som objekt eller null om den inte finns
    Student getStudentById(long id);

    // Hämtar alla studenter
    List<Student> getAllStudents();

    // Sparar eller uppdaterar en student
    Student saveStudent(Student student);

    // Skapar en ny student kan användas vid nyanläggning
    Student createStudent(Student student);

    // Tar bort en student med visst ID
    boolean deleteStudentById(long id);
}
