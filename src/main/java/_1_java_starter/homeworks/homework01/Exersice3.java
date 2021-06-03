package _1_java_starter.homeworks.homework01;

import java.util.Scanner;

/**
 * Задание 3
 * Создать программу, выводящую на экран ближайшее к 10 из двух чисел, введенных с консоли.
 * Например, среди чисел 8,5 и 11,45 ближайшее к десяти 11,45.
 */


public class Exersice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число:");
        double n1 = sc.nextDouble();
        System.out.println("Введите второе число:");
        double n2 = sc.nextDouble();

        if (Math.abs(n1 - 10) > Math.abs(n2 - 10)) {
            System.out.println(n2 + " ближе к 10 чем " + n1);
        } else if (Math.abs(n1 - 10) < Math.abs(n2 - 10)) {
            System.out.println(n1 + " ближе к 10 чем " + n2);
        } else {
            System.out.println("Числа " + n1 + " и " + n2 +
                    " одинаково отдалены от 10");
        }
    }
}
