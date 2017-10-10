package es2.shapes;

/**
 * Created by affo on 10/10/17.
 */
public class TestDrive {
    public static void main(String[] args) {
        Square s = new Square(10);
        Circle c = new Circle(5);

        s.draw(new TextualCanvas());
        System.out.println();
        c.draw(new TextualCanvas());
    }
}
