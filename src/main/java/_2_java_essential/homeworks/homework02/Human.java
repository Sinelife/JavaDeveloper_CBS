package _2_java_essential.homeworks.homework02;

import java.util.Random;

/**
 * Клас Human позволяет создавать обьекты типа Human
 * Уникальная особенность людей это возможность восстановить часть здоровья перед
 * своим ударом. Вероятность восстановления определяет константа HEALING_CHANCE, а
 * количество восстанавлиемого здоровья по отношению к всему здоровью определяет
 * константа HEALTH_PERCENT
 */

public class Human extends Hero {
    private static final int DEFAULT_HUMAN_HEALTH = 280;
    private static final int DEFAULT_HUMAN_ATTACK = 75;
    private static final int DEFAULT_HUMAN_ARMOUR = 20;

    private static final double HEALING_CHANCE = 0.2;
    private static final double HEALTH_PERCENT = 0.1;


    public Human(String name) {
        super(name, DEFAULT_HUMAN_HEALTH, DEFAULT_HUMAN_ATTACK, DEFAULT_HUMAN_ARMOUR);
    }


    /**
     * Метод получения здоровья человека после исцеления
     */
    public int healAfterAttack() {
        Random rand = new Random();
        int k = rand.nextInt(100) + 1;
        if (k > 0 && k < HEALING_CHANCE * 100) {
            System.out.print(name + " исцеляет " + (DEFAULT_HUMAN_HEALTH * HEALTH_PERCENT) + " здоровья. ");
            health += DEFAULT_HUMAN_HEALTH * HEALTH_PERCENT;
        }
        if (health > DEFAULT_HUMAN_HEALTH) {
            health = DEFAULT_HUMAN_HEALTH;
        }
        return health;
    }


    /**
     * Переопределенный для человека метод получения атаки(сразу происходит и лечение)
     */
    @Override
    public int getAttack() {
        healAfterAttack();
        return super.getAttack();
    }


    /**
     * Переопределенный для человека метод получения имени и расы персонажа
     */
    @Override
    public String toStringNameAndRace() {
        return "Человек " + name;
    }


    /**
     * Переопределенный для человека метод получения информации про персонажа
     */
    @Override
    public String toString() {
        return "Человек " + name + super.toString();
    }
}
