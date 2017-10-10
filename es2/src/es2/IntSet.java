package es2;

/**
 * Created by affo on 10/10/17.
 */
public class IntSet {
    public final static int MAX = 10;
    private Integer[] elements;

    public IntSet() {
        this(MAX);
    }

    public IntSet(int capacity) {
        elements = new Integer[capacity];
    }

    public void add(int e) {
        if (!contains(e)) {
            int i = 0;
            for (; i < elements.length; i++) {
                if (elements[i] == null) {
                    break;
                }
            }

            if (i < elements.length) {
                elements[i] = e;
            }
        }

    }

    public void remove(int e) {
        for (int j = 0; j < elements.length; j++) {
            if (elements[j] == e) {
                elements[j] = null;
                break;
            }
        }
    }

    public boolean contains(int e) {
        for (Integer element : elements) {
            if (element != null && element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IntSet set = new IntSet();

        set.add(1);
        System.out.println(set.contains(1));
        set.remove(1);
        System.out.println(set.contains(1));
    }
}
