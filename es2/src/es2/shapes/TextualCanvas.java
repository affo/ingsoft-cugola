package es2.shapes;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by affo on 10/10/17.
 */
public class TextualCanvas implements Canvas {
    private Set<ScreenCoordinates> points = new HashSet<>();
    private Integer startX = Integer.MAX_VALUE;
    private Integer endY = Integer.MAX_VALUE;
    private Integer startY = Integer.MIN_VALUE;
    private Integer endX = Integer.MIN_VALUE;

    @Override
    public void addPoint(Point p) {
        ScreenCoordinates c = new ScreenCoordinates(p.getX(), p.getY());
        points.add(c);

        if (c.x < startX) {
            startX = c.x;
        }

        if (c.x > endX) {
            endX = c.x;
        }

        if (c.y > startY) {
            startY = c.y;
        }

        if (c.y < endY) {
            endY = c.y;
        }
    }

    @Override
    public void draw() {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y >= endY; y--) {
                ScreenCoordinates coordinates = new ScreenCoordinates(x, y);
                if (points.contains(coordinates)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Converts a point in reals to a point on the console
     */
    private static final class ScreenCoordinates {
        public final int x, y;

        private int convert(double n) {
            return Math.toIntExact(Math.round(n));
        }

        public ScreenCoordinates(double x, double y) {
            this.x = convert(x);
            this.y = convert(y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ScreenCoordinates coordinates = (ScreenCoordinates) o;

            if (x != coordinates.x) return false;
            return y == coordinates.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
