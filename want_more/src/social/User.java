package social;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by affo on 11/10/17.
 */
public abstract class User {
    private static int incrementalId = 0;
    private final int id;
    protected final List<Post> posts;

    public User() {
        posts = new LinkedList<>();
        this.id = incrementalId;
        incrementalId++;
    }

    public String getUsername() {
        return "anonymous-" + id;
    }

    public abstract Post post(String content);

    public List<Post> getPosts() {
        return new LinkedList<>(posts);
    }

    @Override
    public String toString() {
        return "User{" + getUsername() + '}';
    }
}
