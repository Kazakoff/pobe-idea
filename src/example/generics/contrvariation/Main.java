package example.generics.contrvariation;

import java.util.ArrayList;
import java.util.List;

class A { void prn() {System.out.println("A");} }
class B extends A { void prn() {System.out.println("B");} }
class C extends B { void prn() {System.out.println("C");} }
class D extends C { void prn() {System.out.println("D");} }

public class Main {
    static void addTest(List<? super B> list) {
        list.add(new B());
        list.add(new C());
     //   list.add(new A()); //B - верхний тип, поэтому объекты выше него по типу в список добавлять нельзя.
        list.add(new D());
        ((A) list.get(0)).prn();
        ((B) list.get(1)).prn();
//      ((C) list.get(0)).prn(); //error: C is not super B
        ((C) list.get(1)).prn();
    }

    public static void main(String...args) {
        List<A> la = new ArrayList<>();
        List<B> lb = new ArrayList<>();
        List<C> lc = new ArrayList<>();
        List<D> ld = new ArrayList<>();
        List<Object> lo = new ArrayList<>();
        addTest(lo);
        addTest(la);
        addTest(lb);
    //    addTest(lc);// eror: C is not super type of B
    }
}
