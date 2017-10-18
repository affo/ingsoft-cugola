package es4.exceptions;

/**
 * Created by affo on 18/10/17.
 */
public class OutOfBoundsException extends Exception {
    private final int bound;

    public OutOfBoundsException(int bound, String reason) {
        super("Bound reached (" + bound + ") - " + reason);
        this.bound = bound;
    }

    public int getBound() {
        return bound;
    }
}
