package chess;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    public boolean isRegularMove(Position start, Position end, boolean theresOpponent) {
        int deltaRow = Math.abs(start.row - end.row);
        int deltaColumn = Math.abs(start.column - end.column);
        return deltaRow <= 1 && deltaColumn <= 1;
    }
}
