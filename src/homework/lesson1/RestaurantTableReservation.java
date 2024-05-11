package homework.lesson1;

import java.util.Scanner;

public class RestaurantTableReservation {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean[] tablesAvailability = {true, false, true, false, false};

        int userChoice = getUserChoice();
        switch (userChoice) {
            case 1:
                makeReservation(tablesAvailability);
                break;
            case 2:
                cancelReservation(tablesAvailability);
                break;
            case 3:
                System.out.println("Thank you for using the table reservation system!");
                return;
            default:
                System.out.println("Wrong choice. Please try again.");
                getUserChoice();
        }

        scanner.close();
    }

    private static int getUserChoice() {
        int input;

        while (true) {
            System.out.println("\nReservation Menu:");
            System.out.println("1. Reserve a table");
            System.out.println("2. Cancel reservation");
            System.out.println("3. Exit");
            System.out.print("\nPlease enter your choice: ");
            input = scanner.nextInt();
            if (input >= 1 && input <= 3) {
                return input;
            } else {
                System.out.println("\nInvalid choice. Please enter a number between 1 and 3.");
            }
        }
    }

    private static void makeReservation(boolean[] tablesAvailability) {
        System.out.println("\nAvailable Tables:");
        for (int i = 0; i < tablesAvailability.length; i++) {
            if (tablesAvailability[i]) {
                System.out.println("Table " + (i + 1));
            }
        }

        System.out.print("\nEnter the table number you want to reserve: ");
        int tableNumber = scanner.nextInt();
        if (tableNumber >= 1 && tableNumber <= tablesAvailability.length && tablesAvailability[tableNumber - 1]) {
            tablesAvailability[tableNumber - 1] = false;
            System.out.println("\nTable " + tableNumber + " has been reserved successfully.");
        } else {
            System.out.println("\nInvalid table number or table is already reserved.");
            makeReservation(tablesAvailability);
        }
    }

    private static void cancelReservation(boolean[] tablesAvailability) {
        System.out.println("\nTables with reservations:");
        for (int i = 0; i < tablesAvailability.length; i++) {
            if (!tablesAvailability[i]) {
                System.out.println("Table " + (i + 1));
            }
        }

        System.out.print("\nEnter the table number you want to cancel reservation for: ");
        int tableNumber = scanner.nextInt();
        if (tableNumber >= 1 && tableNumber <= tablesAvailability.length && !tablesAvailability[tableNumber - 1]) {
            tablesAvailability[tableNumber - 1] = true;
            System.out.println("\nReservation for Table " + tableNumber + " has been canceled.");
        } else {
            System.out.println("\nInvalid table number or table is not reserved.");
            cancelReservation(tablesAvailability);
        }
    }
}
