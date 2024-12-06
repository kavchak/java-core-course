package javaCourse.homework.lesson10;

import java.util.ArrayList;
import java.util.List;

public class MyCounter {
    private static int COUNTER = 0;
    private static final int THREAD_COUNT = 10;
    private static final int ITERATIONS = 1000;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            CounterTask thread = new CounterTask();
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Result: " + COUNTER);
    }

    public static class CounterTask extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < ITERATIONS; j++) {
                nextCounter();
            }
            System.out.println(Thread.currentThread().getName() + " Counter: " + COUNTER);
        }
    }

    public synchronized static void nextCounter() {
        COUNTER++;
    }
}
