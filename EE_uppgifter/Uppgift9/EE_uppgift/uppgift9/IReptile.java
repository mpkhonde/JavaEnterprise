package EE_uppgift.uppgift8;

/**
 * IReptile representerar alla reptiler och ärver från IAnimal.
 */
public sealed interface IReptile extends IAnimal permits Snake {

    // Här kan vi lägga till reptil-specifika metoder i framtiden
}
