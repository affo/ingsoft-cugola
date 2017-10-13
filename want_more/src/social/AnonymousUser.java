package social;

/**
 * Created by affo on 11/10/17.
 */
public class AnonymousUser extends User {
    @Override
    public APost post(String content) {
        APost aPost = new APost(this, content);
        posts.add(aPost);
        return aPost;
    }
}
