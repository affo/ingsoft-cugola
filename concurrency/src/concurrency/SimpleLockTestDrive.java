package concurrency;

import java.util.Random;

/**
 * Created by affo on 29/11/17.
 */
public class SimpleLockTestDrive {
    public static final int NUMBER_OF_THREADS = 10;
    private static String state = "";

    public static void main(String[] args) throws InterruptedException {
        SimpleLock lock = new SimpleLock();
        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i] = new Thread(new Participant(lock));
            threads[i].start();
        }

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i].join();
        }

        System.out.println(state);
    }

    private static class Participant implements Runnable {
        private SimpleLock lock;

        public Participant(SimpleLock lock) {
            this.lock = lock;
        }

        private void randomSleep() {
            try {
                Thread.sleep((long) (new Random().nextFloat() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            randomSleep();

            if (lock.tryLock()) {
                try {
                    state += Thread.currentThread().getName() + "\n";
                    randomSleep();
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " - Exiting, somebody is holding the lock and I am in a hurry");
            }
        }
    }
}
