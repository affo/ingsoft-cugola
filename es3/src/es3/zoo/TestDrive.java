package es3.zoo;

import es3.zoo.animals.Animal;
import es3.zoo.animals.Dog;

/**
 * Created by affo on 12/10/17.
 */
public class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        // occhio alla visibilità...
        // Posso istanziare uno Stepper da cui?
        // Che metodi posso invocare di Animal?

        Animal animal = new Dog();
        animal.walk();

        Thread.sleep(10000);

        animal.rest();
    }
}
