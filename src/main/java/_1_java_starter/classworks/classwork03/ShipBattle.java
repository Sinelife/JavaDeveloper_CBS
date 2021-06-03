package _1_java_starter.classworks.classwork03;

import java.util.Scanner;
import java.util.Random;

public class ShipBattle {

    //Метод для вывода поля
    private static void outputField(int arr[][]){
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println();
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 0){
                    System.out.print("- ");
                }
                else if(arr[i][j] == 1)
                {
                    System.out.print("X ");
                }
                else{
                    System.out.print("* ");
                }

            }
        }
        System.out.println();
    }

    //Метод для проверки занята ли ячейка кораблем(для
    // рандомного размещения кораблей компьютером)
    private static boolean checkIfPlaceNotRepeat(int arr[][], int x, int y){
        if(arr[y][x] == 1) {
            return false;
        }
        return true;
    }

    //Метод для проверки не стреляют ли в ту ячейку, в которую уже стреляли
    private static boolean checkIfShootNotRepeat(int arr[][], int x, int y){
        if(arr[y][x] == 2) {
            return false;
        }
        return true;
    }

    //Метод проверяющий попал ли снаряд в корабль
    private static boolean checkIfShootHit(int arr[][], int x, int y){
        if(arr[y][x] == 1){
            return true;
        }
        return false;
    }

    //Метод для размещения кораблей играком
    private static void  placeYourShips(int[][] yourField, int num){
        Scanner sc = new Scanner(System.in);
        int counter = num;
        boolean isNotEndOfPositioning = true;
        System.out.println("Расстановка вашего флота.");
        while (isNotEndOfPositioning) {
            System.out.print("Введите номер строки: ");
            int shipCoordinateY = sc.nextInt() - 1;
            System.out.print("Введи номер столбца: ");
            int shipCoordinateX = sc.nextInt() - 1;
            yourField[shipCoordinateY][shipCoordinateX] = 1;
            outputField(yourField);
            counter--;
            if (counter == 0) {
                isNotEndOfPositioning = false;
            }
        }
    }

    //Метод для размещения кораблей компьютером
    private static void  placeEnemyShips(int[][] enemyField, int num){
        Random rand = new Random();
        int counter = num;
        boolean isNotEndOfPositioning = true;
        while (isNotEndOfPositioning) {
            int shipCoordinateY = rand.nextInt(4);
            int shipCoordinateX = rand.nextInt(4);
            //System.out.println(shipCoordinateX + " ");
            //System.out.println(shipCoordinateY + "\n");
            boolean isChecked = checkIfPlaceNotRepeat(enemyField, shipCoordinateX, shipCoordinateY);
            if(isChecked) {
                enemyField[shipCoordinateY][shipCoordinateX] = 1;
                counter--;
            }
            if (counter == 0) {
                isNotEndOfPositioning = false;
            }
        }
    }

    //Метод для произведения выстрела игроком
    private static int yourShoot(int[][] enemyField,int[][] enemyFieldForYou, int enemy_num){
        Scanner sc = new Scanner(System.in);
        int x;
        int y;
        while(true) {
            System.out.print("\nВведите номер строки: ");
            y = sc.nextInt() - 1;
            System.out.print("Введите номер столбца: ");
            x = sc.nextInt() - 1;
            boolean isChecked = checkIfShootNotRepeat(enemyField, x , y);
            if (isChecked == false) {
                System.out.println("Сюда уже стреляли.Выберите другую ячейку");
            }
            else{
                break;
            }
        }
        boolean isHit = checkIfShootHit(enemyField, x, y);
        if(isHit) {
            enemy_num--;
            enemyFieldForYou[y][x] = 1;
            System.out.print("Вражеский корабль уничтожен!! ");
        }
        else if(checkIfShootNear(enemyField, x, y)) {
            enemyFieldForYou[y][x] = 2;
            System.out.print("Вы промахнулись но были близко.");
        }
        else{
            enemyFieldForYou[y][x] = 2;
            System.out.print("Вы промахнулись. ");
        }
        enemyField[y][x] = 2;
        return enemy_num;
    }

    //Метод для произведения выстрела врагом
    private static int enemyShoot(int[][] yourField, int your_num){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int x;
        int y;
        while(true) {
            y = rand.nextInt(4);
            x = rand.nextInt(4);
            //System.out.println(x + " ");
            //System.out.println(y + "\n");
            boolean isChecked = checkIfShootNotRepeat(yourField, x, y);
            if (isChecked) {
                break;
            }
        }
        boolean isHit = checkIfShootHit(yourField, x, y);
        if(isHit){
            your_num--;
            System.out.print("Враг уничтожил ваш корабль!!");
        }
        else{
            System.out.print("Враг промахнулся.");
        }
        yourField[y][x] = 2;
        return your_num;
    }



    private static boolean checkIfShootNear(int[][] enemyField, int x, int y){
        if(x > 0) {
            if(enemyField[y][x - 1] == 1){
                return true;
            }
        }
        if(x < enemyField.length - 1) {
            if(enemyField[y][x + 1] == 1){
                return true;
            }
        }
        if(y > 0) {
            if(enemyField[y - 1][x] == 1){
                return true;
            }
        }
        if(y < enemyField[0].length - 1) {
            if(enemyField[y + 1][x] == 1){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        final int num = 4;
        int[][] yourField = new int[num][num];
        int[][] enemyField = new int[num][num];
        int[][] enemyFieldForYou = new int[num][num];

        placeYourShips(yourField, num);
        placeEnemyShips(enemyField, num);
        //outputField(enemyField);

        int enemy_num = num;
        int your_num = num;
        while(true) {
            System.out.print("\n\nПоле врага для вас");
            outputField(enemyFieldForYou);
            System.out.print("\nВаше поле ");
            outputField(yourField);
            System.out.println("У вас осталось" + your_num + " корабля");
            System.out.println("У врага осталось" + enemy_num + " корабля");

            enemy_num = yourShoot(enemyField, enemyFieldForYou, enemy_num);
            if(enemy_num == 0){
                System.out.println("Вы уничтожили флот врага.Вы победили!!!");
                break;
            }
            //System.out.println("У вас осталось" + your_num + " корабля");
            //System.out.println("У врага осталось" + enemy_num + " корабля");

            your_num = enemyShoot(yourField, your_num);
            if(your_num == 0){
                System.out.println("Враг уничтожил ваш флот.Вы проиграли.....");
                break;
            }
        }
    }
}

