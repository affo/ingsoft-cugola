package es2.RPS;

/**
 * Created by affo on 10/10/17.
 */
public enum Outcome {
    WINS("Hai vinto!"),
    LOOSES("Hai perso!"),
    DRAW("Pari e patta...");

    private final String description;

    Outcome(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
