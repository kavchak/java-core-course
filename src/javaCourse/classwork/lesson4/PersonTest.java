package javaCourse.classwork.lesson4;

public class PersonTest {

    public static void main(String[] args) {

        Person person = new Person("Edd");
        System.out.println(person);

        Person person1 = new Person("Tom");
        System.out.println(person1);

        System.out.println(person.equals(person));
        System.out.println(person.equals(person1));
        System.out.println(person.equals("Tratata"));
        System.out.println(person.equals(null));
    }
}
