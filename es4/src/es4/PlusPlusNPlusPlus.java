package es4;

/**
 * Created by affo on 18/10/17.
 *
 * Spiegazione della differenza tra i++ e ++i
 */
public class PlusPlusNPlusPlus {
    private static int i = 0;

    private static int iPlusPlus() {
        return i++;
    }

    private static int plusPlusI() {
        return ++i;
    }

    public static void main(String[] args) {
        System.out.println("\ti++");
        System.out.println("Prima:\t\t" + i);
        System.out.println("Durante:\t" + iPlusPlus());
        System.out.println("Dopo:\t\t" + i);

        i = 0;

        System.out.println("\n\t++i");
        System.out.println("Prima:\t\t" + i);
        System.out.println("Durante:\t" + plusPlusI());
        System.out.println("Dopo:\t\t" + i);
    }
}
