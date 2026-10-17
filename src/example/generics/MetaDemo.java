package example.generics;

class Stats<T> {
    T nums;
    Stats(T o) {
        nums = o;
    }
    T getNums() {
        return nums;
    }
}

class SameAvg {
    public <T1 extends Number, T2 extends Number> double avg(Stats<T1> n, Stats<T2> m) { //ћетод avg возвращает среднее из двух получаемых аргументов.
        double sr;                                                            //ѕри этом с помощью маски с ограничением <? extends Number> провер¤етс¤, ¤вл¤ютс¤ ли аргументы метода числами
        sr = (n.getNums().doubleValue() + m.getNums().doubleValue()) / 2;
        return sr;
    }  // ≈сли в программе будет попытка передать в метод avg переменную типа,
}      // отличного от числового (new Stats<String>(snums)), мы получим ошибку уже на этапе компил¤ции, а не во врем¤ выполнени¤.

public class MetaDemo {
    public static void main(String args[]) {
        Number n1 = new Integer(1);
        System.out.println(n1 instanceof Integer);
        System.out.println(n1 instanceof Number);
        Double d = new Double(1);
        System.out.println(d instanceof Double);
    }
}
