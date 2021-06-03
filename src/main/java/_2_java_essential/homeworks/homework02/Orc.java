package _2_java_essential.homeworks.homework02;
import java.util.Random;


/**
 * Клас Orc позволяет создавать обьекты типа Orc/
 * Уникальная особенность орков это возможность уклониться от удара противника.
 * Вероятность уклонения определяет константа DODGE_ATTACK_CHANCE.
 */

public class Orc extends Hero {
    private static final int DEFAULT_ORC_HEALTH = 280;
    private static final int DEFAULT_ORC_ATTACK = 70;
    private static final int DEFAULT_ORC_ARMOUR = 25;

    private static final double DODGE_ATTACK_CHANCE = 0.25;

    public Orc(String name) {
        super(name, DEFAULT_ORC_HEALTH, DEFAULT_ORC_ATTACK, DEFAULT_ORC_ARMOUR);
    }


    /**
     * Переопределенный для орка метод сообщающий удалось ли персонажу уклониться
     * от удара
     */
    @Override
    public boolean isDodge() {
        Random rand = new Random();
        int k = rand.nextInt(100) + 1;
        if (k > 0 && k < DODGE_ATTACK_CHANCE * 100) {
            System.out.print(name + " уклонился от удара. ");
            return true;
        }
        return false;
    }

    /**
     * Переопределенный для орка метод получения имени и расы персонажа
     */
    @Override
    public String toStringNameAndRace() {
        return "Орк " + name;
    }

    /**
     * Переопределенный для орка метод получения всей информации про персонажа
     */
    @Override
    public String toString() {
        return "Орк " + name + super.toString();
    }
}
