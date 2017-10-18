package es4.iterator;

import es4.exceptions.OutOfBoundsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by affo on 18/10/17.
 */
public class MatrixIterator<T> implements Iterator<T> {
    private final Matrix<T> matrix;
    private int currentRow, currentColumn;
    private boolean deadEnd = false;

    public MatrixIterator(Matrix<T> matrix) {
        this.matrix = matrix;
        currentRow = 0;
        currentColumn = 0;
    }

    @Override
    public boolean hasNext() {
        return !deadEnd;
    }

    @Override
    public T next() {
        T nextElement;
        try {
            nextElement = matrix.get(currentRow, currentColumn);
        } catch (OutOfBoundsException e) {
            throw new NoSuchElementException("Matrix dead end reached");
        }

        currentColumn++;
        if (currentColumn == matrix.columns) {
            currentColumn = 0;
            currentRow++;
            if (currentRow == matrix.rows) {
                deadEnd = true;
            }
        }

        return nextElement;
    }
}
