package es1;

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        c1.increment();
        c2.increment();
        System.out.println(c1.getCount());
        System.out.println(c2.getCount());

        System.out.println(Counter.MAX);

        System.out.println(c1 == c2);

        c2.increment();
        System.out.println(c1.getCount());
        System.out.println(c2.getCount());

        c1.increment();
        System.out.println(c2.getCount());
        System.out.println(c1 == c2);

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        /*
         * Creare un array di contatori il cui metodo
         * getCount() ritorni la loro posizione all'interno
         * dell'array stesso
         */
        Counter[] counters = new Counter[10];
        for (int i = 0; i < counters.length; i++) {
            counters[i] = new Counter(i);
        }

        for (Counter c : counters) {
            System.out.println(c.getCount());
        }

         /*
         * "La conta dei contatori"
         * Fare in modo che la classe Counter ci possa
         * dire quanti Counter sono stati creati
         */
        new Counter();
        new Counter();
        System.out.println(Counter.getConta());


        /**
         * Un esempio di array con inizializzazione
         */
        String[] strings = {"foo", "bar", "buz"};

        for (int i = 0; i < strings.length; i++) {
            strings[i] = "lol";
        }

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
