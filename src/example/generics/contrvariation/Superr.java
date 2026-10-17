package example.generics.contrvariation;

import java.util.List;

import static java.util.Arrays.asList;

public class Superr {
    //super - ограничение маски типа "снизу"
    public static void prn(List<? super Integer> lst) {
        //здесь метод println выдаёт имя класса, которым параметризуется List
        lst.forEach(n -> System.out.println(n.getClass().getName()));
        //распечатка значений из списка
        lst.forEach(n -> System.out.println(n));
    }

    public static void main(String[] args) {
        List<Integer> ints = asList(1, 2);
        List<Number> nums = asList(1f, 2f);
        List<Object> obj = asList("dfhrtyh", "rtnjtey");
        List<String> str = asList("1", "2");
        prn(ints);
        prn(nums);
        prn(obj);
        //список str нельзя использовать в методе prn, т. к. String не яляется предком Integer
        //    prn(str);
    }
}
