package es3.zoo.animals;

/**
 * Created by affo on 12/10/17.
 */
public class Cat extends Animal {
    @Override
    protected String getFootprint() {
        return "X";
    }

    @Override
    protected Speed getSpeed() {
        return Speed.S5;
    }
}
