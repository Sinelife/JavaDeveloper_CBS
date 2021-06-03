package _2_java_essential.homeworks.homework02;

import java.util.Random;

/**
 * Клас UndeadKnight позволяет создавать обьекты типа UndeadKnight
 * Уникальная особенность рыцаря смерти это способность один раз возродиться с
 * вероятностью, которую определяет RESURRECT_CHANCE.
 * Возрожденный Рыцарь смерти будет слабее первоначального.
 * Также у рыцаря смерти нельзя вызвать кровотичение
 */

public class UndeadKnight extends Hero {
    private static final int DEFAULT_UNDEADKNIGHT_HEALTH = 280;
    private static final int DEFAULT_UNDEADKNIGHT_ATTACK = 70;
    private static final int DEFAULT_UNDEADKNIGHT_ARMOR = 25;

    private double RESURRECT_CHANCE = 0.50;


    public UndeadKnight(String name) {
        super(name, DEFAULT_UNDEADKNIGHT_HEALTH, DEFAULT_UNDEADKNIGHT_ATTACK, DEFAULT_UNDEADKNIGHT_ARMOR);
    }



    /**
     * Переопределенный для рыцаря смерти метод для возрождения персонажа
     */
    public void resurrect() {
        if (health <= 0) {
            Random rand = new Random();
            int k = rand.nextInt(100) + 1;
            if (k > 0 && k < RESURRECT_CHANCE * 100) {
                System.out.println(name + " возродился. ");
                armor = 0;
                attack *= 0.5;
                health = 100;
                RESURRECT_CHANCE = 0;
            }
        }
    }


    /**
     * Переопределенный для рыцаря смерти метод получения имени и расы персонажа
     */
    @Override
    public String toStringNameAndRace() {
        return "Рыцарь Смерти " + name;
    }

    /**
     * Переопределенный для рыцаря смерти метод получения всей информации про персонажа
     */
    @Override
    public String toString() {
        return "Рыцарь Смерти " + name + super.toString();
    }
}
