package EE_uppgift.uppgift9;

/**
 * 🧪 Main-klass för att testa Uppgift 9.
 */
public class Main {
    public static void main(String[] args) {

        // ─────────────────────────────────────────────
        // 🐘 Skapa ett däggdjur: Elephant
        // ─────────────────────────────────────────────
        IAnimal elephant = new Elephant();
        System.out.println("🦣 Elefant:");
        elephant.makeSound();
        AnimalUtil.checkAnimalType(elephant);

        System.out.println();

        // ─────────────────────────────────────────────
        // 🐍 Skapa en reptil: Snake
        // ─────────────────────────────────────────────
        IAnimal snake = new Snake();
        System.out.println("🐍 Orm:");
        snake.makeSound();
        AnimalUtil.checkAnimalType(snake);
    }
}
