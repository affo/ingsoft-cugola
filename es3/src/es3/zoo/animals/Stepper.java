package es3.zoo.animals;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by affo on 12/10/17.
 */
class Stepper {
    private final Timer timer;
    private final Animal animal;

    public Stepper(Animal animal) {
        this.animal = animal;
        timer = new Timer();
    }

    public void start() {
        //System.out.println(animal.getSpeed());
        //System.out.println(animal.getSpeed().getMillis());

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.print(animal.getFootprint() + " ");
            }
        }, 0, animal.getSpeed().getMillis());
    }

    public void stop() {
        System.out.println();
        timer.cancel();
        timer.purge();
    }
}
