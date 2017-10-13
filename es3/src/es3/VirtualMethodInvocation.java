package es3;

/**
 * Classe creata appositamente per "sporcarsi le mani" con overriding e overloading.
 */
public class VirtualMethodInvocation {
    public static void main(String[] args) {
        // Variabile 'xy' sta per: tipo statico X e tipo dinamico Y.
        A aa = new A();
        A ab = new B();
        A ac = new C();

        B bb = new B();
        B bc = new C();
        B bd = new D();

        C cc = new C();

        D dd = new D();

        // Usate le variabili definite sopra per invocare il metodo `print`
        // su diverse istanze con diversi tipi statici e dinamici.
        ab.print(bb);
        bc.print(cc);
    }
}

/**
 * Divertitevi a fare overriding e overloading con il metodo `print` nella classi
 * A, B, C, D e analizzare come cambiano i risultati dell'esecuzione del metodo `main`.
 */

class A {
    public void print(A a) {
        System.out.println(getClass().getSimpleName() + " - A impl: print(A a)");
    }
}

class B extends A {
    public void print(A a) {
        System.out.println(getClass().getSimpleName() + " - B impl: print(A a)");
    }


    public void print(B b) {
        System.out.println(getClass().getSimpleName() + " - B impl: print(B b)");
    }
}

class C extends B {
    public void print(C c) {
        System.out.println(getClass().getSimpleName() + " - B impl: print(C c)");
    }
}

class D extends B {
    public void print(A a) {
        System.out.println(getClass().getSimpleName() + " - D impl: print(A a)");
    }
}
