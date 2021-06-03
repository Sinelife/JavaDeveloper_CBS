package _1_java_starter.homeworks.homework02;

public class Sequences {
    public static void main(String[] args) {
        /** 1. Создайте программу, выводящую на экран все четырёхзначные числа последовательности 1000 1003 1006 1009 1012 1015 ….*/
        System.out.println("ArrayHomework 1");
        for (int i = 1000; i < 9999; i += 3) {
            System.out.print(i + ", ");
        }


        /** 2. Создайте программу, выводящую на экран первые 55 элементов последовательности 1 3 5 7 9 11 13 15 17 ….*/
        System.out.println("\n\nArrayHomework 2");
        for (int i = 0, n = 1; i < 55; i++, n += 2) {
            System.out.print(n + ", ");
        }

        /** 3. Создайте программу, выводящую на экран все неотрицательные элементы последовательности 90 85 80 75 70 65 60 ….*/
        System.out.println("\n\nArrayHomework 3");
        for (int i = 90; i >= 0; i -= 5) {
            System.out.print(i + ", ");
        }

        /** 4. Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 ….*/
        System.out.println("\n\nArrayHomework 4");
        for (int i = 0, m = 2; i < 20; i++, m *= 2) {
            System.out.print(m + ", ");
        }

        /** 5. Выведите на экран первые 20 членов последовательности Фибоначчи.*/
        System.out.println("\n\nArrayHomework 5");
        int a0 = 0;
        int a1 = 1;
        int an;
        System.out.print(a0 + ", " + a1 + ", ");
        for (int i = 0; i < 20; i++) {
            an = a0 + a1;
            System.out.print(an + ", ");
            a0 = a1;
            a1 = an;
        }
    }
}
