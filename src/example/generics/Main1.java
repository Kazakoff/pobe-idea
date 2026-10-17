package example.generics;

import java.util.Collection;
import java.util.ArrayList;

interface Sink1<T extends Number> {
    default Number flush(T t) {
        return t.doubleValue();
    }
}

public class Main1 {
    public static <T> T writeAll(Collection<T> coll,
                                 Sink1<? super T> snk) {
        T last = null;
        for (T t : coll) {
            last = t;
            snk.flush(last);
        }
        return last;
    }

    public static void main(String[] args) {
        Sink1<Number> s = new Sink1<Number>() {};
        @SuppressWarnings("serial")
        Collection<Integer> cs = new ArrayList<Integer>() {{
            add(new Integer(1));
            add(new Integer(2));
            add(new Integer(3));
            add(new Integer(4));
        }};
        Number b = writeAll(cs, s);
        System.out.println(b); // доступны все методы класса Number
        Integer n = writeAll(cs, s);
        System.out.println(n); // доступны все методы класса Number!
        @SuppressWarnings("serial")
        Collection<Number> cd = new ArrayList<Number>() {{
            add(new Double(1));
            add(new Double(2));
            add(new Double(3));
            add(new Double(4));
        }};
        Number m = writeAll(cd, s);
        System.out.println(m.getClass().getName()); // доступны все методы класса Number!
        //Double d = writeAll(cd, s); //не сработает, т. к. метод writeAll должен возвратить T,
        //а Т в д. с. - это Number (Collection<Number>), его нельзя привести к Double.
    }
}
