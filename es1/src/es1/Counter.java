package es1;

public class Counter {
    private int count;
    public static int MAX = 10;
    public static int MIN = 0;
    private static int contaContatori = 0;

    public Counter() {
        this(1);
    }

    public Counter(int count) {
        contaContatori++;

        if (count > MAX) {
            count = MAX;
        }

        if (count < MIN) {
            count = MIN;
        }

        this.count = count;
    }

    public void increment() {
        if (count < MAX) {
            count++;
        }
    }

    public void decrement() {
        if (count > MIN) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }

    public static int getConta() {
        return contaContatori;
    }
}
