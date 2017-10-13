package es3.collections;

import java.util.*;

/**
 * Created by affo on 12/10/17.
 */
public class HashtagRanking {
    private List<HTCounter> ranking = new LinkedList<>();
    private Map<Hashtag, HTCounter> hashtagIndex = new HashMap<>();

    // you'll see later
    public LinkedHashMap<Hashtag, Integer> getRanking() {
        LinkedHashMap<Hashtag, Integer> ranking = new LinkedHashMap<>();

        for (HTCounter counter : this.ranking) {
            ranking.put(counter.ht, counter.count);
        }

        return ranking;
    }

    public void addHashtag(Hashtag ht) {
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
                        return Integer.compare(o2.count, o1.count);
                    }
                }
        );
    }

    public Hashtag getMostPopular() {
        if (ranking.isEmpty()) {
            return null;
        }

        return ranking.get(0).ht;
    }

    // inner class guys/girls
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("RANKING\n");
        for (HTCounter counter : this.ranking) {
            result.append("\t")
                    .append(counter.ht)
                    .append(": ")
                    .append(counter.count)
                    .append("\n");
        }
        return result.toString();
    }
}
