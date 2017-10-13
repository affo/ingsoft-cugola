package es3.zoo.animals;

/**
 * Created by affo on 12/10/17.
 */
public class Dog extends Animal {
    @Override
    protected String getFootprint() {
        return "O";
    }

    @Override
    protected Speed getSpeed() {
        return Speed.S2;
    }
}
