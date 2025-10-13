package EE_uppgift.uppgift9;

/**
 * IReptile representerar reptiler.
 * Endast Snake och Lizard får implementera detta interface.
 */
public sealed interface IReptile extends IAnimal permits Snake, Lizard {

    // Alla reptiler ska kunna presentera sig
    void introduce();
}
