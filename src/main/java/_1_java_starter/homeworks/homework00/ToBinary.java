package _1_java_starter.homeworks.homework00;

public class ToBinary {
    public static void main(String[] args) {
        int a = 128;

        int k1 = a % 2;
        a = a / 2;
        int k2 = a % 2;
        a = a / 2;
        int k3 = a % 2;
        a = a / 2;
        int k4 = a % 2;
        a = a / 2;
        int k5 = a % 2;
        a = a / 2;
        int k6 = a % 2;
        a = a / 2;
        int k7 = a % 2;
        a = a / 2;
        int k8 = a % 2;
        a = a / 2;
        System.out.println(k8 + "" + k7 + "" + k6 + "" +
                +k5 + "" + k4 + "" + k3 + "" + k2 + "" + k1);
    }
}
