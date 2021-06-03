package _1_java_starter.homeworks.homework01;

import java.util.Scanner;

/**
 * Задание 4
 * Задано три переменных, найти и вывести на экран переменную с максимальным значением
 * (значения всех переменных разные).
 */


public class Exersice4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число:");
        double a = sc.nextDouble();
        System.out.println("Введите второе число:");
        double b = sc.nextDouble();
        System.out.println("Введите третье число:");
        double c = sc.nextDouble();

        if (a > b && a > c) {
            System.out.println("Самое большое число " + a);
        } else if (b > a && b > c) {
            System.out.println("Самое большое число " + b);
        } else {
            System.out.println("Самое большое число " + c);
        }
    }
}
