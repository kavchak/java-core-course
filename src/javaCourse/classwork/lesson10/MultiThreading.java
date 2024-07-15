package javaCourse.classwork.lesson10;

import java.util.ArrayList;
import java.util.List;

public class MultiThreading {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("thread: " + Thread.currentThread().getName());

        List<Thread> threads = new ArrayList<>();

        // спимо 2 секунди
        System.out.println("before sleep main");
        Thread.sleep(2000);
        System.out.println("after sleep main");

        for (int i = 0; i < 10; i++) {
//            Printer printer = new Printer("my printer " + i);
//            Thread thread = new Thread(printer);
//            thread.start();
            PrinterThread thread = new PrinterThread();
            threads.add(thread);
            thread.start();

        }

        System.out.println("1.thread: " + Thread.currentThread().getName());

        // чекаємо завершення всіх потоків
        for (Thread thread: threads) {
            thread.join();
        }

        System.out.println("2. thread: " + Thread.currentThread().getName());

    }

    public static class Printer implements Runnable {

        private String name;

        public Printer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("thread: " + Thread.currentThread().getName());
            System.out.println("Print message from " + name);
        }
    }

    public static class PrinterThread extends Thread {

        @Override
        public void run() {

            System.out.println("before sleep " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after sleep " + Thread.currentThread().getName());

            System.out.println("PrinterThread prints message " + Thread.currentThread().getName());
        }
    }

}
