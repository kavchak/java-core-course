package javaCourse.homework.lesson3;

public interface MyList {

    void add(int index, String value);

    String get(int index);

    void remove(int index);

    void set(int index, String value);

    int size();
}