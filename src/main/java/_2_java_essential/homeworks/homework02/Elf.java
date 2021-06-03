package _2_java_essential.homeworks.homework02;


/**
 * Абстрактный клас эльфов, от которого наследуються разные виды эльфов
 */

public abstract class Elf extends Hero {

    public Elf(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);

    }
}
