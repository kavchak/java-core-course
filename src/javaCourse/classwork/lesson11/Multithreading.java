package javaCourse.classwork.lesson11;

import javaCourse.classwork.lesson10.FutureTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Multithreading {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future<LocalDateTime>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futures.add(executorService.submit(new FutureTest.CurrentDateTime()));
        }

        futures.get(3).cancel(true);

        executorService.shutdown();

//        Callable<LocalDateTime> callable = new FutureTest.CurrentDateTime();
//        Future<LocalDateTime> future = executorService.submit(callable);
//
//        Future<LocalDateTime> future1 = executorService.submit(new FutureTest.CurrentDateTime());

//        System.out.println(future1.get(10, TimeUnit.SECONDS));

//        for (Future<LocalDateTime> future: futures) {
//            System.out.println(future.get());
//        }
    }
}