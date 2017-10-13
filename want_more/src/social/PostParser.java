package social;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by affo on 11/10/17.
 */
public class PostParser {
    public static Set<Hashtag> extractHashtags(String content) {
        Set<Hashtag> result = new HashSet<>();

        String[] words = content.split(" ");
        for (String word : words) {
            if (word.startsWith("#")) {
                result.add(new Hashtag(word.substring(1)));
            }
        }

        return result;
    }

    public static Set<RegisteredUser> extractTags(String content) {
        Set<RegisteredUser> result = new HashSet<>();

        String[] words = content.split(" ");
        for (String word : words) {
            if (word.startsWith("@")) {
                String username = word.substring(1);
                if (UserIndex.userExists(username)) {
                    result.add(UserIndex.byName(username));
                }
            }
        }

        return result;
    }
}
