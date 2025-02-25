package javaCourse.homework.lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyModifyCounter {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private static final int THREAD_COUNT = 10;
    private static final int ITERATIONS = 1000;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        List<Future<AtomicInteger>> futures = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            Future<AtomicInteger> futureTask = executor.submit(new CounterTask());
            futures.add(futureTask);
        }

        for (Future<AtomicInteger> future: futures) {
            future.get();
        }

        executor.shutdown();

        System.out.println("Result: " + COUNTER.get());
    }

    public static class CounterTask implements Callable<AtomicInteger> {
        @Override
        public AtomicInteger call() {
            for (int j = 0; j < ITERATIONS; j++) {
                nextCounter();
            }
            System.out.println(Thread.currentThread().getName() + " Counter: " + COUNTER.get());
            return COUNTER;
        }
    }

    public static void nextCounter() {
        COUNTER.incrementAndGet();
    }
}
