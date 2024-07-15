package javaCourse.homework.lesson9;

import java.util.regex.Pattern;

public class UserValidator {
    private static final String NAME_REGEX = "^[a-zA-Zа-яА-ЯіїєІЇЄ]{3,256}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String PHONE_REGEX = "^\\+380\\d{9}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}:;<>,.?~`\\-])[A-Za-z\\d!@#$%^&*()_+{}:;<>,.?~`\\-]{8,}$";

    public static boolean isNameValid(String name) {
        return Pattern.matches(NAME_REGEX, name);
    }

    public static boolean isEmailValid(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean isPhoneValid(String phone) {
        return Pattern.matches(PHONE_REGEX, phone);
    }

    public static boolean isPasswordValid(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }
}
