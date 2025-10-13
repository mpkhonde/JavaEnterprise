package EE_uppgift.uppgift8;

// Klassen Cat implementerar interfacet Animal
// final betyder att ingen annan kan ärva Cat

public final class Cat implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Mjau!");
    }
}
