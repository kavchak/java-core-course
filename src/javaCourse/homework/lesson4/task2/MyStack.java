package javaCourse.homework.lesson4.task2;

import java.util.List;
import java.util.ArrayList;

public class MyStack {
    List<Integer> myStack = new ArrayList<>();
    private int size;

    public void push(int element) {
        myStack.add(element);
        size++;
    }

    public int pop() {
        if (myStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int element = myStack.remove(size - 1);
        size--;
        return element;
    }

    @Override
    public String toString() {
        return myStack.toString();
    }
}
