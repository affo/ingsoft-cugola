package es3.zoo.animals;

/**
 * Created by affo on 13/10/17.
 */
public class Slowner extends Animal {
    private final Animal animal;

    public Slowner(Animal animal) {
        this.animal = animal;
    }

    @Override
    protected String getFootprint() {
        return animal.getFootprint();
    }

    @Override
    protected Speed getSpeed() {
        return animal.getSpeed().previous();
    }
}
