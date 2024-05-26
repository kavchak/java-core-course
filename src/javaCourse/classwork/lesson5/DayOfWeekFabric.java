package javaCourse.classwork.lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

public class DayOfWeekFabric {

    public static void main(String[] args) throws IOException {

        // замініть використання світч на map

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input day of week:");
        System.out.println(Arrays.toString(DayOfWeek.values()));
        String day = reader.readLine().toUpperCase(Locale.ROOT);
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(day);

        System.out.println(createTask(dayOfWeek));

    }

    private static String createTask(DayOfWeek dayOfWeek) {
        String task = "";
        switch (dayOfWeek) {
            case MONDAY:
                task = "Сьогодні миємо вікна";
                break;
            case TUESDAY:
                task = "Сьогодні поливаємо квіти";
                break;
            case WEDNESDAY:
                task = "Сьогодні міємо парти";
                break;
            case THURSDAY:
                task = "Сьогодні миємо дошку";
                break;
            case FRIDAY:
                task = "Сьогодні складаємо книжки";
                break;
            case SATURDAY:
                task = "Сьогодні змінаємо штори";
                break;
            case SUNDAY:
                task = "Сьогодні поліруємо дошку";
                break;
        }
        return task;
    }
}
