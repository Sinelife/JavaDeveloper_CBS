package _2_java_essential.homeworks.homework01;


/**
 * Клас необходимый для создания обьктов типа Ship(корабль)
 * Каждый корабль имеет кординаты по оси х, у и булевое поле,
 * которая показывает жив ли корабль
 * (Сетеры для координат отсутвуют так как нет необходимости
 * менять расположение кораблей)
 */

public class Ship {
    private int x;
    private int y;
    private boolean isAlive;


    public Ship(int x, int y) {
        this.x = x;
        this.y = y;
        this.isAlive = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

}
