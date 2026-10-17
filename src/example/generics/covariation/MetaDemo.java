package example.generics.covariation;

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
    public double avg(Stats<? extends Number> n, Stats<? extends Number> m) {
        double sr;
        sr = (n.getNums().doubleValue() + m.getNums().doubleValue())/2;
        return sr;
    }
}

public class MetaDemo {
    public static void main(String args[]) {
        Integer inums  = 3;
        Double dnums = 1.2;
        Float fnums = 2.5F;
        // String snums = "1";
        SameAvg s = new SameAvg();
        System.out.println(s.avg(new Stats<>(inums),new Stats<>(dnums)));
        System.out.println(s.avg(new Stats<>(fnums), new Stats<>(inums)));
        System.out.println(s.avg(new Stats<>(fnums), new Stats<>(dnums)));
        // System.out.println(s.avg(new Stats<>(fnums), new Stats<>(snums)));
    }

}

