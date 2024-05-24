package javaCourse.homework.lesson4.task2;

public class MyStackMain {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack);

        System.out.println(myStack.pop());
        System.out.println(myStack);
    }
}
