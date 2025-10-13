package EE_uppgift.uppgift8;

// Uppgift 8 - här testar jag sealed interface
// sealed begränsar vilka klasser som får implementera detta interface

public sealed interface Animal permits Dog, Cat {
    void makeSound();
}
