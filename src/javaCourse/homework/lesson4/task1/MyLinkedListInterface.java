package javaCourse.homework.lesson4.task1;

public interface MyLinkedListInterface {
    void addFirst(int element);
    void add(int index, int element);
    int get(int index);
    void set(int index, int element);
    void remove(int index);
    int size();
    String toString();
}
