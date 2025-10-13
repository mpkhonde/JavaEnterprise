package EE_uppgift.uppgift9;

/**
 * IAnimal är ett grundinterface för alla djur.
 * Här definieras metoder som alla djur måste ha.
 */
public sealed interface IAnimal permits IMammal, IReptile {

    // Alla djur ska kunna göra ett ljud
    void makeSound();

    // Alla djur ska kunna presentera sig
    void introduce();
}
