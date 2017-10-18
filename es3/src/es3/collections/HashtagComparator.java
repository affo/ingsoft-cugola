package es3.collections;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by affo on 18/10/17.
 */
public class HashtagComparator implements Comparator<Hashtag> {
    private final Map<Hashtag, Integer> scores;

    public HashtagComparator(Map<Hashtag, Integer> scores) {
        this.scores = scores;
    }

    @Override
    public int compare(Hashtag ht1, Hashtag ht2) {
        Integer score1 = scores.get(ht1);
        Integer score2 = scores.get(ht2);
        return Integer.compare(score2, score1);
    }
}
