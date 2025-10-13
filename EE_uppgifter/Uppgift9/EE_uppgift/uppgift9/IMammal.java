package EE_uppgift.uppgift9;

/**
 * IMammal representerar däggdjur.
 * Endast Cat och Dog får implementera detta interface.
 */
public sealed interface IMammal extends IAnimal permits Cat, Dog {

    // Extra metod för däggdjur (kan användas om man vill)
    void introduce();
}
