package _1_java_starter.homeworks.homework04;

import java.util.Scanner;

public class FibonachiRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Для выхода из програмы введите -1");
        while (true) {
            System.out.print("Введите число: ");
            int n = sc.nextInt();
            if (n == -1) {
                break;
            }
            int result = fibonachiRecursion(n);
            System.out.println(result + "\n\n");
        }
    }

    private static int fibonachiRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonachiRecursion(n - 1) + fibonachiRecursion(n - 2);
    }
}
