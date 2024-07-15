package javaCourse.homework.lesson9;

import static javaCourse.homework.lesson9.Registration.*;

public class RegistrationMain {
    public static void main(String[] args) {
        String name = createName();
        String email = createEmail();
        String phone = createPhone();
        String password = createPassword();

        User user = new User(name, email, phone, password);

        System.out.println("Registration successful! \nUser Details: " + user);
    }
}
