package chess;

public abstract class Piece {
    private final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean isRegularMove(Position start, Position end, boolean theresOpponent);

    @Override
    public String toString() {
        return getClass().getSimpleName().charAt(0) + "[" + color.name().charAt(0) + "]";
    }
}
