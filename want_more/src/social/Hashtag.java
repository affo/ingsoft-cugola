package social;

/**
 * Created by affo on 11/10/17.
 */
public class Hashtag {
    public final String representation;

    public Hashtag(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    @Override
    public String toString() {
        return "#" + representation;
    }
}
