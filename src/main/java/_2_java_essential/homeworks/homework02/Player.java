package _2_java_essential.homeworks.homework02;

import java.util.Random;
import java.util.Scanner;


/**
 * Клас Player создает игроков.
 * Каждый игрок имеет масив персонажей и булевое поле, которое показывает являеться
 * ли игрок компьютером или человеком-игроком.
 * В этом класе также содержиться множество методов необходимых для игры(создание
 * персонажей компьютером и человком, атака персонажами друг друга и т.д)
 * Ниже будут коментарии к каждому методу.
 */

public class Player {
    private Hero[] heroes;
    private boolean isComputer;
    private String playerName;

    /**
     * Конструктор для создания игрока-компьютера
     */
    public Player(int squadSize) {
        this.heroes = new Hero[squadSize];
        this.isComputer = true;
        this.playerName = "КОМПЬЮТЕР";
    }

    /**
     * Конструктор для создания игрока-человека
     */
    public Player(int squadSize, String playerName) {
        this.heroes = new Hero[squadSize];
        this.isComputer = false;
        this.playerName = playerName;
    }

    public Hero[] getHeroes() {
        return heroes;
    }

    public int getSquadSize() {
        return heroes.length;
    }

    /**
     * Метод, снижающий броню защищаегося воина
     */
    public void armorDestruct(Hero attacker, Hero defender) {
        if (attacker instanceof Demon) {
            defender.setArmor(attacker.getArmorAfterDestruction(defender.getArmor()));
        }
    }

    /**
     * Метод, возвращающий true если персонаж увернулся от удара
     */
    public boolean dodgeFromAttack(Hero defender) {
        if (defender instanceof Orc) {
            return defender.isDodge();
        }
        return false;
    }

    /**
     * Метод, возвращающий атаку после блокировки
     */
    public int getEnemyAttackAfterBlock(Hero attacker, Hero defender) {
        int attackPower = attacker.getAttack();
        if (defender instanceof Dwarf) {
            attackPower = defender.getAttackAfterBlock(attackPower);
        }
        return attackPower;
    }

    /**
     * Метод, возвращающий true если атакующий вызвал кровотичение у защищаегося
     */
    public void hurtToBleeding(Hero attacker, Hero defender) {
        if (attacker instanceof Werebeast) {
            attacker.hurtToBleeding(defender);
        }
    }

    /**
     * Метод, возвращающий true если атакующий отравил защищаегося
     */
    public void hurtToPoisoning(Hero attacker, Hero defender) {
        if (attacker.isPoisonous()) {
            attacker.hurtToPoisoning(defender);
        }
    }


    /**Метод, возвращаюший персонажа созданого человеком */
    public Hero addHeroForPerson() {
        Scanner sc = new Scanner(System.in);
        Hero hero = null;
        while (true) {
            System.out.println("Выберите клас воина: ");
            for (int i = 0; i < Constants.RACES.length; i++) {
                System.out.println((i + 1) + ") " + Constants.RACES[i]);
            }
            int raceNumber = Methods.inputParameter(0, Constants.RACES.length);
            System.out.println("Дайте воину имя: ");
            String name = sc.next();
            switch (raceNumber) {
                case 1:
                    hero = new Human(name);
                    break;
                case 2:
                    hero = new ForestElf(name);
                    break;
                case 3:
                    hero = new DarkElf(name);
                    break;
                case 4:
                    hero = new Dwarf(name);
                    break;
                case 5:
                    hero = new Orc(name);
                    break;
                case 6:
                    hero = new Demon(name);
                    break;
                case 7:
                    hero = new UndeadKnight(name);
                    break;
                case 8:
                    hero = new Werebeast(name);
                    break;
            }
            if (hero == null) {
                System.out.println("Такого номера расы нет.Повторите ввод.");
            } else {
                break;
            }
        }
        return hero;
    }

