package _2_java_essential.homeworks.homework02;

import java.util.Random;
import java.util.Scanner;

/**
 * Клас содержащий методы-утилиты.
 */

public class Methods {

    /**
     * Метод, получающий имя класа без пакетов
     */
    public static String getTrueClassName(Object o) {
        char[] chars = o.getClass().getName().toCharArray();
        String newStr = "";
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] == '.') {
                break;
            } else {
                newStr = chars[i] + newStr;
            }
        }
        return newStr;
    }

    /**
     * Метод, проверяющий число на правильный ввод с клавиатуры
     */
    public static int inputParameter(int from, int to) {
        Scanner sc = new Scanner(System.in);
        int i;
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.println("Вы ввели не число.Повторите ввод.");
                sc.next();
            }
            i = Integer.valueOf(sc.next());
            if (i > from && i <= to) {
                break;
            } else {
                System.out.println("Вы ввели число не входящее в диапазон. Повторите ввод.");
            }
        }
        return i;
    }

    /**
     * Метод, возвращающий введенную строку с клавиатуры
     */
    public static String inputParameter(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String s = sc.next();
        return s;
    }

    /**
     * Метод, выбирающий рандомную строку из масива строк
     */
    public static String getRandomHeroNameFromArray(String[] names) {
        Random rand = new Random();
        String name = names[rand.nextInt(names.length)];
        return name;
    }
}
