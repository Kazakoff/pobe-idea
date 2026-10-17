package example.generics.covariation;

import java.util.ArrayList;
import java.util.List;

class A {
    void prn() {
        System.out.println("A");
    }
}

class B extends A {
    void prn() {
        System.out.println("B");
    }
}

class C extends B {
    void prn() {
        System.out.println("C");
    }
}

class D extends B {
    void prn() {
        System.out.println("D");
    }
}

public class Main {
    static void addTest(List<? extends B> list) {
        //     list.add(new B()); // error
        helper(list);
        System.out.println(list.get(0).getClass().getName());
        list.get(0).prn();
    }

    static <T extends B> void helper(List<T> l) {
        l.add(((T) new C()));
    }

    public static void main(String... args) {
        List<A> la = new ArrayList<>();
        List<B> lb = new ArrayList<>();
        List<C> lc = new ArrayList<>();
//        addTest(la); // error: A is not extends B
        addTest(lb);
        addTest(lc);

        class NaturalNumber {
            private int i;

            public NaturalNumber(int i) {
                this.i = i;
            }
        }

        class EvenNumber extends NaturalNumber {
            public EvenNumber(int i) {
                super(i);
            }
        }

        List<EvenNumber> le = new ArrayList<>();
        List<? extends NaturalNumber> ln = le;
        //      ln.add(new NaturalNumber(35));  // compile-time error
/*
Because List<EvenNumber> is a subtype of List<? extends NaturalNumber>,
you can assign le to ln. But you cannot use ln to add a natural number to a list
of even numbers.
 */
        ln.add(null);
    }
}