    /**Метод, возвращаюший персонажа созданого компьютером */
    public Hero addHeroForComputer() {
        Random rand = new Random();
        Hero hero = null;
        while (true) {
            int raceNumber = rand.nextInt(6) + 1;
            switch (raceNumber) {
                case 1:
                    String name = Methods.getRandomHeroNameFromArray(Constants.HUMAN_NAMES);
                    hero = new Human(name);
                    break;
                case 2:
                    name = Methods.getRandomHeroNameFromArray(Constants.FOREST_ELF_NAMES);
                    hero = new ForestElf(name);
                    break;
                case 3:
                    name = Methods.getRandomHeroNameFromArray(Constants.DARK_ELF_NAMES);
                    hero = new DarkElf(name);
                    break;
                case 4:
                    name = Methods.getRandomHeroNameFromArray(Constants.DWARF_NAMES);
                    hero = new Dwarf(name);
                    break;
                case 5:
                    name = Methods.getRandomHeroNameFromArray(Constants.ORC_NAMES);
                    hero = new Orc(name);
                    break;
                case 6:
                    name = Methods.getRandomHeroNameFromArray(Constants.DEMON_NAMES);
                    hero = new Demon(name);
                    break;
                case 7:
                    name = Methods.getRandomHeroNameFromArray(Constants.UNDEAD_NAMES);
                    hero = new UndeadKnight(name);
                    break;
                case 8:
                    name = Methods.getRandomHeroNameFromArray(Constants.WEREBEAST_NAMES);
                    hero = new Werebeast(name);
                    break;
            }
            if (hero != null) {
                break;
            }
        }
        return hero;
    }

    /**Метод, возвращаюший персонажа созданого человеком или компьютером
     * в зависимости от переменной isComputer */
    public Hero addHero() {
        Hero hero;
        if (isComputer) {
            hero = addHeroForComputer();
        } else {
            hero = addHeroForPerson();
        }
        return hero;
    }

