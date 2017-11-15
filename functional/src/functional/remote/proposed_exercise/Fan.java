package functional.remote.proposed_exercise;

/**
 * Created by affo on 15/11/17.
 */
public class Fan {
    public static final int MAX_SPEED = 5;
    private int speed = 0;

    public void decreaseSpeed() {
        speed--;
        if (speed < 0) {
            speed = 0;
        }

        System.out.println("Fan speed set to " + speed);
    }

    public void increaseSpeed() {
        speed++;
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        System.out.println("Fan speed set to " + speed);
    }

    public int getSpeed() {
        return speed;
    }
}
