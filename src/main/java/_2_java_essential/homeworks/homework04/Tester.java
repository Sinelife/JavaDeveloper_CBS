package _2_java_essential.homeworks.homework04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tester {

    public static final int LIST_SIZE = 4_000_000;
    public static String str;
    public static final String STR_START = "     Start     |";
    public static final String STR_MIDDLE = "     Middle     |";
    public static final String STR_END = "      End      |";


    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        initializeList(arrayList, LIST_SIZE);
        countTimeForAllMethodSeveralTimes(arrayList);

        List<Integer> linkedList = new LinkedList<>();
        initializeList(linkedList, LIST_SIZE);
        countTimeForAllMethodSeveralTimes(linkedList);
    }


    /**
     * Метод инициализирующий список
     */
    public static void initializeList(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }


    /**
     * Метод, который подсчитывает время роботы всех методов(get, add, set, remove) в списке
     * list для трьох елементов - первого, последнего и того что посередине
     */
    public static void countTimeForAllMethodSeveralTimes(List<Integer> list) {
        if (list instanceof LinkedList) {
            str = "  LinkedList[" + LIST_SIZE + "]  |";
        }
        if (list instanceof ArrayList) {
            str = "  ArrayList[" + LIST_SIZE + "]  |";
        }
        System.out.println(outputSymbols('-', str.length() + STR_START.length() + STR_MIDDLE.length() + STR_END.length() + 1));
        System.out.println("|" + str + STR_START + STR_MIDDLE + STR_END);
        System.out.println(outputSymbols('-', str.length() + STR_START.length() + STR_MIDDLE.length() + STR_END.length() + 1));
        countTimeForChosenMethodSeveralTimes(list, "get");
        countTimeForChosenMethodSeveralTimes(list, "add");
        countTimeForChosenMethodSeveralTimes(list, "remove");
        countTimeForChosenMethodSeveralTimes(list, "set");
        System.out.println("\n\n");
    }


    /**
     * Метод, который подсчитывает время роботы метода заданого переменной methodName в списке
     * list для трьох елементов - первого, последнего и того что посередине
     */
    public static void countTimeForChosenMethodSeveralTimes(List<Integer> list, String methodName) {
        System.out.print("|" + outputForTable(str, methodName));
        System.out.print(outputForTable(STR_START, countTime(list, 0, methodName)));
        System.out.print(outputForTable(STR_MIDDLE, countTime(list, list.size() / 2, methodName)));
        System.out.print(outputForTable(STR_END, countTime(list, list.size() - 1, methodName)));
        System.out.println("\n" + outputSymbols('-', str.length() + STR_START.length() + STR_MIDDLE.length() + STR_END.length() + 1));

    }

    /**
     * Метод, который подсчитывает время роботы метода заданого переменной methodName в списке
     * list с индесом элемента elementIndex
     */
    public static String countTime(List<Integer> list, int elementIndex, String methodName) {
        long start = 0;
        if (methodName.equals("add")) {
            start = System.nanoTime();
            list.add(elementIndex, 1000);
        } else if (methodName.equals("get")) {
            start = System.nanoTime();
            list.get(elementIndex);
        } else if (methodName.equals("set")) {
            start = System.nanoTime();
            list.set(elementIndex, 1000);
        } else if (methodName.equals("remove")) {
            start = System.nanoTime();
            list.remove(elementIndex);
        }
        long end = System.nanoTime();
        return String.valueOf((end - start) / 1_000_000) + " ms";
    }


    /**
     * Метод, который возвращает строку( в которой выбраный символ вводиться заданое количество раз
     */
    public static String outputSymbols(char symbol, int numberOfSymbols) {
        String result = "";
        for (int i = 0; i < numberOfSymbols; i++) {
            result += symbol;
        }
        return result;
    }

    /**
     * Метод необходимый для коректного отображения таблицы. Он заполняет строку subStr пробелами
     * с обоих сторон пока длина subStr не станет равна mainStr
     */
    public static String outputForTable(String mainStr, String subStr) {
        do {
            subStr = " " + subStr;
            if (subStr.length() == mainStr.length() - 1) {
                break;
            }
            subStr = subStr + " ";
        } while (subStr.length() < mainStr.length() - 1);
        subStr = subStr + "|";
        return subStr;
    }

}
