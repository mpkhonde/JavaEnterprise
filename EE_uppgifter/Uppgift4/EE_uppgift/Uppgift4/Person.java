package EE_uppgift.Uppgift4;

// En enkel klass som representerar en person
// Här övar jag på inkapsling och konstruktorer

public class Person {

    // Variabel för att spara namnet
    private String namn;

    // Konstruktor som tar emot ett namn
    public Person(String namn) {
        this.namn = namn;
    }

    // Getter-metod för att hämta namnet
    public String getNamn() {
        return namn;
    }
}
