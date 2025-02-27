package javaCourse.homework.lesson11_2;

public class WorkerTask implements Runnable {
    private final JobQueue jobQueue;

    public WorkerTask(JobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Runnable job = jobQueue.getJob();
                System.out.println(Thread.currentThread().getName() + " is processing a job.");
                job.run();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}