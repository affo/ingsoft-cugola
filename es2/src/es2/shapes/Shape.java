package es2.shapes;

import java.util.Set;

/**
 * Created by affo on 10/10/17.
 */
public abstract class Shape {
    public abstract double getSurface();

    public abstract double getPerimeter();

    public abstract Set<Point> getPoints();

    public void draw(Canvas canvas) {
        for (Point p : getPoints()) {
            canvas.addPoint(p);
        }
        canvas.draw();
    }
}
