package _1_java_starter.homeworks.homework02;

import java.util.Scanner;

/**
 * 8. Выведите на экран все положительные делители натурального числа, введенного пользователем.
 */

public class Deviders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите число:");
            int n = sc.nextInt();
            int m = 1;
            System.out.print("Deviders: ");
            while (m <= n) {
                if (n % m == 0) {
                    System.out.print(m + ", ");
                }
                m++;
            }
            System.out.println("\nЧи хочете повторити програму з початку?(натисніть Y якщо так)");
            char c = sc.next().charAt(0);
            if (c != 'Y') {
                break;
            }
        }
    }
}
