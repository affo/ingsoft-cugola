package social;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by affo on 11/10/17.
 */
public abstract class Post {
    private final String content;
    protected final Set<Hashtag> hashtags;

    public Post(String content) {
        this.content = content;
        this.hashtags = PostParser.extractHashtags(content);
        for (Hashtag ht : hashtags) {
            HashtagRanking.addHashtag(ht);
        }
    }

    public abstract Post edit(String content);

    public Set<Hashtag> getHashtags() {
        return new HashSet<>(hashtags);
    }

    public abstract User getOriginalPoster();

    @Override
    public String toString() {
        return content;
    }
}
