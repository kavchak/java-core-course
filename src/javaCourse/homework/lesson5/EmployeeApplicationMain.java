package javaCourse.homework.lesson5;

import java.util.Scanner;

public class EmployeeApplicationMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeController controller = new EmployeeController();

        int choice;
        do {
            printMenu();
            choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    controller.addEmployee(scanner);
                    break;
                case 2:
                    controller.printEmployees();
                    break;
                case 3:
                    System.out.println("\nExiting application.");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nEmployee Management Actions:");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Exit");
        System.out.print("Please enter your choice: ");
    }

    private static int getChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("\nInvalid choice. Enter a number (1-3): ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
