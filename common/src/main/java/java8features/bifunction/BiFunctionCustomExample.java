package java8features.bifunction;

import java.util.function.BiFunction;

public class BiFunctionCustomExample {
    public static void main(String[] args) {
        // BiFunction to create an Employee
        BiFunction<String, Double, Employee> createEmployee = Employee::new;

        Employee emp = createEmployee.apply("John Doe", 50000.0);
        System.out.println("Employee Name: " + emp.name + ", Salary: " + emp.salary);
    }
}
