package functional.streams;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static functional.streams.common.Utils.*;

/**
 * Created by affo on 11/11/17.
 */
public class Basics {
    public static void main(String[] args) {
        //------------- Creation
        // from elements
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5);
        printLineNo();
        ints.forEach(System.out::println);

        // from Collection
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        ints = list.stream();
        print(ints);
        // from set
        print(new HashSet<>(list).stream());

        // What if we try to print the names again?
        // What do we get? -> IllegalStateException!
        // Indeed streams can only stream once:
        try {
            print(ints);
        } catch (Exception e) {
            System.out.println("Argh, panta rei: " + e.getMessage());
        }

        Supplier<Stream<Integer>> intSupplier = () -> Stream.of(1, 2, 2, 4, 3);
        print(intSupplier.get());
        print(intSupplier.get());

        //------------- Map, Filter
        Stream<Integer> result = intSupplier.get()
                .map(i -> i + 1)
                .filter(i -> i > 1);

        print(result);

        // other operators and Optional
        printLineNo();
        intSupplier.get().findFirst().ifPresent(System.out::println);
        System.out.println(intSupplier.get().allMatch(i -> i % 2 == 0));
        print(intSupplier.get().sorted());
        print(intSupplier.get().distinct());
        print(intSupplier.get().limit(3));
        print(intSupplier.get().skip(2));

        //------------- IntStream, LongStream, DoubleStream
        printLineNo();
        Supplier<IntStream> getRange = () -> IntStream.range(0, 10);
        // also average(), count()
        getRange.get().max().ifPresent(System.out::println);

        long sum = Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .sum();
        printLineNo();
        System.out.println(sum);

        printLineNo();
        getRange.get().mapToObj(i -> "foo" + i).forEach(System.out::println);

        //------------- FlatMap
        Supplier<Stream<String>> exampleStreamSupplier = () -> Stream.of("a3", "d2", "c2", "b1");
        // now compute a stream where the number of letters in position 0 is the number in position 1 in every string
        printLineNo();
        exampleStreamSupplier.get()
                .map(s -> {
                    String letter = s.substring(0, 1);
                    Integer occurr = Integer.parseInt(s.substring(1));
                    return new Couple<>(letter, occurr);
                })
                .flatMap(couple -> IntStream.range(0, couple.second).mapToObj(i -> couple.first))
                .sorted()
                .forEach(System.out::println);

        //------------- Processing Order
        printLineNo("Lazy");
        exampleStreamSupplier.get()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                });

        printLineNo();
        exampleStreamSupplier.get()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));

        printLineNo();
        exampleStreamSupplier.get()
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

        printLineNo("Order matters"); // try to invert filter with map
        exampleStreamSupplier.get()
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        printLineNo("Add sorted"); // try to invert filter with map
        exampleStreamSupplier.get()
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}
