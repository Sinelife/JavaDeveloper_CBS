package _2_java_essential.homeworks.homework00;

import static _2_java_essential.homeworks.homework00.Employee.*;

public class Tester {

    private static Employee[] fillEmployeesArray(Employee[] employees) {
        employees[0] = new Employee(1, "Иван", "Иванов", 25, 4000, false);
        employees[1] = new Employee(2, "Олександр", "Демьянчук", 22, 6000, false);
        employees[2] = new Employee(3, "Иван", "Петров", 35, 17000, true);
        employees[3] = new Employee(4, "Виктория", "Шишкина", 315, 24000, true);
        employees[4] = new Employee(5, "Марк", "Громов", 25, 4000, false);
        employees[5] = new Employee(6, "Юлия", "Михайленко", 27, 14000, false);
        employees[6] = new Employee(7, "Катерина", "Онофрийчук", 20, 5500, false);
        employees[7] = new Employee(8, "Николай", "Андриевич", 29, 21000, true);
        employees[8] = new Employee(9, "Виктория", "Климова", 26, 13000, true);
        employees[9] = new Employee(10, "Григорий", "Гордиенко", 45, 40000, false);
        return employees;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        fillEmployeesArray(employees);

        Employee richEmployee = getEmployeeWithMaxSalary(employees);
        System.out.println("Самый багатый работник: " + Employee.toString(richEmployee));
        System.out.println("\n");

        System.out.println("Сума зарплат всех работников: " + sumSalaryOfAllEmployees(employees));
        System.out.println("\n");

        int from = 10000;
        int to = 20000;
        Employee[] employeesInInterval = getEmployeesInSalaryInterval(employees, from, to);
        System.out.println("Все работники, чья зарплата находиться в интервале от " + from + "грн до " + to + "грн");
        System.out.println(Employee.toString(employeesInInterval));

        String name = "Иван";
        System.out.println("Все работники, чье имя " + name);
        Employee[] employeesByName = getEmployeesByName(employees, name);
        System.out.println(Employee.toString(employeesByName));
    }
}
