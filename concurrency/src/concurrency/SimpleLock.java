package concurrency;

/**
 * Created by affo on 29/11/17.
 */
public class SimpleLock {
    private boolean locked = false;

    public synchronized void lock() throws InterruptedException {
        while (locked) {
            wait();
        }

        locked = true;
    }

    public synchronized void unlock() {
        locked = false;
        notifyAll();
    }

    public synchronized boolean tryLock() {
        if (locked) {
            return false;
        }

        locked = true;
        return true;
    }
}
