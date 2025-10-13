package EE_uppgifter.Uppgift7.EE_uppgifter.Uppgift7;

// Uppgift 7 - här testar jag en vanlig switch-sats med två case

public class Uppgift7Main {
    public static void main(String[] args) {
        int dag = 1;

        // En enkel switch med två olika case
        switch (dag) {
            case 1:
                System.out.println("Måndag");
                break;
            case 2:
                System.out.println("Tisdag");
                break;
            default:
                System.out.println("Okänd dag");
                break;
        }


    }
}
