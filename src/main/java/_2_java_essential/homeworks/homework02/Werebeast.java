package _2_java_essential.homeworks.homework02;


import java.util.Random;


/**
 * Клас Werebeast позволяет создавать обьекты типа Werebeast
 * Уникальная особенность зверолюдей это возможность во время атаки вызвать у
 * противника кровотечение, которое будет отнимать здоровье противника в течении
 * нескольких раундов. Вероятность вызова кровотечения определяет константа
 * CAUSE_BLEEDING_CHANCE
 */

public class Werebeast extends Hero {

    private static final int DEFAULT_WEREBEAST_HEALTH = 270;
    private static final int DEFAULT_WEREBEAST_ATTACK = 70;
    private static final int DEFAULT_WEREBEAST_ARMOR = 10;

    private static final double CAUSE_BLEEDING_CHANCE = 0.25;
    private static final int BLEEDING_DAMAGE = 30;

    public Werebeast(String name) {
        super(name, DEFAULT_WEREBEAST_HEALTH, DEFAULT_WEREBEAST_ATTACK, DEFAULT_WEREBEAST_ARMOR);
    }


    @Override
    public boolean hurtToBleeding(Hero hero) {
        if (Methods.getTrueClassName(hero).equals("UndeadKnight")) {
            return false;
        }
        Random rand = new Random();
        int k = rand.nextInt(100) + 1;
        if (k > 0 && k < CAUSE_BLEEDING_CHANCE * 100) {
            System.out.print(name + " вызывает кровотичение у " + hero.toStringNameAndRace() + ". ");
            hero.bleedDamage = BLEEDING_DAMAGE;
            return true;
        }
        return false;
    }


    /**
     * Переопределенный для зверочеловека метод получения имени и расы персонажа
     */
    @Override
    public String toStringNameAndRace() {
        return "Зверочеловек " + name;
    }


    /**
     * Переопределенный для зверочеловека метод получения всей информации про персонажа
     */
    @Override
    public String toString() {
        return "Зверочеловек " + name + super.toString();
    }
}
