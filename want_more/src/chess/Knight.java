package chess;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    public boolean isRegularMove(Position start, Position end, boolean theresOpponent) {
        if (end.row == start.row + 2 ||
                end.row == start.row - 2) {
            return end.column == start.column + 1 ||
                    end.column == start.column - 1;
        }

        return (end.column == start.column + 2 || end.column == start.column - 2)
                && (end.row == start.row + 1 || end.row == start.row - 1);

    }
}
