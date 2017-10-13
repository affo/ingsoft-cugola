package chess;

/**
 * Created by affo on 23/03/17.
 */
public class Main {
    public static void main(String[] args) throws Board.OutOfBoundsException {
        Board board = new Board();

        for (int i = 0; i < Board.DIM; i++) {
            board.add(Position.of(1, i), new Pawn(Color.WHITE));
            board.add(Position.of(Board.DIM - 2, i), new Pawn(Color.BLACK));
        }

        board.add(Position.of(0, 0), new Rook(Color.WHITE));
        board.add(Position.of(0, 1), new Knight(Color.WHITE));
        board.add(Position.of(0, 2), new Bishop(Color.WHITE));
        board.add(Position.of(0, 3), new Queen(Color.WHITE));
        board.add(Position.of(0, 4), new King(Color.WHITE));
        board.add(Position.of(0, 5), new Bishop(Color.WHITE));
        board.add(Position.of(0, 6), new Knight(Color.WHITE));
        board.add(Position.of(0, 7), new Rook(Color.WHITE));

        board.add(Position.of(7, 0), new Rook(Color.BLACK));
        board.add(Position.of(7, 1), new Knight(Color.BLACK));
        board.add(Position.of(7, 2), new Bishop(Color.BLACK));
        board.add(Position.of(7, 3), new Queen(Color.BLACK));
        board.add(Position.of(7, 4), new King(Color.BLACK));
        board.add(Position.of(7, 5), new Bishop(Color.BLACK));
        board.add(Position.of(7, 6), new Knight(Color.BLACK));
        board.add(Position.of(7, 7), new Rook(Color.BLACK));

        System.out.println(board);
        board.move(Position.of(0, 0), Position.of(0, 4));
        System.out.println(board);
        board.move(Position.of(0, 6), Position.of(2, 5));
        System.out.println(board);
        board.move(Position.of(1, 6), Position.of(3, 6));
        System.out.println(board);
        board.move(Position.of(0, 5), Position.of(2, 7));
        System.out.println(board);

        board.move(Position.of(6, 7), Position.of(4, 7));
        System.out.println(board);
        board.move(Position.of(4, 7), Position.of(3, 6));
        System.out.println(board);
        board.move(Position.of(7, 7), Position.of(2, 7));
        System.out.println(board);
    }
}
