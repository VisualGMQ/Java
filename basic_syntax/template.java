import java.util.*;

class tuple<A, B, C> {
    public tuple(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public C getC() {
        return c;
    }

    public String toString() {
        return a + "," + b + "," + c;
    }

    private A a;
    private B b;
    private C c;
}

public class template {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        tuple t = new tuple("value1", 2, false);
        System.out.println(t);
    }
}