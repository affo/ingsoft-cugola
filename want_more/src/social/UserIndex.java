package social;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by affo on 11/10/17.
 */
public class UserIndex {
    private static final Map<String, RegisteredUser> byName = new HashMap<>();

    public static RegisteredUser byName(String username) {
        return byName.get(username);
    }

    public static boolean isUsernameUnique(String username) {
        return !byName.containsKey(username);
    }

    public static boolean userExists(String username) {
        return byName.containsKey(username);
    }

    public static void indexUser(RegisteredUser user) {
        byName.put(user.getUsername(), user);
    }
}
