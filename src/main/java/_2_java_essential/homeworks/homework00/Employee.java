package _2_java_essential.homeworks.homework00;

public class Employee {
    int id;
    String firstName;
    String lastName;
    int age;
    int salary;
    boolean isMarried;

    /**
     * Конструтор по умолчанию
     */
    Employee() {
    }

    /**
     * Конструктор, в котором задаються все поля класа
     */
    Employee(int id, String firstName, String lastName, int age, int salary, boolean isMarried) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.isMarried = isMarried;
    }

    /**
     * Метод, который возвращает работника с найбольшей зарплатой
     */
    public static Employee getEmployeeWithMaxSalary(Employee[] employees) {
        Employee e = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].salary > e.salary) {
                e = employees[i];
            }
        }
        return e;
    }

    /**
     * Метод, который возвращает всех работников, зарплата которых находиться в заданом интервале
     */
    public static Employee[] getEmployeesInSalaryInterval(Employee[] employees, int from, int to) {
        Employee[] employeesInInterval = new Employee[employees.length];
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].salary >= from && employees[i].salary <= to) {
                employeesInInterval[counter] = employees[i];
                counter++;
            }
        }
        return employeesInInterval;
    }

    /**
     * Метод, который возвращает суму зарплат всех работников
     */
    public static int sumSalaryOfAllEmployees(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].salary;
        }
        return sum;
    }

    /**
     * Метод, который возвращает всех работников по заданому имени
     */
    public static Employee[] getEmployeesByName(Employee[] employees, String name) {
        Employee[] employeesByName = new Employee[employees.length];
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].firstName.equals(name)) {
                employeesByName[counter] = employees[i];
                counter++;
            }
        }
        return employeesByName;
    }

    /**
     * Метод, который выводит информацыю про заданого работника
     */
    public static String toString(Employee employee) {
        String result = employee.firstName + " " + employee.lastName + ", зарплата = " + employee.salary
                + ", возраст = " + employee.age;
        if (employee.isMarried) {
            result += ", женат/замужем.";
        } else {
            result += ", не женат/не замужем.";
        }
        return result;
    }

    /**
     * Метод, который выводит информацыю про всех работников заданого масива
     */
    public static String toString(Employee[] employees) {
        String result = "";
        int counter = 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                result += counter + ")" + toString(employees[i]) + "\n";
                counter++;
            }
        }
        return result;
    }
}
