package es4.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by affo on 18/10/17.
 */
public class IntegerStackWException {
    private static final int CAPACITY = 5;
    private final List<Integer> ints = new ArrayList<>(CAPACITY);

    public void push(Integer i) throws FullException {
        if (ints.size() == CAPACITY) {
            throw new FullException();
        }

        ints.add(0, i);
    }

    private void checkEmptiness() throws EmptyException {
        if (ints.isEmpty()) {
            throw new EmptyException();
        }
    }

    public Integer pop() throws EmptyException {
        checkEmptiness();

        return ints.remove(0);
    }

    public Integer peek() throws EmptyException {
        checkEmptiness();

        return ints.get(0);
    }

    /*
    N.B.: Usando delle inner classes per le eccezioni, dichiaro delle eccezioni "locali", i.e.
     che hanno senso e sono contestualizzate nella classe di appartenenza ("outer class"), poiché
     ne possono utilizzare i field interni.
     In un certo qual modo, ne perdo il riuso da parte da parte di altre classi. Certe volte è utile
     definire le eccezioni in modo più generico in modo da favorirne il riutilizzo (vedi package `exceptions`).
     */

    /*
    Una static inner class può essere istanziata a partire dalla
    classe che la contiene ("outer class"):

        IntegerStackWException.EmptyException e = new IntegerStackWException.EmptyException();
    */
    public static class EmptyException extends Exception {
        public EmptyException() {
            super("The stack is empty!");

            // essendo static, non può accedere ai field non statici della outer class:
            // TODO prova a decommentare qui sotto
            //System.out.println(CAPACITY);
            //System.out.println(ints);
        }
    }

    /*
    Una semplice inner class non può essere istanziata se non a partire da
    una istanza della outer class:

        IntegerStackWException.FullException fe = new IntegerStackWException.FullException(); // errore
        IntegerStackWException s = new IntegerStackWException();
        IntegerStackWException.FullException fe = s.new FullException();
    */
    public class FullException extends Exception {
        public FullException() {
            super("The stack is full!");
        }

        public int getCapacity() {
            return CAPACITY;
        }

        public String getElements() {
            // non essendo statica, può accedere ad `ints`
            return ints.toString();
        }
    }
}
