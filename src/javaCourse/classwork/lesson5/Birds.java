package javaCourse.classwork.lesson5;

import java.util.Comparator;
import java.util.TreeSet;

public class Birds {

    public static void main(String[] args) {

        Comparator<Bird> comparator = new BirdColorLengthComparator();
        TreeSet<Bird> birds = new TreeSet<>(comparator.reversed());
        birds.add(new Bird("red"));
        birds.add(new Bird("yellow"));
        birds.add(new Bird("blue"));
        System.out.println(birds);

    }
}
