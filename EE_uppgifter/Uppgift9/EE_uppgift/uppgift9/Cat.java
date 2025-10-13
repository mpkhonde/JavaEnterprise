package EE_uppgift.uppgift9;

/**
 * Klassen Cat representerar en katt.
 * Cat är ett däggdjur och implementerar IMammal.
 */
public non-sealed class Cat implements IMammal {

    @Override
    public void makeSound() {
        System.out.println("Katten jamar: Mjau!");
    }

    @Override
    public void introduce() {
        System.out.println("Jag är en katt, ett litet däggdjur som gillar att sova i solen.");
    }
}
