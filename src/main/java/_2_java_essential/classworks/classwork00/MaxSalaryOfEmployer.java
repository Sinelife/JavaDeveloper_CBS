package _2_java_essential.classworks.classwork00;

public class MaxSalaryOfEmployer {

    public static void main(String[] args) {
        String[] names = {"Alexander", "Andrey", "Maxim"};
        int[] age = {25, 28, 29};
        int[] salaries = {10000, 20000, 17000};
        int maxSalary = 0;
        int maxSalaryIndex = 0;
        for (int i = 1; i < salaries.length; i++) {
            if (salaries[i] > maxSalary) {
                maxSalary = salaries[i];
                maxSalaryIndex = i;
            }
        }
        System.out.println("Максимальная зарплата " + salaries[maxSalaryIndex]
                + "грн у сотрудника " + names[maxSalaryIndex]);
    }
}
