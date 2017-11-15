package functional.streams.common;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by affo on 11/11/17.
 */
public class DataGenerator {
    public static int NO_PEOPLE = 20;
    public static int MIN_AGE = 16;
    public static int MAX_AGE = 70;

    private static final String[] FIRST_NAMES = {
            "Luke",
            "Sam",
            "William",
            "Peter",
            "Greg",
            "John",
            "Stan",
            "Helen",
            "Emily",
            "Sharon",
            "Susan",
            "Joanne"
    };

    private static final String[] LAST_NAMES = {
            "McCarthy",
            "Lennon",
            "Potter",
            "Clinton",
            "Sanchez",
            "Washington",
            "Fowler",
            "Rosenthal",
            "Turing"
    };

    private Set<Person> people;
    private final Random random;

    public DataGenerator() {
        this(0);
    }

    public DataGenerator(int seed) {
        people = new HashSet<>();
        random = new Random(seed);
    }

    private <T> T randomElement(T[] array) {
        int chosenIndex = random.nextInt(array.length);
        return array[chosenIndex];
    }

    public void init() {
        people = IntStream.range(0, NO_PEOPLE).mapToObj(
                index -> {
                    int age = random.nextInt((MAX_AGE - MIN_AGE) + 1) + MIN_AGE;
                    String name = randomElement(FIRST_NAMES) + " " + randomElement(LAST_NAMES);
                    Sex sex = randomElement(Sex.values());
                    Nation nationality = randomElement(Nation.values());
                    return new Person(age, name, sex, nationality);
                }
        ).collect(Collectors.toSet());
    }

    public Stream<Person> people() {
        return people.stream();
    }
}
