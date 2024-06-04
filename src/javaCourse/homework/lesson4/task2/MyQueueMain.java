package javaCourse.homework.lesson4.task2;

public class MyQueueMain {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.add("first");
        myQueue.add("second");
        myQueue.add("third");
        System.out.println(myQueue);

        System.out.println(myQueue.poll());
        System.out.println(myQueue);
    }
}
