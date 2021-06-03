package _2_java_essential.homeworks.homework01;


/**
 * Клас необходимый для создания обьктов типа Board(игровое поле)
 * Игровое поле имеет ширину, высоту, количество кораблей, масив ячеек
 * игрового поля(BoardBox[]) и масив кораблей(Ship[])
 * Высота поля, ширина поля и количество кораблей передаються в конструктор
 * как параметры.
 * Масив кораблей создается прям в конструторе(его размер
 * равен количнству кораблей).
 * Масив ячеек поля создаеться также в конструкторе(его размер равен
 * произведению ширины и высоты игрового поля)
 * Ячейки игрового поля инициализируються прямо в конструкторе с помощью
 * метода initializeBoard(board)
 */

public class Board {
    private Ship[] ships;
    private int height;
    private int width;
    private BoardBox[] boardBoxes;
    private int shipNumber;

    public Board(int height, int width, int shipNumber) {
        this.height = height;
        this.width = width;
        this.ships = new Ship[shipNumber];
        this.boardBoxes = initializeBoard();
        this.shipNumber = shipNumber;
    }

    public BoardBox[] initializeBoard() {
        int counter = 0;
        BoardBox[] boardBoxes = new BoardBox[this.height * this.width];
        for (int i = 1; i <= this.width; i++) {
            for (int j = 1; j <= this.height; j++) {
                boardBoxes[counter] = new BoardBox(i, j);
                counter++;
            }
        }
        return boardBoxes;
    }


    public Ship[] getShips() {
        return ships;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public BoardBox[] getBoardBoxes() {
        return boardBoxes;
    }


}
