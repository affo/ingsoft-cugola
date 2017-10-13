package es3.zoo.animals;

/**
 * Created by affo on 12/10/17.
 */
public abstract class Animal {
    private Stepper stepper;

    public void walk() {
        // for idempotence
        if (stepper == null) {
            stepper = new Stepper(this);
            stepper.start();
        }
    }

    public void rest() {
        stepper.stop();
    }

    protected abstract String getFootprint();

    protected abstract Speed getSpeed();
}
