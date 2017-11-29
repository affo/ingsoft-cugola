package concurrency;

import java.util.Scanner;

/**
 * Created by affo on 29/11/17.
 */
public class MySemaphoreTestDrive {
    public static final int NUMBER_OF_THREADS = 3;
    public static void main(String[] args) {
        MySemaphore theSemaphore = new MySemaphore();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            new Thread(new SemaphoreParticipant(theSemaphore, i + 1)).start();
        }

        Scanner in = new Scanner(System.in);
        boolean stop = false;
        String input;
        do {
            input = in.nextLine();
            if (input.startsWith("Q")) {
                stop = true;
            } else {
                try {
                    int numberOfPermits = input.isEmpty() ? 1 : Integer.parseInt(input);
                    System.out.println("\n>>> Releasing " + numberOfPermits + " permits\n");
                    theSemaphore.release(numberOfPermits);
                } catch (Exception e) {
                    System.out.println("Exception while parsing input: " + e.getMessage());
                }
            }
        } while (!stop);
    }
}
