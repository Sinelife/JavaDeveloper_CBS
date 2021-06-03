package _1_java_starter.homeworks.homework02;

import java.util.Scanner;

/**
 * 6. Написать программу, которая реализует следующий функционал:
 * 6.1 Пользователь вводит число в 10-ой системе счисления.
 * 6.2 Программа выводит сообщение в котором предлагает пользователю перевести данное число в одну из систем счисления на выбор:
 * 1) в 2-ую
 * 2) в 8-ую
 * 3) в 16-ую
 * 6.3 Пользователь выбирает один из предложенных вариантов, программа выполняет соответствующий перевод числа и выводит
 * на экран результат.
 */


public class NumeralSystem {

    private static String toBinary(int n) {
        String str = "";
        while (n != 0) {
            int d = n % 2;
            str = d + str;
            n = n / 2;
        }
        return str;
    }

    private static String toEight(int n) {
        String str = "";
        while (n != 0) {
            int d = n % 8;
            str = d + str;
            n = n / 8;
        }
        return str;
    }

    private static String toSixteen(int n) {
        String str = "";
        while (n != 0) {
            int d = n % 16;
            if (d < 10) {
                str = d + str;
            } else {
                switch (d) {
                    case 10:
                        str = 'A' + str;
                        break;
                    case 11:
                        str = 'B' + str;
                        break;
                    case 12:
                        str = 'C' + str;
                        break;
                    case 13:
                        str = 'D' + str;
                        break;
                    case 14:
                        str = 'E' + str;
                        break;
                    case 15:
                        str = 'F' + str;
                        break;
                }
            }
            n = n / 16;
        }
        return str;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите число:");
            int n = sc.nextInt();
            System.out.println("Выберите систему в которую нужно перевести число:");
            System.out.println("1)в 2-ую");
            System.out.println("2)в 8-ую");
            System.out.println("3)в 16-ую");
            int system = sc.nextInt();
            switch (system) {
                case 1:
                    System.out.println("Результат: " + toBinary(n));
                    break;
                case 2:
                    System.out.println("Результат: " + toEight(n));
                    break;
                case 3:
                    System.out.println("Результат: " + toSixteen(n));
                    break;
            }
            System.out.println("Чи хочете повторити програму з початку?(натисніть Y якщо так)");
            char c = sc.next().charAt(0);
            if (c != 'Y') {
                break;
            }
        }
    }
}
