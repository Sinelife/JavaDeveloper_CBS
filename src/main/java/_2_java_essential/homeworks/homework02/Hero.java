package _2_java_essential.homeworks.homework02;


/**
 * Абстрактный Клас Hero это родительский клас для класов всех рас. Обьекты
 * этого класа имеютполя имени, здоровья, брони и атаки. Также он имеет
 * реализованые и не реализованые методы, часть из которых потом наследуют
 * некоторые его наследники.
 */

public abstract class Hero {

    protected String name;
    protected boolean isAlive;
    protected int health;
    protected int attack;
    protected int armor;
    protected int bleedDamage;
    protected int poisoningDamage;
    protected int poisoningDamageDuration;
    protected boolean isPoisonous = false;


    public Hero(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }

    /**
     * Метод для получения имени персонажа
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для изменения имени персонажа
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Метод для снижения здоровья персонажа от кровотечения
     */
    public void takeDamageFromBleeding() {
        if (bleedDamage > 0) {
            System.out.print("Изза кровотечения здоровье у " + toStringNameAndRace() + " падает с " + health + " до ");
            health -= bleedDamage;
            if (health < 0) {
                health = 0;
            }
            System.out.println(health + ". ");
            bleedDamage -= 10;
        }
    }


    /**
     * Метод для снижения здоровья персонажа от отравления
     */
    public void takeDamageFromPoisoning() {
        if (poisoningDamageDuration > 0) {
            System.out.print("Изза яда здоровье у " + toStringNameAndRace() + " падает с " + health + " до ");
            health -= poisoningDamage;
            if (health < 0) {
                health = 0;
            }
            System.out.println(health + ". ");
            poisoningDamageDuration--;
        }
    }

    /** Метод для получения здоровья персонажа */
    public int getHealth() {
        if (health < 0) {
            health = 0;
        }
        return health;
    }

    /** Метод для изменения здоровья персонажа */
    public void setHealth(int health) {
        this.health = health;
    }

    /** Метод для получения брони персонажа */
    public int getArmor() {
        return armor;
    }

    /** Метод для изменения брони персонажа */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * Метод для получения атаки персонажа(будет пеореопределен)
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Метод для получения брони противника после ее поломки(будет пеореопределен)
     */
    public int getArmorAfterDestruction(int armor) {
        return armor;
    }

    /**
     * Метод сообщающий удалось ли персонажу уклониться от удара(будет пеореопределен)
     */
    public boolean isDodge() {
        return false;
    }

    /**
     * Метод для получения атаки врага после частичной блокировки этой атаки(будет пеореопределен)
     */
    public int getAttackAfterBlock(int attack) {
        return attack;
    }

    /** Метод для вывода рассы и имени(будет пеореопределен) */
    public abstract String toStringNameAndRace();

    /**
     * Метод для возрождения персонажа(будет пеореопределен)
     */
    public void resurrect() {
    }

    /**
     * Метод проверяющий удалось ли вызвать кровточение(будет переопределен)
     */
    public boolean hurtToBleeding(Hero hero) {
        return false;
    }

    /**
     * Метод проверяющий удалось ли отравить(будет переопределен)
     */
    public boolean hurtToPoisoning(Hero hero) {
        return false;
    }

    /** Метод для вывода информации про персонажа(будет пеореопределен) */
    public String toString() {
//        return "[health: " + health + ", armor: " + armor + ", attack: " + attack + "]";
        return String.format("[health: %s, armor: %s, attack: %s]", health, armor, attack);
    }

}
