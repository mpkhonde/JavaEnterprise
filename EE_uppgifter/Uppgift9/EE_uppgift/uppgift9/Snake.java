package EE_uppgift.uppgift9;

/**
 * 🐍 Klassen Snake representerar en orm.
 * Snake är en reptil och implementerar IReptile.
 */
public final class Snake implements IReptile {

    @Override
    public void makeSound() {
        System.out.println("Ormen väser: Sssssssss!");
    }

    @Override
    public void introduce() {
        System.out.println("Jag är en orm, en reptil som kryper tyst på marken.");
    }
}
