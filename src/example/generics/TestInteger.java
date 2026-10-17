package example.generics;

import java.util.ArrayList;
import java.util.List;

public class TestInteger {
    static Number[] arr = new Integer[5];
    static Integer[] iArr = new Integer[5];
    public static void addValue(Integer[] ln) {
        ln[0] = new Integer(1);
    }

    public static void main(String []args) {
        List<Number> ln = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        addValue((Integer[]) arr);
        addValue(iArr);
    }
}
