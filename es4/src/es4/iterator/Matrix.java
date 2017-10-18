package es4.iterator;

import es4.exceptions.OutOfBoundsException;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * Created by affo on 18/10/17.
 */
public class Matrix<T> implements Iterable<T> {
    public final int rows, columns;
    private final T[][] matrix;

    @SuppressWarnings("unchecked")
    public Matrix(Class<T> clazz, int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = (T[][]) Array.newInstance(clazz, rows, columns);
    }

    private void checkPos(int row, int column) throws OutOfBoundsException {
        if (row < 0 || column < 0) {
            throw new OutOfBoundsException(0, "Row or column is less than 0");
        }

        if (row >= rows) {
            throw new OutOfBoundsException(rows, "Row bound exceeded: " + row + " >= " + rows);
        }

        if (column >= columns) {
            throw new OutOfBoundsException(columns, "Column bound exceeded: " + column + " >= " + columns);
        }
    }

    public T get(int row, int column) throws OutOfBoundsException {
        checkPos(row, column);

        return matrix[row][column];
    }

    public void set(int row, int column, T e) throws OutOfBoundsException {
        checkPos(row, column);

        matrix[row][column] = e;
    }

    @Override
    public Iterator<T> iterator() {
        return new MatrixIterator<>(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append("\t").append(matrix[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
