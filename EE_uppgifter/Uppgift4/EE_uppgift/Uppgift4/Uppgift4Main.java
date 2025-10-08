package EE_uppgift.Uppgift4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Uppgift4Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Frågar användaren efter sitt namn
        System.out.print("Hej, Vad heter du? ");
        String namn = scanner.nextLine();
        System.out.println("Namn i person: " + namn);

        // Frågar om användaren vill se veckodagar
        System.out.print("Vill du skriva ut veckodagar? (ja/nej): ");
        String svar = scanner.nextLine();

        // Om användaren skriver "ja"
        if (svar.equalsIgnoreCase("ja")) {
            System.out.print("Skriv ett nummer mellan 1-7 (eller 'alla' för att se alla dagar): ");
            String val = scanner.nextLine();

            // Om användaren skriver "alla", skriv ut alla veckodagar
            if (val.equalsIgnoreCase("alla")) {
                List<String> allaDagar = Arrays.asList("Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag");
                for (String dag : allaDagar) {
                    System.out.println(dag);
                }
            } else {
                // Försöker tolka användarens inmatning som ett nummer
                try {
                    int dag = Integer.parseInt(val);
                    String dagNamn;

                    // Väljer rätt dag baserat på siffran
                    switch (dag) {
                        case 1: dagNamn = "Måndag"; break;
                        case 2: dagNamn = "Tisdag"; break;
                        case 3: dagNamn = "Onsdag"; break;
                        case 4: dagNamn = "Torsdag"; break;
                        case 5: dagNamn = "Fredag"; break;
                        case 6: dagNamn = "Lördag"; break;
                        case 7: dagNamn = "Söndag"; break;
                        default: dagNamn = "Ogiltigt nummer";
                    }

                    // Skriver ut vald veckodag
                    System.out.println(dagNamn);

                } catch (NumberFormatException e) {
                    // Om användaren inte skrev ett giltigt nummer
                    System.out.println("Fel: Du skrev inte ett giltigt nummer eller 'alla'.");
                }
            }
        }

        // Skapar en lista för att spara namn
        List<String> namnLista = new ArrayList<>();

        // Låter användaren skriva in flera namn tills "klar" eller tomt
        while (true) {
            System.out.print("Skriv ett namn (eller skriv 'klar' eller tryck Enter för att avsluta): ");
            String input = scanner.nextLine();

            // Avslutar om användaren skriver "klar" eller trycker Enter utan text
            if (input.equalsIgnoreCase("klar") || input.isEmpty()) {
                break;
            }

            // Lägger till namnet i listan
            namnLista.add(input);
        }

        // Skriver ut hälsning för varje namn i listan
        for (String n : namnLista) {
            System.out.println("Hej " + n);
        }

        // Stänger scannern
        scanner.close();
    }
}
