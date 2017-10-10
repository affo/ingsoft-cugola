package es2.shapes;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by affo on 10/10/17.
 */
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSurface() {
        return Math.PI * this.radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Set<Point> getPoints() {
        Set<Point> result = new HashSet<>();

        for (double degrees = 0; degrees < 360; degrees += 15) {
            double x = Math.cos(degrees) * radius;
            double y = Math.sin(degrees) * radius;
            result.add(new Point(x, y));
        }

        return result;
    }
}
