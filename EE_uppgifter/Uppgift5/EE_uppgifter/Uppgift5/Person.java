package EE_uppgifter.Uppgift5;

//import javax.validation.constraints.NotBlank;

// Uppgift 5 - testar @NotBlank och ser vad den gör
public class Person {

    // @NotBlank betyder att strängen inte får vara tom eller bara mellanslag
    //@NotBlank(message = "Namnet får inte vara tomt!")
    private String namn;

    // Konstruktor som sätter namn
    public Person(String namn) {
        this.namn = namn;
    }

    // Getter för namn
    public String getNamn() {
        return namn;
    }

    // Setter för namn
    public void setNamn(String namn) {
        this.namn = namn;
    }
}
