package EE_uppgift.uppgift8;

/**
 * 🐾 IMammal representerar alla däggdjur och ärver från IAnimal.
 * Tillåter specifika klasser enligt sealed interface-regler.
 */
public sealed interface IMammal extends IAnimal
        permits Cat, Dog, Bear, Fox, Elephant {

    void introduce();
}
