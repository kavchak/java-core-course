package javaCourse.homework.lesson3;

import java.util.Arrays;

public class MyArrayList implements MyList {

    private String[] strings;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
    private static final double CAPACITY_INCREASE_FACTOR = 1.5;

    public MyArrayList() {
        strings = new String[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void add(int index, String value) {
        validateIndex(index);

        if (size == strings.length) {
            increaseCapacity();
        }

        if (index < size) {
            System.arraycopy(strings, index, strings, index + 1, size - index);
        }

        strings[index] = value;
        size++;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds. " + "Index: " + index + ", Size: " + size);
        }
    }

    private void increaseCapacity() {
        int newCapacity = (int) (strings.length * CAPACITY_INCREASE_FACTOR);
        strings = Arrays.copyOf(strings, newCapacity);
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return strings[index];
    }

    @Override
    public void remove(int index) {
        validateIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(strings, index + 1, strings, index, numMoved);
        }
        strings[--size] = null;
    }

    @Override
    public void set(int index, String value) {
        validateIndex(index);
        strings[index] = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(strings[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}