package es1;

public class ReferenceCopyAssignment {
    public static void foo(String s) {
        s = "lol";
    }

    public static void main(String[] pippo) {
        String s = "miao";
        foo(s);
        System.out.println(s); // perché stampa "miao"?
    }
}
