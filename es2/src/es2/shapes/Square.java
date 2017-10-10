package es2.shapes;

import sun.security.provider.SHA;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by affo on 10/10/17.
 */
public class Square extends Shape {
    private double base;

    public Square(double base) {
        this.base = base;
    }

    @Override
    public double getSurface() {
        return base * base;
    }

    @Override
    public double getPerimeter() {
        return 4 * base;
    }

    @Override
    public Set<Point> getPoints() {
        Set<Point> points = new HashSet<>();

        final double leftX = -base / 2;
        final double rightX = -leftX;
        final double upY = base / 2;
        final double downY = -upY;

        for (double step = downY; step <= upY; step += base / 5) {
            points.add(new Point(leftX, step));
            points.add(new Point(rightX, step));
        }

        for (double step = leftX; step <= rightX; step += base / 5) {
            points.add(new Point(step, upY));
            points.add(new Point(step, downY));
        }

        return points;
    }
}
