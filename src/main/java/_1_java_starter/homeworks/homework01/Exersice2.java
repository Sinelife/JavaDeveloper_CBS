package _1_java_starter.homeworks.homework01;

import java.util.Scanner;

/**
 * Задание 2
 * Создать программу, проверяющую и сообщающую на экран,является ли введенное с
 * консоли целое число, чётным либо нечётным.
 */

public class Exersice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.println("Число четное!");
        } else {
            System.out.println("Число не четное!");
        }
    }
}
