package _1_java_starter.classworks.classwork02;

import java.util.Scanner;

public class ToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        int n = sc.nextInt();
        String str = "";

        while(n != 0){
            if(n % 2 == 0){
               str = 0 + str;
            }
            else{
                str = 1 + str;
            }
            n = n / 2;
        }
        System.out.println("Результат: " + str);
    }
}
