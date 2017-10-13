package chess;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    public boolean isRegularMove(Position start, Position end, boolean theresOpponent) {
        return start.isOnHV(end) || end.isOnDiagonal(end);
    }
}
