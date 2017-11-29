package concurrency;

/**
 * Created by affo on 29/11/17.
 */
public class Barrier {
    private final MySemaphore semaphore;
    public final int numberOfThreads;
    private int count = 0;

    public Barrier(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.semaphore = new MySemaphore();
    }

    public void rendezVous() throws InterruptedException {
        synchronized (this) {
            count++;
        }

        // this is true only once! (at the n-th thread)
        if (count == numberOfThreads) {
            semaphore.release();
        }

        semaphore.acquire();
        semaphore.release();
    }
}
