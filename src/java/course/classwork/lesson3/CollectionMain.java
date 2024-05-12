package java.course.classwork.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionMain {

    public static void main(String[] args) {

        // create
        int[] numbersArr = new int[5];
        List<Integer> numbersColl = new ArrayList<>();
        System.out.println("create array: " + Arrays.toString(numbersArr));
        System.out.println("create ArrayList: " + numbersColl);

        // get size
        System.out.println("array size: " + numbersArr.length);
        System.out.println("ArrayList size: " + numbersColl.size());

        // add to collection in the end (no indexes used) - Does not exist in array
        numbersColl.add(1);
        numbersColl.add(23);
        // {1, 23}

        // add to collection in the middle (indexes used) - Does not exist in array. Fail if index does not exist
        numbersColl.add(0, 100);
        // {100, 1, 23}
        numbersColl.add(1, 500);


        // set, replace value, fail if index does not exist
        numbersArr[0] = 1;
        numbersArr[3] = 20;

        System.out.println("filled array: " + Arrays.toString(numbersArr));
        System.out.println("filled ArrayList: " + numbersColl);

        numbersColl.set(0, 444);
        System.out.println("ArrayList set (replace): " + numbersColl);

        // get element
        System.out.println("get element from array: " + numbersArr[3]);
        System.out.println("get element from ArrayList: " + numbersColl.get(0));

        // in the array we can only clear element by index, array length will be the same
        numbersArr[3] = 0;
        System.out.println("array after clear: " + Arrays.toString(numbersArr));

        // remove
        numbersColl.remove(0);
        System.out.println("ArrayList after remove: " + numbersColl);

    }
}
