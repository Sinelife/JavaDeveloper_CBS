package _2_java_essential.homeworks.homework07;

public class Tester {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("Размер стека - " + stack.size());
        System.out.println("Stack - " + stack);
        for (int i = 0; i < 10; i++) {
            System.out.println("Добавляем в стек элемент " + i);
            stack.push(i);
        }
        System.out.println("Размер стека - " + stack.size());
        System.out.println("Stack - " + stack);
        System.out.println("\n\n");
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println("Удаляем элемент из стека");
            stack.pull();
            System.out.println("Размер стека - " + stack.size());
            System.out.println("Stack - " + stack);
        }

    }
}
