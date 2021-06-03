package _2_java_essential.homeworks.homework01;

/**
 * Клас самой игры ShipBattle, в которо есть метод run()
 * в котором и проходит сам процес игры(растановка кораблей игроком-человеком,
 * растановка кораблей компьютером и последовательные обсрелы игроками полей
 * друг друга до победы)
 * Также в класе есть методы возвращающий число кораблей игрока и
 * метод проверяющий не победил ли ктото из игроков
 */

public class ShipBattle {

    static void run() {
        int height = Methods.inputStartParameter("Введите ширину игрового поля: ");
        int width = Methods.inputStartParameter("Введите высоту игрового поля: ");
        int shipNumber = Methods.inputStartParameter("Введите количество кораблей: ");
        Player person = new Player(height, width, shipNumber, false);
        person.placePlayerShips(false);
        Player computer = new Player(height, width, shipNumber, true);
        computer.placePlayerShips(true);
        System.out.println("\n\nНачало Боя!!");
        while (true) {
            if (checkIfPlayerWon(person, computer)) {
                break;
            }
            computer.shot(false);
            if (checkIfPlayerWon(person, computer)) {
                break;
            }
            person.shot(true);
            System.out.println(outputShipBalance(person));
            System.out.println(outputShipBalance(computer));
        }
    }


    /**
     * Метод, который правильно выводит количество кораблей
     */
    public static String outputShipBalance(Player player) {
        String result = "У ";
        int shipNumber = player.countShips();
        if (player.isComputer()) {
            result += " врага ";
        } else {
            result += " вас ";
        }
        result += "осталось " + shipNumber;
        if (shipNumber > 1 && shipNumber < 5) {
            result += " корабля.";
        } else if (shipNumber == 1) {
            result += " корабль.";
        } else {
            result += " кораблей.";
        }
        return result;
    }

    /**
     * Метод, который проверяет победил ли ктото из двух игроков
     */
    public static boolean checkIfPlayerWon(Player person, Player computer) {
        boolean isGameEnd = false;
        if (computer.countShips() == 0) {
            System.out.println("Вы уничтожили вражеский флот.Вы победили!!");
            isGameEnd = true;
        }
        if (person.countShips() == 0) {
            System.out.println("Ваш флот был уничтожен. Вы проиграли...");
            isGameEnd = true;
        }
        return isGameEnd;
    }
}
