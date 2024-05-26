package javaCourse.classwork.lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Scheduler {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input day of week:");
        System.out.println(Arrays.toString(DayOfWeek.values()));
        String day = reader.readLine().toUpperCase(Locale.ROOT);
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(day);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Nazar", DayOfWeek.MONDAY));
        students.add(new Student("Liana", DayOfWeek.TUESDAY));
        students.add(new Student("Sofia", DayOfWeek.WEDNESDAY));
        students.add(new Student("Nikita", DayOfWeek.THURSDAY));
        students.add(new Student("Andriy", DayOfWeek.FRIDAY));
        students.add(new Student("Volodimir", DayOfWeek.SATURDAY));
        students.add(new Student("Mariana", DayOfWeek.SUNDAY));

        Map<DayOfWeek, Student> map = new HashMap<>();
        for (Student student: students) {
            map.put(student.getOnDuty(), student);
        }

        // Get on duty student from map
        Student onDutyStudent = map.get(dayOfWeek);
        System.out.println(onDutyStudent.getName() + " is on duty on " + dayOfWeek);

        // Get on duty student from list
        for (Student student: students) {
            System.out.println(student);

            if (dayOfWeek.equals(student.getOnDuty())) {
                System.out.println(student.getName() + " is on duty on " + dayOfWeek);
            }

        }
    }
}
