package EE_uppgift.uppgift8;

/**
 * 🧬 IAnimal är ett grundinterface för alla djur.
 */
public sealed interface IAnimal permits IMammal, IReptile {
    void makeSound();
    void introduce(); // 👈 Lägg till denna metod här
}
