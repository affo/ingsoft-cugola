package social;

/**
 * Created by affo on 11/10/17.
 */
public class APost extends Post {
    private AnonymousUser op;

    public APost(AnonymousUser anonymousUser, String content) {
        super(content);
        this.op = anonymousUser;
    }

    @Override
    public Post edit(String content) {
        return new APost(op, content);
    }

    @Override
    public AnonymousUser getOriginalPoster() {
        return op;
    }
}
