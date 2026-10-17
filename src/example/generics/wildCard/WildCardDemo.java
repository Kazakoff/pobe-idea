/*
The unbounded wildcard type is specified using the wildcard character (?),
for example, List<?>. This is called a list of unknown type.
There are two scenarios where an unbounded wildcard is a useful approach:
- If you are writing a method that can be implemented using functionality provided
 in the Object class.
- When the code is using methods in the generic class that don't depend on the
type parameter. For example, List.size or List.clear. In fact, Class<?> is so
often used because most of the methods in Class<T> do not depend on T.
 */
package example.generics.wildCard;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class WildCardDemo {
    public static void printList(List<?> list) {
        list.forEach(System.out::println);
    }

    public static void main(String...args) {
        List<Integer> li = asList(1, 2, 3);
        List<String>  ls = asList("one", "two", "three");
        printList(li);
        printList(ls);
        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>
    }
}
