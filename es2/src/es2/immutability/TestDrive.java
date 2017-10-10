package es2.immutability;

/**
 * Created by affo on 10/10/17.
 */
public class TestDrive {
    public static void main(String[] args) {
        Person person = new Person("Gianni");
        IdCard idCard = new IdCard(person);
        System.out.println(idCard);
        person.setName("Pinotto");
        System.out.println(idCard); // nessun cambiamento
        idCard.getOwner().setName("Daaaaiiii");
        System.out.println(idCard); // nessun cambiamento
    }
}
