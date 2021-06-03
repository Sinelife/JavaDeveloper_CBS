package _1_java_starter.homeworks.homework00;

public class Homework00 {
    public static void main(String[] args) {
        //1. Создать четыре целочисленные переменные типов byte, short, int, long.
        byte n1;
        short n2;
        int n3;
        long n4;


        //2. Инициализировать переменную типа byte результатом суммы двух любых чисел
        System.out.println("Exercise 2");
        n1 = (byte) (4 + 300);
        System.out.println("n1 = " + n1 + "\n");


        //3. Инициализировать переменную типа short  результатом вычитания двух любых чисел
        System.out.println("Exercise 3");
        n2 = (short) (100 - 450);
        System.out.println("n2 = " + n2 + "\n");


        //4. Инициализировать переменную типа int результатом деления двух любых чисел
        System.out.println("Exercise 4");
        n3 = 1000 / 4;
        System.out.println("n3 = " + n3 + "\n");


        //5. Инициализировать переменную типа long результатом умножения двух любых чисел
        System.out.println("Exercise 5");
        n4 = 300 * 4;
        System.out.println("n4 = " + n4 + "\n");


        //6. Передать перменной типа byte результат суммы двух переменной типа byte
        System.out.println("Exercise 6");
        byte b1 = 12;
        byte b2 = 15;
        byte b_sum = (byte) (b1 + b2);
        System.out.println("result = " + b_sum + "\n");


        //7. Передать переменной типа byte результат суммы двух переменных типа short, деленных на третью переменную типа byte
        System.out.println("Exercise 7");
        short s1 = 100;
        short s2 = 200;
        int i1 = 10;
        byte b_result = (byte) ((s1 + s2) / i1);
        System.out.println("result = " + b_result + "\n");


        //8. Переменной типа int передать результат деления двух short, умноженных на результат деления двух byte
        System.out.println("Exercise 8");
        short s3 = 50;
        short s4 = 10;
        byte b3 = 100;
        byte b4 = 4;
        int i_result = (s3 / s4) * (b3 / b4);
        System.out.println("result = " + i_result + "\n");


        //9. Поменять значения двух целочис ленных переменных используя третью
        System.out.println("Exercise 9");
        int a = 100;
        int b = 200;
        int temp;
        System.out.print("a = " + a + ", ");
        System.out.println("b = " + b);
        temp = b;
        b = a;
        a = temp;
        System.out.print("a = " + a + ", ");
        System.out.println("b = " + b + "\n");


        //10. Поменять значения двух переменных без использования третей
        System.out.println("Exercise 10");
        int x = 100;
        int y = 200;
        System.out.print("x = " + x + ", ");
        System.out.println("y = " + y);
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.print("x = " + x + ", ");
        System.out.println("y = " + y);


    }
}
