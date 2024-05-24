package javaCourse.homework.lesson4.task3;

import java.util.Iterator;
import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;

public class DeleteWinterBirthdays {

    public static void main(String[] args) {
        Map<String, LocalDate> people = new HashMap<>();

        people.put("Ivanov", LocalDate.of(1990, 5, 15));
        people.put("Petrov", LocalDate.of(1985, 8, 25));
        people.put("Sidorov", LocalDate.of(1977, 12, 10));
        people.put("Kurnik", LocalDate.of(2000, 1, 30));
        people.put("Lisovsky", LocalDate.of(1995, 11, 20));
        people.put("Cheh", LocalDate.of(1980, 2, 5));
        people.put("Pavlenko", LocalDate.of(1972, 7, 12));
        people.put("Verlan", LocalDate.of(1988, 3, 8));
        people.put("Gagarin", LocalDate.of(1992, 9, 3));
        people.put("Sabram", LocalDate.of(1983, 6, 18));

        System.out.println(people);

        deleteWinterBirthdays(people);
        System.out.println("\n" + people);
    }

    public static void deleteWinterBirthdays(Map<String, LocalDate> people) {
        Iterator<Map.Entry<String, LocalDate>> iterator = people.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, LocalDate> entry = iterator.next();
            LocalDate birthday = entry.getValue();
            int month = birthday.getMonthValue();
            if (month == 12 || month == 1 || month == 2) {
                iterator.remove();
            }
        }
    }
}
