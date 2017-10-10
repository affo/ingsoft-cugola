package es2.immutability;

/**
 * Created by affo on 10/10/17.
 * <p>
 * 1 - field private e final
 * 2 - classe final
 * 3 - copiare le referenze passate da costruttore
 * 4 - no setter
 * 5 - mai ritornare referenze ai field interni, ma loro copie
 */
public final class IdCard {
    private final Person owner;
    // altri field...

    public IdCard(Person owner) {
        /* Se faccio così:

        this.owner = owner;

        allora chi mi passa owner, potrebbe poi cambiarlo!
        Allora lo copio:
        */
        this.owner = new Person(owner.getName());
    }

    public Person getOwner() {
        /* Se faccio così:

        return owner;

        allora il chiamante potrebbe usare la referenza per cambiare la persona.
        Allora la copio:
        */
        return new Person(this.owner.getName());
    }

    @Override
    public String toString() {
        return owner.toString();
    }
}
