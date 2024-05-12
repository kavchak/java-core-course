package java.course.classwork.lesson3;

import java.util.ArrayList;
import java.util.List;

public class IterateMail {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i + 1);
        }
        System.out.println(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            int j = numbers.size() - i - 1;
            System.out.print(numbers.get(j) + " ");
        }

        System.out.println();

        for(Integer number: numbers) {
            System.out.print(number + " ");
        }

        System.out.println();

        System.out.println("Does 7 exist in collection? " + numbers.contains(7));
        System.out.println("Does 20 exist in collection? " + numbers.contains(20));

    }
}
