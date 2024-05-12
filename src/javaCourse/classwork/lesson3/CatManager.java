package javaCourse.classwork.lesson3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CatManager {

    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();

        cats.add(new Cat("kusia"));
        cats.add(new Cat("murka"));
        cats.add(new Cat("simona"));
        cats.add(new Cat("pixel"));
        cats.add(new Cat("markis"));

        System.out.println(cats);
        addCatByName(cats, "murka");
//        removeCatByName(cats, "murka");
        System.out.println(cats);

    }

    /* ConcurrentModificationException
    public static void removeCatByName(List<Cat> cats, String name) {
        for(Cat cat: cats) {
            if (cat.getName().equals(name)) {
                 cats.remove(cat);
            }
        }
    }*/

    public static void removeCatByName(List<Cat> cats, String name) {
        Iterator<Cat> catIterator = cats.iterator();
        while(catIterator.hasNext()) {
            Cat cat = catIterator.next();
            if (cat.getName().equals(name)) {
                catIterator.remove();
            }
        }
    }

    public static void addCatByName(List<Cat> cats, String name) {
        boolean isFound = false;
        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                isFound = true;
                break;
            }
        }

        if (isFound) {
            cats.add(new Cat(name));
        }
    }
}
