package EE_uppgift.uppgift9;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean kör = true;

        System.out.println("Välkommen till mitt djurprogram!");

        // Programmet loopar tills man väljer att avsluta
        while (kör) {
            // Meny som visar vad man kan välja
            System.out.println("\nVälj ett djur:");
            System.out.println("1. Katt");
            System.out.println("2. Hund");
            System.out.println("3. Orm");
            System.out.println("4. Ödla");
            System.out.println("5. Visa alla djur");
            System.out.println("0. Avsluta");
            System.out.print("Skriv nummer: ");

            int val = scanner.nextInt();
            IAnimal djur = null; // Här sparas djuret man väljer

            // Kollar vilket djur man valde
            if (val == 1) {
                djur = new Cat();
            } else if (val == 2) {
                djur = new Dog();
            } else if (val == 3) {
                djur = new Snake();
            } else if (val == 4) {
                djur = new Lizard();
            } else if (val == 5) {
                // Visar info om alla djur
                System.out.println("\nAlla djur:");
                List<IAnimal> alla = List.of(new Cat(), new Dog(), new Snake(), new Lizard());

                // Går igenom listan och visar varje djur
                for (IAnimal a : alla) {
                    a.introduce();      // Skriver info om djuret
                    a.makeSound();      // Djuret låter
                    AnimalUtil.checkAnimalType(a); // Kollar typ av djur
                    System.out.println("---------------");
                }
            } else if (val == 0) {
                // Om man väljer 0 avslutas programmet
                System.out.println("Programmet avslutas...");
                kör = false;
            } else {
                // Om man skriver något annat än 0–5
                System.out.println("Fel val, försök igen.");
            }

            // Om man valde ett enskilt djur (inte alla)
            if (djur != null) {
                System.out.println("\nDjurinfo:");
                djur.introduce();
                djur.makeSound();
                AnimalUtil.checkAnimalType(djur);
            }

            // Frågar om man vill fortsätta köra programmet
            if (kör) {
                System.out.print("\nVill du fortsätta (ja/nej)? ");
                String svar = scanner.next().toLowerCase();

                // Om man inte skriver "ja" så avslutas programmet
                if (!svar.equals("ja")) {
                    kör = false;
                    System.out.println("Hejdå!");
                }
            }
        }

        // Stänger scannern när programmet är klart
        scanner.close();
    }
}
