package concurrency;

import java.util.Scanner;

/**
 * Created by affo on 29/11/17.
 */
public class BarrierTestDrive {
    public static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) throws InterruptedException {
        Barrier barrier = new Barrier(NUMBER_OF_THREADS);

        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        for (int i = 0; i < NUMBER_OF_THREADS - 1; i++) {
            threads[i] = new Thread(new Participant(barrier));
            threads[i].start();
        }
        threads[NUMBER_OF_THREADS - 1] = new Thread(new Participant(barrier));

        new Scanner(System.in).nextLine();

        threads[NUMBER_OF_THREADS - 1].start();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i].join();
        }
    }

    public static class Participant implements Runnable {
        private Barrier barrier;

        public Participant(Barrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " - Coming to rendez vous...");
            try {
                barrier.rendezVous();
            } catch (InterruptedException e) {
                System.out.println("Interrupted while waiting at rendez vous: " + e.getMessage());
            }

            System.out.println(Thread.currentThread().getName() + " - Rendez vous reached, exiting...");
        }
    }
}
