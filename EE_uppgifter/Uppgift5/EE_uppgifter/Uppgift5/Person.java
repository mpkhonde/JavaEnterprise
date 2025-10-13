package EE_uppgifter.Uppgift5;

import javax.validation.constraints.NotEmpty;

public class Person {
    @NotEmpty(message = "Namnet får inte vara tomt!")
    private String namn;

    public Person(String namn) {
        this.namn = namn;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }
}
