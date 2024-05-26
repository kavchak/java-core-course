package javaCourse.classwork.lesson5;

import java.util.TreeSet;

public class Persons {

    public static void main(String[] args) {

        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("Mariana"));
        people.add(new Person("Andriy"));
        people.add(new Person("Julia"));

        System.out.println(people);

    }
}
