package javaCourse.homework.lesson4.task1;

public class MyLinkedListMain {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addFirst(10);
        list.add(1, 20);
        list.add(2, 30);
        System.out.println(list);

        System.out.println("Element at index 2: " + list.get(2));

        list.set(1, 50);
        System.out.println(list);


        list.remove(2);
        System.out.println(list);

        System.out.println("Size of the list: " + list.size());
    }
}
