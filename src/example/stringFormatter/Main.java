package example.stringFormatter;

import java.util.Locale;

public class Main {
    public static void main(String...args) {
        System.out.printf("e = %+10.4f%n", Math.E);
        System.out.printf(Locale.ENGLISH, "e = %+10.4f", Math.E);
    }
}
