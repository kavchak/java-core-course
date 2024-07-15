package javaCourse.classwork.lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClockManager {

    public static boolean IS_CLOCK_RUN = true;

    public static void main(String[] args) throws InterruptedException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Thread thread = new Thread(new Clock());
        thread.start();

        System.out.println("після старту годинника");

        Thread.sleep(5000);

        System.out.println("ми прокинулися");

        System.out.println("залишити годинник включеним?");

        IS_CLOCK_RUN = Boolean.parseBoolean(reader.readLine());
        if (!IS_CLOCK_RUN) {
            thread.interrupt();
        }

    }

    public static class Clock implements Runnable {

        @Override
        public void run() {
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("годинник був виключений в момент сну");
                    return;
                }
                System.out.println("Tik");
            }
        }
    }

}
