package functional.streams;

import functional.streams.common.DataGenerator;
import functional.streams.common.Person;
import functional.streams.common.Sex;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static functional.streams.common.Utils.print;
import static functional.streams.common.Utils.printLineNo;

/**
 * Created by affo on 11/11/17.
 */
public class Reducers {
    private static DataGenerator data;

    static {
        data = new DataGenerator();
        data.init();
    }

    public static void main(String[] args) {
        // if we want to reuse a stream, we create a supplier for it
        Supplier<Stream<String>> nameSupplier = () -> data.people().map(p -> p.name);
        print(nameSupplier.get());

        // get first names and second names
        Stream<String> namesMixed = nameSupplier.get().flatMap(name -> Stream.of(name.split(" ")));
        print(namesMixed);

        // get every person above 18
        print(data.people().filter(p -> p.age >= 18));
        // get every male
        print(data.people().filter(p -> p.sex == Sex.MALE));

        // not very modular indeed... Another approach:
        Predicate<Person> above18 = p -> p.age >= 18;
        Predicate<Person> male = p -> p.sex == Sex.MALE;

        // get every male above 18
        print(data.people().filter(above18).filter(male));
        print(data.people().filter(p -> above18.test(p) && male.test(p)));

        // Collectors map from Streams to Lists, Sets or Maps
        List<Person> collected = data.people()
                .filter(male)
                .collect(Collectors.toList());
        printLineNo();
        System.out.println(collected);

        // Group by age
        printLineNo("Group by Age");
        Map<Integer, List<Person>> byAge = data.people()
                .collect(Collectors.groupingBy(p -> p.age));

        byAge.forEach((age, person) -> {
            List<String> names = person.stream().map(p -> p.name).collect(Collectors.toList());
            System.out.println("Age " + age + ": " + names);
        });

        // Average Age of people
        printLineNo("Average age");
        Integer sumOfAges = data.people().map(p -> p.age).reduce(0, (acc, age) -> acc + age);
        double avg = (double) sumOfAges / data.people().count();
        System.out.println(avg);

        AvgAccumulator reduced = data.people()
                //.parallel() // you can compute the result in parallel
                .reduce(
                        new AvgAccumulator(),
                        (avgAccumulator, person) -> {
                            System.out.println("Accumulator: sum " + avgAccumulator.sum + ", person " + person.name);
                            double sum = avgAccumulator.sum + person.age;
                            int count = avgAccumulator.count + 1;
                            return new AvgAccumulator(sum, count);

                            // What if:
                            /*
                            avgAccumulator.add(person.age);
                            return avgAccumulator;
                            */
                            // ??
                        }, (acc1, acc2) -> {
                            System.out.println("Combiner: sum1 " + acc1.sum + ", sum2 " + acc2.sum);
                            AvgAccumulator merged = new AvgAccumulator();
                            merged.count = acc1.count + acc2.count;
                            merged.sum = acc1.sum + acc2.sum;
                            return merged;
                        });

        System.out.println(reduced.getAvg());

        data.people().mapToInt(p -> p.age).average().ifPresent(System.out::println);

        // Average with collector
        Collector<Person, AvgAccumulator, Double> avgCollector =
                Collector.of(
                        AvgAccumulator::new,                    // supplier
                        (acc, person) -> acc.add(person.age),   // accumulator
                        AvgAccumulator::merge,                  // combiner
                        AvgAccumulator::getAvg                  // finisher
                );

        printLineNo("Average with collector");
        avg = data.people()
                .parallel()
                .collect(avgCollector);
        System.out.println(avg);

        printLineNo("Merging Names");
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),
                        (j, p) -> j.add(p.name.toUpperCase()),
                        StringJoiner::merge,
                        StringJoiner::toString
                );

        String names = data.people().collect(personNameCollector);
        System.out.println(names);
    }

    private static class AvgAccumulator {
        double sum = 0;
        int count = 0;

        public AvgAccumulator() {
        }

        public AvgAccumulator(double sum, int count) {
            this.sum = sum;
            this.count = count;
        }

        double getAvg() {
            if (count == 0) {
                return 0;
            }

            return sum / count;
        }

        /**
         * NOT pure
         *
         * @param val
         */
        void add(double val) {
            this.sum += val;
            this.count++;
        }

        /**
         * NOT pure
         *
         * @param other
         * @return
         */
        AvgAccumulator merge(AvgAccumulator other) {
            System.out.println("Merging collectors: " + this.sum + " - " + other.sum);
            this.sum += other.sum;
            this.count += other.count;
            return this;
        }
    }
}
