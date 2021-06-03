package _1_java_starter.classworks.classwork02;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Игра Угадай Число!!");
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int compNum = rand.nextInt(10);
        int counter = 0;
        while (true) {
            System.out.println("Введите число от 1 до 10(для выхода нажмите 0):");
            int yourNum = sc.nextInt();
            if (yourNum == 0) {
                System.out.println("Вы вышли из игры!!!");
                break;
            }
            counter++;
            if (yourNum == compNum) {
                System.out.println("Поздрвляю вас!!!! Вы угадали с " + counter + " попыток!");
                break;
            } else {
                System.out.println("Вы не угадали!");
            }
        }
    }
}
