package example.generics;

abstract class A { }
class B extends A { }
class D<T> { void add(T a) {} }
class C<T> extends D<T> { void add(T a) {} }

public class InheritanceSubtype {
    static void addTest(D<A> da) { da.add(new B()); } // B - is A

    public static void main(String... args) {
        D<A> da = new D<>();
        addTest(da);
        C<A> ca = new C<>();
        addTest(ca); // C<A> is D<A>
    }
}
