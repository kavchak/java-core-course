package javaCourse.homework.lesson8;

import java.io.*;
import java.util.*;

public class OrderMain {
    private static final String FILE_NAME = "/Users/vova/Documents/java-course/orders.txt";
    private static final Map<Integer, Order> orders = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadOrdersFromFile();
        while (true) {
            printMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    checkOrderStatus();
                    break;
                case 3:
                    changeOrderStatus();
                    break;
                case 4:
                    saveOrdersToFile();
                    System.out.println("\nExiting application...");
                    scanner.close();
                    return;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void loadOrdersFromFile() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            orders.clear();
            orders.putAll((Map<Integer, Order>) objectInputStream.readObject());
            System.out.println("\nOrders loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("\nOrder file not found. Starting with an empty order list.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("\nError loading orders from file: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("\nOrder Menu:");
        System.out.println("1. Create Order");
        System.out.println("2. Check Order Status");
        System.out.println("3. Change Order Status");
        System.out.println("4. Exit");
        System.out.print("Please enter your choice: ");
    }

    private static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("\nInvalid choice. Enter a number (1-4): ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private static void createOrder() {
        int orderId = generateUniqueOrderId();
        Order newOrder = new Order(orderId);
        orders.put(newOrder.getOrderId(), newOrder);
        System.out.println("\nOrder created successfully with ID: " + newOrder.getOrderId());
        saveOrdersToFile();
    }

    private static void checkOrderStatus() {
        int orderId = getValidOrderId();
        Order order = orders.get(orderId);
        if (order != null) {
            System.out.println("\nOrder status for ID " + orderId + ": " + order.getStatus());
        } else {
            System.out.println("\nOrder with ID " + orderId + " not found.");
        }
    }

    private static void changeOrderStatus() {
        int orderId = getValidOrderId();
        Order order = orders.get(orderId);
        if (order != null) {
            System.out.println("\nCurrent order status: " + order.getStatus());

            String newStatusStr;
            do {
                System.out.print("Enter new status (NEW, IN_PROGRESS, FINISHED, FAILED): ");
                newStatusStr = scanner.nextLine().trim().toUpperCase();
                if (!isValidStatus(newStatusStr)) {
                    System.out.println("\nInvalid status entered.");
                }
            } while (!isValidStatus(newStatusStr));

            try {
                OrderStatus newStatus = OrderStatus.valueOf(newStatusStr);
                order.updateStatus(newStatus);
                System.out.println("\nOrder status updated successfully.");
                saveOrdersToFile();
            } catch (InvalidStatusException e) {
                System.out.println("\nError: " + e.getMessage());
            }
        } else {
            System.out.println("\nOrder with ID " + orderId + " not found.");
        }
    }

    private static void saveOrdersToFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            objectOutputStream.writeObject(orders);
            System.out.println("\nOrders saved successfully.");
        } catch (IOException e) {
            System.err.println("\nError saving orders to file: " + e.getMessage());
        }
    }

    private static int generateUniqueOrderId() {
        int orderId;
        Random random = new Random();
        do {
            orderId = random.nextInt(Integer.MAX_VALUE);
        } while (orders.containsKey(orderId));
        return orderId;
    }

    private static int getValidOrderId() {
        int orderId;
        do {
            System.out.print("\nEnter order ID to change status: ");
            try {
                orderId = scanner.nextInt();
                scanner.nextLine();
                if (!orders.containsKey(orderId)) {
                    System.out.println("\nInvalid order ID. Please enter a valid ID.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid order ID.");
                scanner.nextLine();
            }
        } while (true);
        return orderId;
    }

    private static boolean isValidStatus(String status) {
        try {
            OrderStatus.valueOf(status);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
