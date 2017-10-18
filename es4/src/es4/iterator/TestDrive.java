package es4.iterator;

import es4.exceptions.OutOfBoundsException;

import java.util.Iterator;

/**
 * Created by affo on 18/10/17.
 */
public class TestDrive {
    public static void main(String[] args) throws OutOfBoundsException {
        final int rows = 4, columns = 3;
        Matrix<Integer> matrix = new Matrix<>(Integer.class, rows, columns);

        for (int i = 0, count = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++, count++) {
                matrix.set(i, j, count);
            }
        }

        System.out.println(matrix);

        Integer el = matrix.get(1, 2);
        System.out.println(el);
        matrix.set(1, 2, 42);
        el = matrix.get(1, 2);
        System.out.println(el);
        System.out.println();
        System.out.println();


        Iterator<Integer> it = matrix.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        /*
        // Equivalentemente:
        for (Integer i: matrix) {
            System.out.println(i);
        }
        */
    }
}
