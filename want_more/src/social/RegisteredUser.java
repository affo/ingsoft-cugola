package social;

/**
 * Created by affo on 11/10/17.
 */
public class RegisteredUser extends User {
    private String username;
    private final Sex sex;
    private String password;

    public RegisteredUser(String username, Sex sex) {
        this.username = username;
        this.sex = sex;
        // default stupid password
        this.password = username;

        UserIndex.indexUser(this);
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Sex getSex() {
        return sex;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public RPost post(String content) {
        RPost rPost = new RPost(this, content);
        posts.add(rPost);
        return rPost;
    }

    public String getPassword() {
        return password;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
