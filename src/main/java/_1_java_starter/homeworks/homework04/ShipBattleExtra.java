package _1_java_starter.homeworks.homework04;

import java.util.Random;
import java.util.Scanner;

public class ShipBattleExtra {

    private static int shipNum = 4;


    private static void outputNumberOfShips(int shipNum, String role) {
        if (role.equals("you")) {
            System.out.print("У вас осталось " + shipNum);
        } else {
            System.out.print("У врага осталось " + shipNum);
        }


        if (shipNum > 4) {
            System.out.println(" кораблей");
        } else if (shipNum > 1 || shipNum == 0) {
            System.out.println(" корабля");
        } else {
            System.out.println(" корабль");
        }
    }

    //Метод для вывода поля(в случае поля врага корабли не должны быть видны
    // до выстрела. Для сокрытия кораблей по желанию и введена переменная hidden
    private static void outputField(int field[][], boolean hidden) {
        for (int i = 0; i < field.length; i++) {
            System.out.println();
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 0) {
                    System.out.print("- ");
                } else if (field[i][j] == 1) {
                    if (hidden) {
                        System.out.print("- ");
                    } else {
                        System.out.print("X ");
                    }
                } else if (field[i][j] == 3) {
                    System.out.print("X ");
                } else {
                    System.out.print("* ");
                }
            }
        }
        System.out.println();
    }


    //Метод для размещения кораблей играком
    private static void placeYourShips(int[][] yourField, int shipNum) {
        Scanner sc = new Scanner(System.in);
        int shipCounter = shipNum;
        System.out.println("Расстановка вашего флота.");
        while (true) {
            System.out.print("Введите номер строки: ");
            int shipCoordinateY = sc.nextInt() - 1;
            System.out.print("Введи номер столбца: ");
            int shipCoordinateX = sc.nextInt() - 1;
            shipCounter = decrementCounterIfPlaceNotRepeat(yourField, shipCoordinateX, shipCoordinateY, shipCounter, true);
            if (shipCounter == 0) {
                break;
            }
            outputField(yourField, false);
        }
    }

    //Метод для размещения кораблей компьютером
    private static void placeEnemyShips(int[][] enemyField, int shipNum) {
        Random rand = new Random();
        int shipCounter = shipNum;
        while (true) {
            int shipCoordinateY = rand.nextInt(shipNum);
            int shipCoordinateX = rand.nextInt(shipNum);
            //System.out.println(shipCoordinateX + " ");
            //System.out.println(shipCoordinateY + "\n");
            shipCounter = decrementCounterIfPlaceNotRepeat(enemyField, shipCoordinateX, shipCoordinateY, shipCounter, false);
            if (shipCounter == 0) {
                break;
            }
        }
    }

    //Метод уменшающий счетчик кораблей если проверка на свободную ячейку прошла успешно
    private static int decrementCounterIfPlaceNotRepeat(int field[][], int x, int y, int shipCounter, boolean outputMessage) {
        if ((y > (shipNum - 1)) || (x > (shipNum - 1))) {
            System.out.println("Ви вышли за пределы поля.Повторите ввод заново.");
        } else if (field[y][x] != 1 && field[y][x] != 3) {
            field[y][x] = 1;
            return shipCounter - 1;
        } else if (outputMessage) {
            System.out.println("В этой ячейке уже есть корабль. выберите другую ячейку.");
        }
        return shipCounter;
    }


    //Метод проверяющий не попал ли снаряд в ячейку находящуюся рядом с
    //кораблем(на одну ячейку сверху, снизу, справа или слева)
    private static boolean checkIfShipNear(int[][] enemyField, int x, int y) {
        if (x > 0) {
            if (enemyField[y][x - 1] == 1) {
                return true;
            }
        }
        if (x < enemyField.length - 1) {
            if (enemyField[y][x + 1] == 1) {
                return true;
            }
        }
        if (y > 0) {
            if (enemyField[y - 1][x] == 1) {
                return true;
            }
        }
        if (y < enemyField[0].length - 1) {
            if (enemyField[y + 1][x] == 1) {
                return true;
            }
        }
        return false;
    }

    //Метод для проверки не стреляют ли в одну и туже ячейку повторно
    private static boolean checkIfShootRepeatInSamePlace(int field[][], int x, int y, boolean outputMessage) {
        if ((y > (shipNum - 1)) || (x > (shipNum - 1))) {
            System.out.println("Ви вышли за пределы поля.Повторите ввод заново.");
            return false;
        } else if ((field[y][x] == 2 || field[y][x] == 3) && outputMessage) {
            System.out.println("Сюда уже стреляли.Выберите другую ячейку");
            return false;
        } else {
            return true;
        }
    }

    //Метод уменшающий счетчик кораблей если снаряд попал по кораблю
    private static int decrementCounterIfShootSuccessfully(int field[][], int x, int y, int shipCounter, String role) {
        if (field[y][x] == 1) {
            shipCounter--;
            if (role.equals("you")) {
                field[y][x] = 3;
                System.out.print("Вражеский корабль уничтожен!! ");
            } else {
                field[y][x] = 2;
                System.out.print("Враг уничтожил ваш корабль!!");
            }
            return shipCounter;
        } else if (checkIfShipNear(field, x, y)) {
            field[y][x] = 2;
            if (role.equals("you")) {
                System.out.print("Вы промахнулись но были близко.");
            } else {
                System.out.print("Враг промахнулся.");
            }
            return shipCounter;
        } else {
            field[y][x] = 2;
            if (role.equals("you")) {
                System.out.print("Вы промахнулись. ");
            } else {
                System.out.print("Враг промахнулся.");
            }
        }
        return shipCounter;
    }


    //Метод для произведения выстрела игроком и возвращения количества кораблей,
    //которые остались у врага
    private static int decrementCounterIfYouShootSuccessfully(int[][] enemyField, int enemyNum) {
        Scanner sc = new Scanner(System.in);
        int x;
        int y;
        while (true) {
            System.out.print("\nВведите номер строки: ");
            y = sc.nextInt() - 1;
            System.out.print("Введите номер столбца: ");
            x = sc.nextInt() - 1;
            boolean isChecked = checkIfShootRepeatInSamePlace(enemyField, x, y, true);
            if (isChecked) {
                break;
            }
        }
        enemyNum = decrementCounterIfShootSuccessfully(enemyField, x, y, enemyNum, "you");
        return enemyNum;
    }

    //Метод для произведения выстрела врагом и возвращения количества корабей,
    // которые остались у игрока
    private static int decrementCounterIfEnemyShootSuccessfully(int[][] yourField, int yourNum) {
        Random rand = new Random();
        int x;
        int y;
        while (true) {
            y = rand.nextInt(4);
            x = rand.nextInt(4);
            //System.out.println(x + " ");
            //System.out.println(y + "\n");
            boolean isChecked = checkIfShootRepeatInSamePlace(yourField, x, y, false);
            if (isChecked) {
                break;
            }
        }
        yourNum = decrementCounterIfShootSuccessfully(yourField, x, y, yourNum, "enemy");
        return yourNum;
    }


    public static void main(String[] args) {
        int[][] yourField = new int[shipNum][shipNum];
        int[][] enemyField = new int[shipNum][shipNum];

        placeYourShips(yourField, shipNum);
        placeEnemyShips(enemyField, shipNum);

        int enemyNum = shipNum;
        int yourNum = shipNum;
        while (true) {
            System.out.print("\n\nПоле врага ");
            outputField(enemyField, true);
            System.out.print("\nВаше поле ");
            outputField(yourField, false);
            outputNumberOfShips(yourNum, "you");
            outputNumberOfShips(enemyNum, "enemy");

            enemyNum = decrementCounterIfYouShootSuccessfully(enemyField, enemyNum);
            if (enemyNum == 0) {
                System.out.println("Вы уничтожили флот врага.Вы победили!!!");
                break;
            }
            yourNum = decrementCounterIfEnemyShootSuccessfully(yourField, yourNum);
            if (yourNum == 0) {
                System.out.println("Враг уничтожил ваш флот.Вы проиграли.....");
                break;
            }
        }
    }
}

