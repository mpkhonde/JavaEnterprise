package EE_uppgifter.Uppgift6;

// Uppgift 6 - Här testar jag hur en Record fungerar i Java
// Ett record är en enkel form av klass som används för att spara data (immutable)

public record UserRecord(String name) {
    // Inga setters behövs, värdet går inte att ändra
    // Automatisk toString(), equals() och hashCode() skapas
}
