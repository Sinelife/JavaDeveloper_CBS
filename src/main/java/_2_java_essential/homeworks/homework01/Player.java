package _2_java_essential.homeworks.homework01;

/**
 * Клас необходимый для создания обькта типа игрок(Player).
 * Игрок имеет игровое поле(Board), булевое поле isComputer(которое показывает являеться ли
 * игрок компьютером или нет)
 * Также в класе находяться все методы нужные для игры(для расстановки
 * кораблей, для проверки удачен ли выстрел, для проверки не выходит
 * ли выстрел за преелы поля,для выстрела и т.д.)
 */

public class Player {
    private Board board;
    private boolean isComputer;

    public Player(int height, int width, int shipNumber, boolean isComputer) {
        this.board = new Board(height, width, shipNumber);
        this.isComputer = isComputer;
    }

    public boolean isComputer() {
        return isComputer;
    }

    /**
     * Метод, который проверяет пустая ли ячейка игрового поля(BoardBox)
     */
    public boolean checkIfBoardBoxIsEmpty(int x, int y) {
        for (BoardBox boardBox : board.getBoardBoxes()) {
            if (boardBox.getX() == x && boardBox.getY() == y
                    && !(boardBox.getStatus().equals("Empty"))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод, который проверяет не производиться ли выстрел в место куда
     * уже стреляли
     */
    public boolean checkIfShootNotRepeatInSamePlace(int x, int y) {
        for (BoardBox boardBox : board.getBoardBoxes()) {
            boolean isEnemyDestroyedShip = boardBox.getStatus().equals("Destroyed Enemy Ship");
            boolean isPersonDestroyedShip = boardBox.getStatus().equals("Destroyed Person Ship");
            boolean isAlreadyFired = boardBox.getStatus().equals("Already Fired");
            if (boardBox.getX() == x && boardBox.getY() == y
                    && (isAlreadyFired
                    || isEnemyDestroyedShip
                    || isPersonDestroyedShip)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод, который проверяет попал ли выстрел в корабль
     */
    public boolean checkIfShootWasLuck(int x, int y) {
        for (Ship ship : board.getShips()) {
            if (ship.getX() == x && ship.getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод, который проверяет не задали ли координаты, которые выходят за
     * границы игрового поля
     */
    public boolean checkIfNotOnBoard(int x, int y) {
        if (x < 1 || x > board.getWidth()) {
            return true;
        }
        if (y < 1 || y > board.getHeight()) {
            return true;
        }
        return false;
    }

    /**
     * Метод, который проверяет не попал ли выстрел рядом с кораблем
     */
    public boolean checkIfShootIsNearShip(int x, int y) {
        for (Ship ship : board.getShips()) {
            if (ship.isAlive()
                    && ((ship.getX() == (x + 1) && ship.getY() == y)
                    || (ship.getX() == (x + 1) && ship.getY() == (y + 1))
                    || (ship.getX() == (x + 1) && ship.getY() == (y - 1))
                    || (ship.getX() == (x - 1) && ship.getY() == y)
                    || (ship.getX() == (x - 1) && ship.getY() == (y + 1))
                    || (ship.getX() == (x - 1) && ship.getY() == (y - 1))
                    || (ship.getX() == x && ship.getY() == (y - 1))
                    || (ship.getX() == x && ship.getY() == (y + 1)))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод, который меняет статус ячейки игрового поля
     */
    public void changeBoardBoxStatus(int x, int y, String newStatus) {
        for (BoardBox boardBox : board.getBoardBoxes()) {
            if (boardBox.getX() == x && boardBox.getY() == y) {
                boardBox.setStatus(newStatus);
            }
        }
    }

    /**
     * Метод, который меняет статус корабля(помечает корабль как убитый)
     */
    public void changeShipStatus(int x, int y) {
        for (Ship ship : board.getShips()) {
            if (ship.getX() == x && ship.getY() == y) {
                ship.setAlive(false);
            }
        }
    }


    /**
     * Метод, который подсчитывает количество живых кораблей
     */
    public int countShips() {
        int count = 0;
        for (Ship ship : board.getShips()) {
            if (ship.isAlive()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Метод, который размещает корабль на игровом поле
     */
    public Ship placeShip(boolean isComputer) {
        int x;
        int y;
        while (true) {
            x = Methods.inputCoordinate(isComputer, 'x');
            y = Methods.inputCoordinate(isComputer, 'y');
            if (checkIfNotOnBoard(x, y)) {
                System.out.println("Вы вышли за границы поля. Повторите ввод.");
            } else if (checkIfBoardBoxIsEmpty(x, y)) {
                break;
            } else if (!isComputer) {
                System.out.println("В этом месте уже есть корабль. Выберите другую ячейку.");
            }
        }
        Ship ship = new Ship(x, y);
        if (isComputer) {
            changeBoardBoxStatus(x, y, "Enemy Ship");
        } else {
            changeBoardBoxStatus(x, y, "Person Ship");
            outputBoard();
        }
        return ship;
    }

    /**
     * Метод, который размещает все корабли на игровом поле
     */
    public void placePlayerShips(boolean isComputer) {
        if (!isComputer) {
            System.out.println("\n\nНачало Расстановки Кораблей");
        }
        for (int i = 0; i < board.getShips().length; i++) {
            board.getShips()[i] = placeShip(isComputer);
        }
    }

    /**
     * Метод, который меняет после выстрела статус ячейки игрового поля
     * и если надо меняет статус корабля(isAlive)
     */
    public void changeStatusOfBoardBoxAndShip(int x, int y, boolean isComputer) {
        if (checkIfShootWasLuck(x, y) && isComputer) {
            changeBoardBoxStatus(x, y, "Destroyed Person Ship");
            changeShipStatus(x, y);
            System.out.println("Враг уничтожил ваш корабль.");
        } else if (checkIfShootWasLuck(x, y) && !isComputer) {
            changeBoardBoxStatus(x, y, "Destroyed Enemy Ship");
            changeShipStatus(x, y);
            System.out.println("Вы уничтожили корабль врага.");
        } else if (!checkIfShootWasLuck(x, y) && isComputer) {
            changeBoardBoxStatus(x, y, "Already Fired");
            System.out.println("Враг промахнулся.");
        } else if (checkIfShootIsNearShip(x, y) && !isComputer) {
            changeBoardBoxStatus(x, y, "Already Fired");
            System.out.println("Вы промахнулись.Но были близко.");
        } else {
            changeBoardBoxStatus(x, y, "Already Fired");
            System.out.println("Вы промахнулись.");
        }
    }

    /**
     * Метод, который производит выстрел игроком по полю противника
     */
    public void shot(boolean isComputer) {
        int x;
        int y;
        while (true) {
            x = Methods.inputCoordinate(isComputer, 'x');
            y = Methods.inputCoordinate(isComputer, 'y');
            if (checkIfNotOnBoard(x, y)) {
                System.out.println("Вы вышли за пределы поля. Повторите ввод.");
            } else if (checkIfShootNotRepeatInSamePlace(x, y)) {
                break;
            } else if (!isComputer) {
                System.out.println("В это место уже стреляли. Выберите другую ячейку.");
            }
        }
        changeStatusOfBoardBoxAndShip(x, y, isComputer);
        if (isComputer) {
            System.out.println("Ваше поле: ");
        } else {
            System.out.println("Поле врага: ");
        }
        outputBoard();
    }

    /**
     * Метод, который выводит игровое поле
     */
    public void outputBoard() {
        for (BoardBox boardBox : board.getBoardBoxes()) {
            if (boardBox.getY() == 1 && boardBox.getX() != 1) {
                System.out.print("\n");
            }
            if (boardBox.getStatus().equals("Empty")) {
                System.out.print("- ");
            }
            if (boardBox.getStatus().equals("Enemy Ship")) {
                System.out.print("- ");
            }
            if (boardBox.getStatus().equals("Person Ship")) {
                System.out.print("X ");
            }
            if (boardBox.getStatus().equals("Already Fired")) {
                System.out.print("* ");
            }
            if (boardBox.getStatus().equals("Destroyed Enemy Ship")) {
                System.out.print("X ");
            }
            if (boardBox.getStatus().equals("Destroyed Person Ship")) {
                System.out.print("* ");
            }
        }
        System.out.print("\n\n");
    }
}
