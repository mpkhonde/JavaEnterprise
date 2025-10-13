package EE_uppgift.uppgift8;

// Klassen Dog implementerar interfacet Animal
// final betyder att ingen annan kan ärva Dog

public final class Dog implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Voff voff!");
    }
}
