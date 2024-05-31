package javaCourse.classwork.lesson6;

import java.time.LocalDate;

public class Dates {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate notToday = LocalDate.parse("2020-01-01");
        System.out.println(notToday);

        System.out.println(now.minusDays(3));

        if (notToday.isAfter(now)) {
            System.out.println("майбутнє");
        } else {
            System.out.println("минуле");
        }
    }
}
