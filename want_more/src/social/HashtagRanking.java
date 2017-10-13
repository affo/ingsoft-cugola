package social;

import java.util.*;

/**
 * Created by affo on 12/10/17.
 */
public class HashtagRanking {
    private static List<HTCounter> ranking = new LinkedList<>();
    private static Map<Hashtag, HTCounter> hashtagIndex = new HashMap<>();


    public static LinkedHashMap<Hashtag, Integer> getRanking() {
        LinkedHashMap<Hashtag, Integer> ranking = new LinkedHashMap<>();

        for (HTCounter counter : HashtagRanking.ranking) {
            ranking.put(counter.ht, counter.count);
        }

        return ranking;
    }

    public static void addHashtag(Hashtag ht) {
        HTCounter c = hashtagIndex.get(ht);
        if (c == null) {
            // first time I see this hashtag
            c = new HTCounter(ht);
            hashtagIndex.put(ht, c);
            ranking.add(c);
        }
        c.increment();

        // this is an anonymous class guys/girls
        ranking.sort(
                new Comparator<HTCounter>() {
                    @Override
                    public int compare(HTCounter o1, HTCounter o2) {
                        return Integer.compare(o1.count, o2.count);
                    }
                }
        );
    }

    public static Hashtag getMostPopular() {
        if (ranking.isEmpty()) {
            return null;
        }

        return ranking.get(0).ht;
    }

    private static class HTCounter {
        public final Hashtag ht;
        private int count = 0;

        public HTCounter(Hashtag ht) {
            this.ht = ht;
        }

        public void increment() {
            count++;
        }

        public void decrement() {
            count--;
        }
    }
}
