package _3_java_professional.homeworks.homework05;


@JsonEntity
public class Weapon {

    @JsonField
    private String type;

    @JsonField
    private int power;

    public Weapon(String type, int power) {
        this.type = type;
        this.power = power;
    }
}
