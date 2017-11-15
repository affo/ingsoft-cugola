package functional.streams.common;

import java.util.stream.Stream;

/**
 * Created by affo on 15/11/17.
 */
public class Utils {
    public static int getLineNo() {
        return new Throwable().getStackTrace()[1].getLineNumber();
    }

    private static int getLineNo(int nesting) {
        return new Throwable().getStackTrace()[nesting].getLineNumber();
    }

    public static void printLineNo() {
        printLineNo("", 2);
    }

    public static void printLineNo(String tag) {
        printLineNo(tag, 2);
    }


    private static void printLineNo(String tag, int nesting) {
        String tagPart = tag.isEmpty() ? "" : " - " + tag + " -";
        System.out.println("\n>>>" + tagPart + " At line " + getLineNo(nesting + 1));
    }

    public static void print(Stream<?> stream) {
        printLineNo("",2);
        stream.forEach(System.out::println);
    }

    public static class Couple<T1, T2> {
        public final T1 first;
        public final T2 second;

        public Couple(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public static <Q, R> Couple<Q, R> of(Q first, R second) {
            return new Couple<>(first, second);
        }
    }
}
