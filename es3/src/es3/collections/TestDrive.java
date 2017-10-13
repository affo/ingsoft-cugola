package es3.collections;

/**
 * Created by affo on 13/10/17.
 */
public class TestDrive {
    public static void main(String[] args) {
        HashtagRanking ranking = new HashtagRanking();

        Hashtag weekend = new Hashtag("weekend");
        Hashtag friday13 = new Hashtag("friday13");
        Hashtag instagramDown = new Hashtag("instadown");

        ranking.addHashtag(weekend);
        ranking.addHashtag(weekend);
        ranking.addHashtag(weekend);
        ranking.addHashtag(friday13);
        ranking.addHashtag(friday13);

        System.out.println(ranking);

        ranking.addHashtag(friday13);
        ranking.addHashtag(friday13);
        ranking.addHashtag(instagramDown);

        System.out.println(ranking);
    }
}
