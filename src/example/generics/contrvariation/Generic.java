package example.generics.contrvariation;

import java.util.*;

public class Generic {
     public static void addStrings(List<? super String> list) {
        list.add("foo");
        list.add("bar");
    }

    public static void main(String ...args) {
        List<Object> l = new ArrayList<Object>() {{
            add(new Integer(2));
            add("PHP");
            add("PHH");
        }};
        addStrings(l);
        l.forEach(System.out::println);
    }
}