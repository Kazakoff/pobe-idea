package example.enums;

import java.lang.reflect.Field;

public class Main {

    enum E0 { A, B }
    enum E1 { A, B }

    static class ETest {
        private E0 fld = E0.A;
    }

    public static void main(String[] args) {
        try {
            ETest test = new ETest();
            Field f = test.getClass().getDeclaredField("fld");
            boolean is = f.getType().isAssignableFrom(E1.class);
            System.out.println(is);
            if (is) {
                f.setAccessible(true);
                f.set(test, E1.A);  // IllegalArgumentException
            }
            // production code should handle these exceptions more gracefully
        } catch (NoSuchFieldException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        }
    }
}
