package concurrency;

/**
 * Created by affo on 29/11/17.
 */
public class SemaphoreParticipant implements Runnable {
    private static int incrementalID = 0;
    private final MySemaphore theSemaphore;
    private String name;
    private final int eagerness;

    public SemaphoreParticipant(MySemaphore theSemaphore, int eagerness) {
        this.theSemaphore = theSemaphore;
        this.name = "participant-" + incrementalID;
        this.eagerness = eagerness;
        incrementalID++;
    }

    public SemaphoreParticipant name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public void run() {
        String prefix = Thread.currentThread().getName() + " - " + name + " - ";
        System.out.println(prefix + "1 - Running...");
        System.out.println(prefix + "2 - Acquiring semaphore... [" + eagerness + "]");
        try {
            theSemaphore.acquire(eagerness);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(prefix + "3 - Semaphore acquired");
        System.out.println(prefix + "4 - Exiting...");
    }
}
