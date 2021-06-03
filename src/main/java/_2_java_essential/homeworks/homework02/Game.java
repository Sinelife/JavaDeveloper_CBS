package _2_java_essential.homeworks.homework02;


/**
 * Клас Game это клас в котором непосредствено и происходят все этапы игры(создание
 * перснажей обоими игроками и сама битва между ними). Вся игра происходит
 * в методе run()
 */

public class Game {
    public static void run() {
        System.out.println("Выберите кем будет второй игрок(введите 1 - если человек, 2 - если компьютер): ");
        int role = Methods.inputParameter(0, 2);

        String firstPlayerName = Methods.inputParameter("Введите имя первого игрока: ");
        System.out.print("Введите размер отряда: ");
        int squadSize = Methods.inputParameter(0, 100);
        Player playerOne = new Player(squadSize, firstPlayerName);
        playerOne.addHeroes();
        playerOne.outputSquadInformation();

        Player playerTwo;
        if (role == 1) {
            String secondPlayerName = Methods.inputParameter("Введите имя второго игрока: ");
            playerTwo = new Player(squadSize, secondPlayerName);
        } else {
            playerTwo = new Player(squadSize);
        }
        playerTwo.addHeroes();
        playerTwo.outputSquadInformation();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        playerOne.fight(playerOne, playerTwo);
    }


}
