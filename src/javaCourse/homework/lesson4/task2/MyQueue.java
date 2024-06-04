package javaCourse.homework.lesson4.task2;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    List<String> myQueue = new ArrayList<>();
    private int size;

    public void add(String value) {
        myQueue.add(value);
        size++;
    }

    public String poll() {
        if (myQueue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        String removedItem = myQueue.remove(0);
        size--;
        return removedItem;
    }

    @Override
    public String toString() {
        return myQueue.toString();
    }
}
