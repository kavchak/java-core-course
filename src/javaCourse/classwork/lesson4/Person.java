package javaCourse.classwork.lesson4;

import java.util.Objects;

public class Person {

    public static int PERSON_COUNT = 0;

    int id;
    String name;

    public Person(String name) {
        this.id = ++PERSON_COUNT;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
