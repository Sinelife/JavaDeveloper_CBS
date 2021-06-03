package _1_java_starter.homeworks.homework01;

import java.util.Scanner;

/**
 * Задание 7
 * Используя IntelliJ IDEA, создайте класс Calculator.
 * Напишите программу - консольный калькулятор.
 * Введите с консоли две переменные. Предложите пользователю ввести знак арифметической операции.
 * Для организации выбора алгоритма вычислительного процесса, используйте оператор switch.
 * Выведите на экран результат выполнения арифметической операции.
 * В случае использования операции деления, организуйте проверку попытки деления на ноль.
 * И если таковая имеется, то отмените выполнение арифметической операции и уведомите об ошибке
 * пользователя.
 */

public class Exersice7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первое число:");
        double a = sc.nextDouble();
        System.out.println("Введите второе число:");
        double b = sc.nextDouble();
        System.out.println("Введите операцию из перечисленных: +,-,*,/,%");
        char c = sc.next().charAt(0);
        double result = 0;
        switch (c) {
            case '+':
                System.out.println("Результат: " + (a + b));
                break;
            case '-':
                System.out.println("Результат: " + (a - b));
                break;
            case '*':
                System.out.println("Результат: " + (a * b));
                break;
            case '/':
                if (b == 0) {
                    System.out.println("На ноль делить нельзя!!");
                } else {
                    System.out.println("Результат: " + (a / b));
                }
                break;
            case '%':
                if (b == 0) {
                    System.out.println("На ноль делить нельзя!!");
                } else {
                    System.out.println("Результат: " + (a % b));
                }
                break;
            default:
                System.out.println("Такой операции нет!");
                break;
        }
    }
}
