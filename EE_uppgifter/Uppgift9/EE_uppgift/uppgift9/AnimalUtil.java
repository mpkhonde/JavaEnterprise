package EE_uppgift.uppgift9;

/**
 * AnimalUtil är en hjälpklass som kan analysera vilket typ av djur som skickas in.
 */
public class AnimalUtil {

    // Kontrollerar vilken typ av djur som skickats in och skriver ut information
    public static void checkAnimalType(IAnimal animal) {

        System.out.println("Analyserar djur...");

        if (animal instanceof IMammal) {
            System.out.println("Detta djur är ett däggdjur.");
        }
        else if (animal instanceof IReptile) {
            System.out.println("Detta djur är en reptil.");
        }
        else {
            System.out.println("Okänd djurtyp.");
        }
    }
}
