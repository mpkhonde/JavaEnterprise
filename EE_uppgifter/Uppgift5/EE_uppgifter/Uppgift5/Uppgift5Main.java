package EE_uppgifter.Uppgift5;

import javax.validation.*;
import java.util.*;

public class Uppgift5Main {
    public static void main(String[] args) {
        // Skapa scanner för användarinmatning
        Scanner scanner = new Scanner(System.in);

        // Skapa en lista för att lagra giltiga personer
        List<Person> personLista = new ArrayList<>();

        // Skapa en validator från Hibernate Validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Loopa så länge användaren vill lägga till personer
        boolean fortsätt = true;
        while (fortsätt) {
            System.out.print("Skriv ditt namn: ");
            String namn = scanner.nextLine();

            // Skapa en person
            Person person = new Person(namn);

            // Validera personen
            Set<ConstraintViolation<Person>> violations = validator.validate(person);

            // Om det finns valideringsfel
            if (!violations.isEmpty()) {
                for (ConstraintViolation<Person> violation : violations) {
                    System.out.println("Fel: " + violation.getMessage());
                }
            } else {
                // Om giltig person, lägg till i listan
                personLista.add(person);
                System.out.println("Hej " + person.getNamn() + "!");
            }

            // Fråga om man vill fortsätta
            System.out.print("Vill du lägga till en till person? (ja/nej): ");
            String svar = scanner.nextLine().toLowerCase();

            if (!svar.equals("ja")) {
                fortsätt = false;
            }
        }

        // Skriv ut alla giltiga personer
        System.out.println("\nAlla personer:");
        for (Person p : personLista) {
            System.out.println("- " + p.getNamn());
        }
    }
}
