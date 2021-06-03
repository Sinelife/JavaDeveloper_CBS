package _2_java_essential.homeworks.homework01;

import java.util.Random;
import java.util.Scanner;

/**
 * Клас, в котором храняться методы нужные для ввода параметров
 * (не зависят от других класов)
 */

public class Methods {

    /**
     * Метод, который нужен для ввода координаты(рандомит значение
     * если компьютер и сканирует введенное с клавиатуры если игрок-человек)
     */
    public static int inputCoordinate(boolean isComputer, char c) {
        Scanner sc = new Scanner(System.in);
        int x;
        if (isComputer) {
            Random rand = new Random();
            x = rand.nextInt(4) + 1;
        } else {
            System.out.print("Введите координату по " + c + ": ");
            x = sc.nextInt();
        }
        return x;
    }

    /**
     * Метод, который возвращает введенный с клавиатуры параметр
     */
    public static int inputStartParameter(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        int parameter = sc.nextInt();
        return parameter;
    }

}
