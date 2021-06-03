package _1_java_starter.classworks.classwork02;

import java.util.Scanner;

public class ToSixteen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        int n = sc.nextInt();
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
        System.out.println("Результат: " + str);
    }
}
