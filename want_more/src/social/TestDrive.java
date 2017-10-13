package social;

/**
 * Created by affo on 11/10/17.
 */
public class TestDrive {
    public static void main(String[] args) {
        // Creiamo un po' di utenti registrati e non
        RegisteredUser gianni = new RegisteredUser("gianni", Sex.MALE);
        RegisteredUser pinotto = new RegisteredUser("pinotto", Sex.MALE);
        RegisteredUser barbara = new RegisteredUser("barbara", Sex.MALE);
        AnonymousUser a1 = new AnonymousUser();
        AnonymousUser a2 = new AnonymousUser();

        String post1 = "So funny to play with @pinotto yesterday";
        String post2 = "Love you all guys! That #dinner was spectacular!";
        String post3 = "When you are in that situation and #sbam @barbara @gianni";
        String post4 = "I hate the #universe @everybody";
        String post5 = "#lol @myself cus I am so funny";
        String post6 = "Nel mezzo del #cammin di nostra vita @alighieriRulez";

        gianni.post(post1);
        barbara.post(post2);
        RPost twoTagsPost = gianni.post(post3);
        System.out.println("Tagged people in: \"" + twoTagsPost.toString() + "\"");
        System.out.println(twoTagsPost.getTagged());
        System.out.println("Hashtags in: \"" + twoTagsPost.toString() + "\"");
        System.out.println(twoTagsPost.getHashtags());
        a1.post(post4);
        a1.post(post5);
        a2.post(post6);

        System.out.println("Gianni posted");
        System.out.println(gianni.getPosts());
        System.out.println("Pinotto posted");
        System.out.println(pinotto.getPosts());
        System.out.println("Barbara posted");
        System.out.println(barbara.getPosts());

        System.out.println("HASHTAG RANK:");
        System.out.println(HashtagRanking.getRanking());
    }
}
