package example.generics;

import java.util.List;

public class ExtendsSuper {
    public static void addEE(List<? extends Number> lst1,
                             List<? extends Number> lst2) {
        for (Number n : lst1) {
    //        lst2.add(n); //- wrong because lst1 may contain Double and lst2 - Integer
        }
    }

    public static void addSS(List<? super Number> lst1,
                             List<? super Number> lst2) {
        for (Object n : lst1) {
            //  lst2.add(n); //- wrong because lst1 may contain Object and lst2 - Number
        }
    }

    public static void addSE(List<? super Number> lst1,
                             List<? extends Number> lst2) {
        for (Object n : lst1) {
            //  lst2.add(n); //- wrong because lst1 may contain Object and lst2 - Number or Numbers subtypes
        }
    }

    public static void addES(List<? extends Number> lst1,
                             List<? super Number> lst2) {
        for (Number n : lst1) {
      //      lst2.add(n); //- ok because lst1 always contains elements with subtypes or same type of type elements from lst2
        }
    }

    public static void main(String[] args) {

    }
}
