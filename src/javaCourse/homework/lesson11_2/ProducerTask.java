package javaCourse.homework.lesson11_2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProducerTask implements Runnable {
    private final JobQueue jobQueue;
    private final int sleepTime;
    private final SimpleDateFormat dateFormat;

    public ProducerTask(JobQueue jobQueue, int sleepTime, SimpleDateFormat dateFormat) {
        this.jobQueue = jobQueue;
        this.sleepTime = sleepTime;
        this.dateFormat = dateFormat;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Runnable job = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Current time: " + dateFormat.format(new Date()));
                    }
                };
                jobQueue.put(job);
                System.out.println(Thread.currentThread().getName() + " added a task to the queue.");
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}