package EE_uppgift.uppgift9;

/**
 * Klassen Dog representerar en hund.
 * Dog är ett däggdjur och implementerar IMammal.
 */
public non-sealed class Dog implements IMammal {

    @Override
    public void makeSound() {
        System.out.println("Hunden skäller: Voff voff!");
    }

    @Override
    public void introduce() {
        System.out.println("Jag är en hund, ett troget däggdjur som gillar att leka!");
    }
}
