package es3.zoo.animals;

/**
 * Created by affo on 12/10/17.
 */
public enum Speed {
    S1, S2, S3, S4, S5, S6, S7, S8, S9, S10;

    public static long MIN_TIME = 500, MAX_TIME = 2000;

    private static double linearConverter(double x) {
        double x1 = 1, x2 = Speed.values().length;
        double y1 = MAX_TIME, y2 = MIN_TIME;
        double m = (y2 - y1) / (x2 - x1);
        double q = (x1 * y2 - x2 * y1) / (x1 - x2);
        // y = mx + q
        return m * x + q;
    }

    public long getMillis() {
        return Math.round(linearConverter(this.ordinal()));
    }

    public Speed next() {
        int i = this.ordinal();

        if (i < Speed.values().length - 1) {
            i++;
        }

        return Speed.values()[i];
    }

    public Speed previous() {
        int i = this.ordinal();

        if (i > 0) {
            i--;
        }

        return Speed.values()[i];
    }
}
