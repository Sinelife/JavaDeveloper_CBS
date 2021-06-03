package _1_java_starter.homeworks.homework01;

import java.util.Scanner;

/**
 * Задание 8
 * Используя IntelliJ IDEA, создайте класс Interval.
 * Напишите программу определения, попадает ли введенное пользователем число от 0 до 100 в числовой
 * промежуток [0 - 14] [15 - 35] [36 - 50] [50 - 100]. Если да, то укажите, в какой именно промежуток.
 * Если пользователь указывает число не входящее ни в один из имеющихся числовых промежутков, то
 * выводится соответствующее сообщение.
 */

public class Exersice8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        int n = sc.nextInt();
        if (n >= 0 && n <= 14) {
            System.out.println("Число " + n + " попадает в промежуток [0, 14]");
        } else if (n >= 15 && n <= 35) {
            System.out.println("Число " + n + " попадает в промежуток [15, 35]");
        } else if (n >= 36 && n <= 50) {
            System.out.println("Число " + n + " попадает в промежуток [36, 50]");
        } else if (n >= 51 && n <= 100) {
            System.out.println("Число " + n + " попадает в промежуток [51, 100]");
        } else {
            System.out.println("Число " + n + " не попадает не в один промежуток");
        }
    }
}
