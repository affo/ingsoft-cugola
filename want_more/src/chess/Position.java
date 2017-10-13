package chess;

public final class Position {
    public final int row, column;

    private Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Position of(int row, int column) {
        return new Position(row, column);
    }

    public boolean isOnDiagonal(Position b) {
        int deltaRow = Math.abs(row - b.row);
        int deltaColumn = Math.abs(column - b.column);
        return deltaRow == deltaColumn;
    }

    public boolean isOnHV(Position b) {
        return row == b.row ||
                column == b.column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (row != position.row) return false;
        return column == position.column;

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }
}
