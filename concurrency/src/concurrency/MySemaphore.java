package concurrency;

/**
 * Created by affo on 29/11/17.
 */
public class MySemaphore {
    private int numberOfPermits;

    public MySemaphore() {
        this(0);
    }

    public MySemaphore(int numberOfPermits) {
        this.numberOfPermits = numberOfPermits;
    }

    public synchronized void acquire() throws InterruptedException {
        acquire(1);
    }

    public synchronized void release() {
        release(1);
    }

    public synchronized void acquire(int n) throws InterruptedException {
        while (numberOfPermits < n) {
            wait();
        }

        numberOfPermits -= n;
    }

    public synchronized void release(int n) {
        numberOfPermits += n;
        notifyAll();
    }
}
