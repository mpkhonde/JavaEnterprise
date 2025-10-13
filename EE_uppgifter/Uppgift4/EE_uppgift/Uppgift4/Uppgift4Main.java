package EE_uppgift.Uppgift4;

import java.util.Scanner;

// Uppgift 4 - Här testar jag switch-sats och användarinmatning

public class Uppgift4Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Frågar användaren vilket nummer på veckodagen de vill skriva ut
        System.out.print("Skriv en siffra mellan 1-7 för att se veckodag: ");
        int dag = scanner.nextInt();

        // Använder en switch-sats för att välja dag
        String veckodag;
        switch (dag) {
            case 1: veckodag = "Måndag"; break;
            case 2: veckodag = "Tisdag"; break;
            case 3: veckodag = "Onsdag"; break;
            case 4: veckodag = "Torsdag"; break;
            case 5: veckodag = "Fredag"; break;
            case 6: veckodag = "Lördag"; break;
            case 7: veckodag = "Söndag"; break;
            default: veckodag = "Ogiltigt nummer"; // Om man skriver t.ex. 10
        }

        // Skriver ut resultatet
        System.out.println("Du valde: " + veckodag);

        // Stänger scannern
        scanner.close();
    }
}
