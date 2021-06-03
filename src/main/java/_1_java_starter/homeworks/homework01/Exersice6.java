package _1_java_starter.homeworks.homework01;

import java.util.Scanner;

/**
 * Задание 6
 * В три переменные a, b и c записаны три вещественных(дробных) числа. Создать программу, которая
 * будет находить и выводить на экран вещественные корни квадратного уравнения ax²+bx+c=0,
 * либо сообщать, что корней нет.
 */
public class Exersice6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите a:");
        double a = sc.nextDouble();
        System.out.println("Введите b:");
        double b = sc.nextDouble();
        System.out.println("Введите c:");
        double c = sc.nextDouble();
        double x1, x2;

        double d = b * b - 4 * a * c;
        if (a == 0) {
            x1 = ((-1) * c) / b;
            System.out.println("Корень уравнения: " + x1);
        } else if (d > 0) {
            x1 = ((-1) * b + Math.sqrt(d)) / (2 * a);
            x2 = ((-1) * b - Math.sqrt(d)) / (2 * a);
            System.out.println("Корни уравнения: " + x1 + ", " + x2);
        } else if (d == 0) {
            x1 = ((-1) * b) / (2 * a);
            System.out.println("Корень уравнения: " + x1);
        } else {
            System.out.println("Уравнение не имеет корней");
        }
    }
}
