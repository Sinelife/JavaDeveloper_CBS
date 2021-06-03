package _2_java_essential.homeworks.homework02;

import java.util.Random;

/**
 * Клас DarkElf позволяет создавать обьекты типа DarkElf
 * Уникальная особенность темных эльфов это возможность отравить врага.
 * Вероятность отравления определяет константа POISONING_CHANCE, урон от яда
 * определяет константа POISON_DAMAGE, а количество ходов, которые действует яд
 * определяет переменная POISON_DURATION
 */


public class DarkElf extends Elf {

    private static final int DEFAULT_DARK_ELF_HEALTH = 250;
    private static final int DEFAULT_DARK_ELF_ATTACK = 70;
    private static final int DEFAULT_DARK_ELF_ARMOR = 15;

    private static final double POISONING_CHANCE = 0.25;
    private static final int POISON_DAMAGE = 20;
    private static final int POISON_DURATION = 4;

    public DarkElf(String name) {
        super(name, DEFAULT_DARK_ELF_HEALTH, DEFAULT_DARK_ELF_ATTACK, DEFAULT_DARK_ELF_ARMOR);
        this.isPoisonous = true;
    }


    /**
     * Метод проверяющий удалось ли отравить
     */
    @Override
    public boolean hurtToPoisoning(Hero hero) {
        if (Methods.getTrueClassName(hero).equals("UndeadKnight")) {
            return false;
        }
        Random rand = new Random();
        int k = rand.nextInt(100) + 1;
        if (k > 0 && k < POISONING_CHANCE * 100) {
            System.out.print(toStringNameAndRace() + " отравляет " + hero.toStringNameAndRace() + ". ");
            hero.poisoningDamage = POISON_DAMAGE;
            hero.poisoningDamageDuration = POISON_DURATION;
            return true;
        }
        return false;
    }


    /**
     * Переопределенный для темного эльфа метод получения имени и расы персонажа
     */
    @Override
    public String toStringNameAndRace() {
        return "Темный Эльф " + name;
    }

    /**
     * Переопределенный для темного эльфа метод получения всей информации про персонажа
     */
    @Override
    public String toString() {
        return "Темный Эльф " + name + super.toString();
    }

}
