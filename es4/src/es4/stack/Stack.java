package es4.stack;

import es4.exceptions.OutOfBoundsException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by affo on 18/10/17.
 */
public class Stack<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private final int capacity;
    private final List<T> ints;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        if (capacity <= 0) {
            // this is an unchecked exception (runtime)
            throw new IllegalArgumentException("Cannot instantiate a Stack with capacity " + capacity);
        }

        this.capacity = capacity;
        ints = new ArrayList<>(capacity);
    }

    public void push(T i) throws OutOfBoundsException {
        if (ints.size() == capacity) {
            throw new OutOfBoundsException(capacity, "The stack is full");
        }

        ints.add(0, i);
    }

    private void checkEmptiness() throws OutOfBoundsException {
        if (ints.isEmpty()) {
            throw new OutOfBoundsException(0, "The stack is empty");
        }
    }

    public T pop() throws OutOfBoundsException {
        checkEmptiness();

        return ints.remove(0);
    }

    public T peek() throws OutOfBoundsException {
        checkEmptiness();

        return ints.get(0);
    }

    public Iterator<T> iterator() {
        return ints.iterator();
    }
}
