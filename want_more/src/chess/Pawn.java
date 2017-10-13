package chess;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    public boolean isRegularMove(Position start, Position end, boolean theresOpponent) {
        int sign = getColor() == Color.WHITE ? 1 : -1;
        int startingRow = getColor() == Color.WHITE ? 1 : Board.DIM - 2;
        int deltaRow = Math.abs(start.row - end.row);
        int deltaColumn = Math.abs(start.column - end.column);

        if (theresOpponent) {
            // can follow diagonal
            return sign * (end.row - start.row) > 0
                    && deltaRow == 1 && deltaColumn == 1;
        }

        boolean res = end.row == start.row + sign;
        if (start.row == startingRow) {
            res = res || end.row == start.row + 2 * sign;
        }

        return res;
    }
}
