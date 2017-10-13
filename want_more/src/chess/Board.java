package chess;

import java.util.HashMap;
import java.util.Map;

public class Board {
    public static final int DIM = 8;
    private Map<Position, Piece> pieces = new HashMap<>();

    public boolean add(Position pos, Piece p) throws OutOfBoundsException {
        validatePosition(pos);

        pieces.put(pos, p);
        return true;
    }

    public void remove(Position p) {
        pieces.remove(p);
    }

    public boolean isEmpty(Position p) {
        return pieces.get(p) == null;
    }

    private boolean checkHV(Position startP, Position endP) {
        boolean horizontal = startP.row == endP.row;

        if (horizontal) {
            // move left or right?
            int start = startP.column;
            int end = endP.column;
            if (startP.column > endP.column) {
                int tmp = start;
                start = end;
                end = tmp;
            }

            start++;
            for (; start < end; start++) {
                if (!isEmpty(Position.of(startP.row, start))) {
                    return false;
                }
            }
        } else {
            // move up or down?
            int start = startP.row;
            int end = endP.row;
            if (startP.row > endP.row) {
                int tmp = start;
                start = end;
                end = tmp;
            }

            start++;
            for (; start < end; start++) {
                if (!isEmpty(Position.of(start, startP.column))) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkDiagonal(Position startP, Position endP) {
        int delta = Math.abs(startP.row - endP.row);
        int rowSign = (int) Math.signum(endP.row - startP.row);
        int columnSign = (int) Math.signum(endP.column - startP.column);

        for (int i = 1; i < delta; i++) {
            int row = startP.row + rowSign * i;
            int column = startP.column + columnSign * i;
            if (!isEmpty(Position.of(row, column))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPosition(Position startP, Position endP) {
        if (startP.isOnHV(endP)) {
            return checkHV(startP, endP);
        }

        if (startP.isOnDiagonal(endP)) {
            return checkDiagonal(startP, endP);
        }

        return true;
    }

    private void validatePosition(Position p) throws OutOfBoundsException {
        boolean invalidRow = p.row < 0 || p.row >= DIM;
        boolean invalidColumn = p.column < 0 || p.column >= DIM;
        if (invalidRow || invalidColumn) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean move(Position a, Position b) throws OutOfBoundsException {
        validatePosition(a);
        validatePosition(b);

        Piece p = pieces.get(a);
        boolean isTargetFull = !isEmpty(b);

        boolean ok = true;
        if (isTargetFull) {
            ok = p.getColor() != pieces.get(b).getColor();
        }
        ok = ok && p.isRegularMove(a, b, isTargetFull);

        if (ok) {
            if (!checkPosition(a, b)) {
                return false;
            }

            // we can move
            remove(a);
            add(b, p);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = DIM - 1; i >= 0; i--) {
            sb.append(i);
            sb.append(" - ");
            for (int j = 0; j < DIM; j++) {
                Piece p = pieces.get(Position.of(i, j));
                String print = p != null ? p.toString() : " -- ";
                sb.append(print);
                sb.append(" ");
            }
            sb.append('\n');
        }

        sb.append("   ");
        for (int i = 0; i < DIM; i++) {
            sb.append("  |  ");
        }
        sb.append('\n');

        sb.append("   ");
        for (int i = 0; i < DIM; i++) {
            sb.append("  ");
            sb.append(i);
            sb.append("  ");
        }
        sb.append('\n');

        return sb.toString();
    }

    public static class OutOfBoundsException extends Exception {
    }
}
