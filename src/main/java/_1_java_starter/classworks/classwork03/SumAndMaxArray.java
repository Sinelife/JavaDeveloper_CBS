package _1_java_starter.classworks.classwork03;

public class SumAndMaxArray {
    public static void main(String[] args) {
        int[] arr = {1,4,5,8,98,12,13,15,17,19};


        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Сума - " + sum);

        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Максимальне - " + max);
    }
}
