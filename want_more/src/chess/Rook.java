package chess;

/**
 * Created by affo on 23/03/17.
 */
public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    public boolean isRegularMove(Position start, Position end, boolean theresOpponent) {
        return start.isOnHV(end);
    }
}
