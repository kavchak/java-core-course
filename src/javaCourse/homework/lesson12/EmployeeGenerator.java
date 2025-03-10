package javaCourse.homework.lesson12;

import java.util.Random;

public class EmployeeGenerator {
    private static final String[] NAMES = {null, "Bob", "Jack", "Helen"};
    private static final String[] EMAILS = {"bob@example.com", null, "jack@example.com", "helen@example.com"};
    private static final String[] PHONES = {"0961111111", "0972222222", null, "0664444444"};
    private static final double[] SALARIES = {1000, 2000, 4000, 6000};

    public static Employee createRandomEmployee() {
        Random random = new Random();
        return new Employee(
                NAMES[random.nextInt(NAMES.length)],
                EMAILS[random.nextInt(EMAILS.length)],
                PHONES[random.nextInt(PHONES.length)],
                SALARIES[random.nextInt(SALARIES.length)]
        );
    }
}
