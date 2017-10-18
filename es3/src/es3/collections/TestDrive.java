package es3.collections;

import java.util.LinkedHashMap;

/**
 * Created by affo on 17/10/17.
 */
public class TestDrive {
    public static void main(String[] args) {
        HashtagRanking ranking = new HashtagRanking();

        Hashtag fuori = new Hashtag("fuoriceilsole");
        Hashtag solo = new Hashtag("solocosebelle");
        Hashtag bomber = new Hashtag("bomber");

        ranking.addHashtag(fuori);
        ranking.addHashtag(solo);
        ranking.addHashtag(solo);

        System.out.println(ranking);

        ranking.addHashtag(fuori);
        ranking.addHashtag(fuori);
        ranking.addHashtag(bomber);

        System.out.println(ranking);

        ranking.addHashtag(bomber);
        ranking.addHashtag(bomber);
        ranking.addHashtag(fuori);

        System.out.println(ranking);

        System.out.println(ranking.getMostPopular());

        LinkedHashMap<Hashtag, Integer> r = ranking.getRanking();
        // ...
        // Puoi usare r e, per esempio, stampare gli hashtag che hanno score dispari
    }
}
