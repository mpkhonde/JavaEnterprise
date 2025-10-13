package EE_uppgift.uppgift9;

/**
 * Klassen Lizard representerar en ödla.
 * Lizard är en reptil och implementerar IReptile.
 */
public non-sealed class Lizard implements IReptile {

    @Override
    public void makeSound() {
        System.out.println("Ödlan klickar tyst: *klick klick*");
    }

    @Override
    public void introduce() {
        System.out.println("Jag är en ödla, en reptil som gillar att sola på stenar.");
    }
}
