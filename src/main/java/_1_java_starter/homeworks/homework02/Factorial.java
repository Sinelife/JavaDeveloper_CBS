package _1_java_starter.homeworks.homework02;

import java.util.Scanner;

/**
 * 7. Создайте программу, вычисляющую факториал натурального числа n, введенного пользователем.
 */


public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите число:");
            int n = sc.nextInt();
            int result = 1;
            while (n > 0) {
                result *= n;
                n--;
            }
            System.out.println("Результат: " + result);
            System.out.println("Чи хочете повторити програму з початку?(натисніть Y якщо так)");
            char c = sc.next().charAt(0);
            if (c != 'Y') {
                break;
            }
        }
    }
}
