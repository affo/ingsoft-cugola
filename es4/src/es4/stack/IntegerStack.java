package es4.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by affo on 18/10/17.
 */
public class IntegerStack {
    private final List<Integer> ints = new ArrayList<>();

    public void push(Integer i) {
        ints.add(0, i);
    }

    public Integer pop() {
        if (ints.isEmpty()) {
            return null;
        }

        return ints.remove(0);
    }

    public Integer peek() {
        if (ints.isEmpty()) {
            return null;
        }

        return ints.get(0);
    }
}
