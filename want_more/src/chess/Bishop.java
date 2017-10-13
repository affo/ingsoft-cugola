package chess;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    public boolean isRegularMove(Position start, Position end, boolean theresOpponent) {
        return start.isOnDiagonal(end);
    }
}
