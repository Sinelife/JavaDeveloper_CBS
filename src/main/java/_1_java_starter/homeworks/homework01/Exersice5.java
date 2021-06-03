package _1_java_starter.homeworks.homework01;

import java.util.Scanner;

/**
 * Задание 5
 * Задано четыре переменных, найти и вывести на экран вторую по величине.
 */


public class Exersice5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double first;
        double second = -1000000;

        System.out.println("Введите первое число:");
        double a = sc.nextDouble();
        first = a;

        System.out.println("Введите второе число:");
        double b = sc.nextDouble();
        if (b > first) {
            second = first;
            first = b;
        } else if (b < first) {
            second = b;
        } else {
        }

        System.out.println("Введите третье число:");
        double c = sc.nextDouble();
        if (c > first) {
            second = first;
            first = c;
        } else if (c < first && c > second) {
            second = c;
        } else {
        }

        System.out.println("Введите четвертое число:");
        double d = sc.nextDouble();
        if (d > first) {
            second = first;
            first = d;
        } else if (d < first && d > second) {
            second = d;
        } else {
        }

        System.out.println("Результат: " + second);
    }
}
