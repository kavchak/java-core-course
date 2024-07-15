package javaCourse.homework.lesson9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Registration {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getUserInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error reading input", e);
        }
    }

    public static String createName() {
        System.out.print("Please enter your name: ");
        String name = getUserInput();
        boolean isNameValid = UserValidator.isNameValid(name);
        if (!isNameValid) {
            System.out.println("Invalid name. Please enter a valid name (3-256 characters, only Ukrainian/English letters).");
            return createName();
        }
        return name;
    }

    public static String createEmail() {
        System.out.print("Please enter your email: ");
        String email = getUserInput();
        boolean isEmailValid = UserValidator.isEmailValid(email);
        if (!isEmailValid) {
            System.out.println("Invalid email. Please enter a valid email address.");
            return createEmail();
        }
        return email;
    }

    public static String createPhone() {
        System.out.print("Please enter your phone number (e.g. +380123456789): ");
        String phone = getUserInput();
        boolean isPhoneValid = UserValidator.isPhoneValid(phone);
        if (!isPhoneValid) {
            System.out.println("Invalid phone number. Please enter a valid phone number (e.g. +380123456789).");
            return createPhone();
        }
        return phone;
    }

    public static String createPassword() {
        System.out.print("Please enter your password: ");
        String password = getUserInput();
        boolean isPasswordValid = UserValidator.isPasswordValid(password);
        if (!isPasswordValid) {
            System.out.println("Invalid password. Password must be at least 8 characters and include an uppercase letter, a number, and a special symbol.");
            return createPassword();
        }

        System.out.println("Please confirm your password: ");
        String confirmPassword = getUserInput();
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Please enter the same password again.");
            return createPassword();
        }
        return password;
    }
}
