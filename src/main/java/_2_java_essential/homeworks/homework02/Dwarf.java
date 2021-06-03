package _2_java_essential.homeworks.homework02;

import java.util.Random;

/**
 * Клас Dwarf позволяет создавать обьекты типа Dwarf
 * Уникальная особенность гномов это способность частично блокировать урон.
 * Вероятность блокировки урона определяет константа BLOCK_CHANCE, а часть
 * заблокировного урона от общего определяет константа BLOCK_PERCENT
 */


public class Dwarf extends Hero {
    private static final int DEFAULT_DWARF_HEALTH = 280;
    private static final int DEFAULT_DWARF_ATTACK = 65;
    private static final int DEFAULT_DWARF_ARMOUR = 30;

    private static final double BLOCK_CHANCE = 0.2;
    private static final double BLOCK_PERCENT = 0.3;


    public Dwarf(String name) {
        super(name, DEFAULT_DWARF_HEALTH, DEFAULT_DWARF_ATTACK, DEFAULT_DWARF_ARMOUR);
    }


    /**
     * Переопределенный для гнома метод для получения атаки врага после частичной
     * блокировки этой атаки
     */
    @Override
    public int getAttackAfterBlock(int attack) {
        Random rand = new Random();
        int k = rand.nextInt(100) + 1;
        if (k > 0 && k < BLOCK_CHANCE * 100) {
            System.out.print(toStringNameAndRace() + " блокирует " + (attack * BLOCK_PERCENT) + " урона. ");
            attack *= (1 - BLOCK_PERCENT);
        }
        return attack;
    }


    /**
     * Переопределенный для гнома метод получения имени и расы
     */
    @Override
    public String toStringNameAndRace() {
        return "Гном " + name;
    }


    /**
     * Переопределенный для гнома метод получения всей информации про персонажа
     */
    @Override
    public String toString() {
        return "Гном " + name + super.toString();
    }
}
