package _2_java_essential.homeworks.homework02;


import java.util.Random;


/**
 * Клас Demon позволяет создавать обьекты типа Demon
 * Уникальная особенность демонов это возможность силой пламени сломать броню
 * противника. Вероятность поломки брони определяет константа ARMOR_DESTROY_CHANCE,
 * а часть разрушеной брони по отношению к всей броне определяет константа
 * PERCENT_OF_ARMOR_DESTROY
 */

public class Demon extends Hero {
    private static final int DEFAULT_DEMON_HEALTH = 300;
    private static final int DEFAULT_DEMON_ATTACK = 70;
    private static final int DEFAULT_DEMON_ARMOUR = 15;

    private static final double ARMOR_DESTROY_CHANCE = 0.2;
    private static final double PERCENT_OF_ARMOR_DESTROY = 0.4;

    public Demon(String name) {
        super(name, DEFAULT_DEMON_HEALTH, DEFAULT_DEMON_ATTACK, DEFAULT_DEMON_ARMOUR);
    }


    /**
     * Переопределенный для демона метод возвращающий броню противника после
     * ее поломки
     */
    public int getArmorAfterDestruction(int armor) {
        Random rand = new Random();
        int k = rand.nextInt(100) + 1;
        if (k > 0 && k < ARMOR_DESTROY_CHANCE * 100) {
            System.out.print(toStringNameAndRace() + " снижает броню с " + armor + " до ");
            armor *= (1 - PERCENT_OF_ARMOR_DESTROY);
            System.out.println(armor + ". ");
        }
        return armor;
    }

    /**
     * Переопределенный для демона метод получения имени и расы персонажа
     */
    @Override
    public String toStringNameAndRace() {
        return "Демон " + name;
    }


    /**
     * Переопределенный для демона метод получения всей информации про персонажа
     */
    @Override
    public String toString() {
        String res = "Демон " + name + super.toString();
        return res;
    }
}
