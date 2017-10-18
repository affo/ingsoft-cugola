package es3.collections;

import java.util.*;

/**
 * Created by affo on 17/10/17.
 */
public class HashtagRanking {
    private List<Hashtag> ranking;
    private Map<Hashtag, Integer> scores;

    public HashtagRanking() {
        ranking = new LinkedList<>();
        scores = new HashMap<>();
    }

    public void addHashtag(Hashtag ht) {
        Integer score = this.scores.get(ht);
        if (score == null) {
            ranking.add(ht);
            score = 1;
        } else {
            score++;
        }

        scores.put(ht, score);

        ranking.sort(new HashtagComparator(scores));

        /*
        // Al posto di scrivere una nuova classe in un file separato
        // per l'HashtagComparator e dover passare `scores` da costruttore,
        // potete usare una anonymous inner class, così:

        ranking.sort(
                new Comparator<Hashtag>() {
                    @Override
                    public int compare(Hashtag ht1, Hashtag ht2) {
                        // `scores` è l'attributo privato di `HashtagRanking`
                        Integer score1 = scores.get(ht1);
                        Integer score2 = scores.get(ht2);
                        return Integer.compare(score2, score1);
                    }
                }
        );
        */
    }

    public void removeHashtag(Hashtag ht) {
        Integer score = this.scores.get(ht);
        if (score == null) {
            return;
        }

        score--;

        scores.put(ht, score);

        ranking.sort(
                new Comparator<Hashtag>() {
                    @Override
                    public int compare(Hashtag ht1, Hashtag ht2) {
                        Integer score1 = scores.get(ht1);
                        Integer score2 = scores.get(ht2);
                        return Integer.compare(score2, score1);
                    }
                }
        );
    }

    public LinkedHashMap<Hashtag, Integer> getRanking() {
        LinkedHashMap<Hashtag, Integer> result = new LinkedHashMap<>();

        for (Hashtag ht : this.ranking) {
            result.put(ht, scores.get(ht));
        }

        return result;
    }

    public Hashtag getMostPopular() {
        if (ranking.isEmpty()) {
            return null;
        }

        return ranking.get(0);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Ranking:\n");

        for (Hashtag ht : ranking) {
            result.append("\t")
                    .append(ht)
                    .append(": ")
                    .append(scores.get(ht))
                    .append("\n");
        }

        return result.toString();
    }
}
