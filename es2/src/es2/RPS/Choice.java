package es2.RPS;

import java.util.Random;

/**
 * Created by affo on 10/10/17.
 */
public enum Choice {
    ROCK, PAPER, SCISSORS;

    private static final Random rand = new Random();

    public Outcome result(Choice that) {
        if (this == that) {
            return Outcome.DRAW;
        }

        switch (this) {
            case PAPER:
                Outcome result;
                if (that == SCISSORS) {
                    result = Outcome.LOOSES;
                } else {
                    result = Outcome.WINS;
                }
                return result;
            case ROCK:
                return that == PAPER ? Outcome.LOOSES : Outcome.WINS;
            default:
                return that == ROCK ? Outcome.LOOSES : Outcome.WINS;
        }
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    public static Choice random() {
        int numberOfElements = Choice.values().length;
        int randomIndex = rand.nextInt(numberOfElements);
        return Choice.values()[randomIndex];
    }
}
