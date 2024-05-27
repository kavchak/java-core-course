package javaCourse.homework.lesson5;

import java.util.Scanner;
import java.util.TreeSet;

public class EmployeeController {
    private TreeSet<Employee> employees = new TreeSet<>();

    public void addEmployee(Scanner scanner) {
        System.out.print("\nEnter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        double salary = getValidSalary(scanner);

        EmployeeType type = getEmployeeType(scanner);

        Employee employee = new Employee(firstName, lastName, salary, type);
        employees.add(employee);
        System.out.println("\nEmployee added successfully!");
    }

    private double getValidSalary(Scanner scanner) {
        System.out.print("Enter salary: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("\nInvalid salary. Enter a valid number: ");
            scanner.next();
        }
        double salary = scanner.nextDouble();
        scanner.nextLine();
        return salary;
    }

    private EmployeeType getEmployeeType(Scanner scanner) {
        printEmployeeTypeMenu();
        EmployeeType type = null;
        while (type == null) {
            String input = scanner.nextLine();
            try {
                int typeChoice = Integer.parseInt(input);
                switch (typeChoice) {
                    case 1:
                        type = EmployeeType.DEV;
                        break;
                    case 2:
                        type = EmployeeType.HR;
                        break;
                    case 3:
                        type = EmployeeType.MANAGER;
                        break;
                    case 4:
                        type = EmployeeType.QA;
                        break;
                    default:
                        System.out.print("\nInvalid choice. Enter a number (1-4): ");
                }
            } catch (NumberFormatException e) {
                System.out.print("\nInvalid choice. Enter a number (1-4): ");
            }
        }
        return type;
    }

    private static void printEmployeeTypeMenu() {
        System.out.println("\nEmployee type:");
        System.out.println("1. DEV");
        System.out.println("2. HR");
        System.out.println("3. MANAGER");
        System.out.println("4. QA");
        System.out.print("Please enter your choice: ");
    }

    public void printEmployees() {
        if (employees.isEmpty()) {
            System.out.println("\nNo employees found!");
        } else {
            System.out.println("\nEmployee List (sorted by salary - descending):");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}
