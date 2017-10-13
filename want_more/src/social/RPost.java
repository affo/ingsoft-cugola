package social;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by affo on 11/10/17.
 */
public class RPost extends Post {
    private final RegisteredUser op;
    private final Set<RegisteredUser> tagged;

    public RPost(RegisteredUser op, String content) {
        super(content);
        this.op = op;
        this.tagged = PostParser.extractTags(content);
    }

    @Override
    public Post edit(String content) {

        return new RPost(op, content);
    }

    @Override
    public RegisteredUser getOriginalPoster() {
        return op;
    }

    public Set<RegisteredUser> getTagged() {
        return new HashSet<>(tagged);
    }
}