    /**Метод, добавляющий всех созданных персоажей в масив персонажей */
    public void addHeroes() {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i] = addHero();
        }
    }

    /**Метод, пересоздающий отряд если в нем есть погибший воин(уже без погибшего) */
    public void reformSquad() {
        if (checkIfSquadHasFallenHero()) {
            Hero[] newHeroes = new Hero[heroes.length - 1];
            int counter = 0;
            for (Hero hero : heroes) {
                if (hero.getName() != null) {
                    newHeroes[counter] = hero;
                    counter++;
                }
            }
            heroes = newHeroes;
        }
    }

    /**Метод, помечающий персонажа как мертвого */
    public void dieIfNoHealth(Hero hero) {
        if (hero.getHealth() <= 0) {
            System.out.print(hero.toStringNameAndRace() + " погибает.");
            if (Methods.getTrueClassName(hero).equals("UndeadKnight")) {
                hero.resurrect();
            }
            if (hero.getHealth() <= 0) {
                hero.setName(null);
            }
        }
    }

    /*Метод, проверяющий не уничтожен ли весь отряд игрока */
    /*public boolean checkIfSquadIsDead() {
        for (Hero hero : heroes) {
            if (hero.getName() != null) {
                return false;
            }
        }
        return true;
    }*/

    /**Метод, проверяющий есть ли в отряде погибший воин */
    public boolean checkIfSquadHasFallenHero() {
        for (Hero hero : heroes) {
            if (hero.getName() == null) {
                return true;
            }
        }
        return false;
    }

    /**Метод, реализующий атаку одним персонажем другого */
    public void heroAttackHero(Hero attacker, Hero defender) {
        do {
            attacker.takeDamageFromBleeding();
            attacker.takeDamageFromPoisoning();
            if (attacker.getHealth() <= 0) {
                dieIfNoHealth(attacker);
                break;
            }
            int attackPower = getEnemyAttackAfterBlock(attacker, defender);
            System.out.print(attacker.toStringNameAndRace() + " наносит урон " + attackPower + ". ");
            if (dodgeFromAttack(defender)) {
                break;
            }
            System.out.print("Здоровье " + defender.toStringNameAndRace() + " падает с " + defender.getHealth());
            int newHealth = defender.getHealth() + defender.getArmor() - attackPower;
            defender.setHealth(newHealth);
            System.out.println(" до " + defender.getHealth() + ". ");
            hurtToBleeding(attacker, defender);
            hurtToPoisoning(attacker, defender);
            armorDestruct(attacker, defender);
            if (defender.getHealth() <= 0) {
                dieIfNoHealth(defender);
            }
        } while(false);
    }

    /**Метод, реализующий выбор кого будет атаковать персонаж человека и саму атаку */
    public void personHeroAttack(Hero personHero, Player computer) {
        computer.reformSquad();
        System.out.println("Ходит ваш герой " + personHero.toStringNameAndRace());
        int enemyNum;
        while (true) {
            //computer.outputSquadInformation();
            System.out.print("Введите номер врага, которого хотите атаковать: ");
            enemyNum = Methods.inputParameter(0, computer.getSquadSize()) - 1;
            if (enemyNum < 0 || enemyNum > computer.getHeroes().length) {
                System.out.println("Вы вибрали неверный номер. Повторите ввод.");
            } else {
                break;
            }
        }
        heroAttackHero(personHero, computer.getHeroes()[enemyNum]);
        computer.reformSquad();
    }

    /**Метод, реализующий выбор кого будет атаковать персонаж компьютера и саму атаку */
    public void computerHeroAttack(Hero computerHero, Player person) {
        Random rand = new Random();
        System.out.println("Ходит герой врага " + computerHero.toStringNameAndRace());
        int yourNum;
        while (true) {
            yourNum = rand.nextInt(person.getHeroes().length);
            if (person.getHeroes()[yourNum] != null) {
                break;
            }
        }
        heroAttackHero(computerHero, person.getHeroes()[yourNum]);
        person.reformSquad();
    }

    /**
     * Метод, вызывающий метод удара от имени человека или компьютера в
     * зависимости от того кем являеться игрок(Компьютером или Человеком)
     */
    public void playerHeroAction(Player playerOne, MyInteger playerOneCounter, Player playerTwo) {
        System.out.println("\n-----------------------------------------------");
        if (playerOneCounter.getValue() < playerOne.getSquadSize()) {
            System.out.println("\n\t\tХОД " + playerOne.playerName);
            if (!playerOne.isComputer) {
                playerTwo.outputSquadInformation();
                playerOne.outputSquadInformation();
            }
            Hero hero = playerOne.getHeroes()[playerOneCounter.getValue()];
            if (!playerOne.isComputer) {
                personHeroAttack(hero, playerTwo);
            } else {
                computerHeroAttack(hero, playerTwo);
            }

            if (hero.getName() == null) {
                playerOne.reformSquad();
            } else {
                playerOneCounter.incrementValue();
            }
            if (playerTwo.checkIfSquadHasFallenHero()) {
                playerTwo.reformSquad();
            }
        }
    }

    /**
     * Метод, проверяющий походили ли все персонажи и потому пора ли
     * заканчивать раунд
     */
    public boolean checkIfEndOfRound(Player playerOne, MyInteger playerOneCounter, Player playerTwo, MyInteger playerTwoCounter) {
        if (playerOne.getSquadSize() == 0 || playerTwo.getSquadSize() == 0) {
            return true;
        }
        if (playerOneCounter.getValue() >= playerOne.getSquadSize()
                && playerTwoCounter.getValue() >= playerTwo.getSquadSize()) {
            return true;
        }
        return false;
    }

    /**Метод, реализующий битву в течении раунда(раунд длиться пока не походят
     * все персонажи) */
    public void round(Player playerOne, Player playerTwo) {
        MyInteger playerOneCounter = new MyInteger(0);
        MyInteger playerTwoCounter = new MyInteger(0);
        while (true) {
            if (checkIfEndOfRound(playerOne, playerOneCounter, playerTwo, playerTwoCounter)) {
                break;
            }
            playerHeroAction(playerOne, playerOneCounter, playerTwo);

            if (checkIfEndOfRound(playerOne, playerOneCounter, playerTwo, playerTwoCounter)) {
                break;
            }
            playerHeroAction(playerTwo, playerTwoCounter, playerOne);
        }
    }

    /**Метод, реализующий битву в течении всей игры(пока один из игроков не лишиться
     * всех бойцов) */
    public void fight(Player playerOne, Player playerTwo) {
        System.out.println("\t\tНАЧАЛО БОЯ!!");
        int roundCounter = 1;
        while (true) {
            if (playerOne.getSquadSize() == 0) {
                System.out.println("Отряд игрока " + playerOne.playerName + " уничтожен. Победил игрок " + playerTwo.playerName + "!!!!!!");
                break;
            }
            if (playerTwo.getSquadSize() == 0) {
                System.out.println("Отряд игрока " + playerTwo.playerName + " уничтожен. Победил игрок " + playerOne.playerName + "!!!!!!");
                break;
            }
            System.out.println("\n-----------------------------------------------");
            System.out.println("-----------------------------------------------");
            System.out.println("-----------------------------------------------");
            System.out.println("\t\tРАУНД № " + roundCounter);
            round(playerOne, playerTwo);
            roundCounter++;
        }
    }

    /**Метод, выводящий на екран информацию про весь отряд*/
    public void outputSquadInformation() {
        if (isComputer && heroes.length > 0) {
            System.out.println("\tВражеский отряд");
        }
        if (!isComputer && heroes.length > 0) {
            System.out.println("\tОтряд игрока " + playerName);
        }
        int counter = 1;
        for (Hero hero : heroes) {
            System.out.println("\t" + counter + ")" + hero.toString());
            counter++;
        }
        System.out.println();
    }
}


