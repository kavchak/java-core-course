package javaCourse.homework.lesson11_2;

import java.text.SimpleDateFormat;

public class JobQueueMainRunner {
    private static final int WORKER_THREADS = 1;
    private static final int PRODUCER_THREADS = 1;
    private static final int PRODUCER_SLEEP_TIME = 5000;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        JobQueue jobQueue = new JobQueue();
        JobQueueMainRunner runner = new JobQueueMainRunner();
        runner.startWorkerThread(jobQueue);
        runner.startProducerThread(jobQueue);
    }

    private void startWorkerThread(JobQueue jobQueue) {
        for (int i = 0; i < WORKER_THREADS; i++) {
            Thread workerThread = new Thread(new WorkerTask(jobQueue), "Worker-" + i);
            workerThread.start();
        }
    }

    private void startProducerThread(JobQueue jobQueue) {
        for (int i = 0; i < PRODUCER_THREADS; i++) {
            ProducerTask producerTask = new ProducerTask(jobQueue, PRODUCER_SLEEP_TIME, DATE_FORMAT);
            Thread producerThread = new Thread(producerTask, "Producer-" + i);
            producerThread.start();
        }
    }
}