package se.projektarbete.studentapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // markerar att klassen motsvarar en tabell i databasen
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;     // unikt id för varje student

    private String name; // studentens namn

    // Tom konstruktor behövs av JPA (för att kunna skapa objekt automatiskt)
    public Student() {}

    // Används när man vill skapa en student med både id och namn (t.ex. testdata)
    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Används när man skapar en ny student (id genereras automatiskt)
    public Student(String name) {
        this.name = name;
    }

    // Getter och setter för id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter och setter för namn
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
