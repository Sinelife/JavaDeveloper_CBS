package _2_java_essential.homeworks.homework01;

/**
 * Клас необходимый для создания обьктов типа BoardBox(ячейка игрового поля)
 * Каждый ячейка имеет кординаты по оси х, у и строковое поле статус.
 * Статус показывает в каком состоянии ячейка:
 * 1)"Empty" - пустая ячейка
 * 2)"Person Ship" - корабль игрока-человека
 * 3)"Enemy Ship" - корабль компьютера
 * 4)"Destroyed Person Ship" - уничтоженый корабль игрока-человека
 * 5)"Destroyed Enemy Ship" - уничтоженый корабль компьютера
 * 6)"Already Fired" - пустая ячейка, по которой уже был произведен выстрел
 * (Сетеры для координат отсутвуют так как нет необходимости
 * менять координаты ячеек. Меняеться лишь статус)
 */

public class BoardBox {
    private int x;
    private int y;
    private String status;

    BoardBox(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = "Empty";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
