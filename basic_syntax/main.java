class testabs {
    public int sum(int a, int b) {
        return a + b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public void hello() {
        System.out.println("hello I am abstratc class");
    }
}

public class main extends testabs {
    public static void main(String[] args) {
        testabs abs = new testabs();
        ((main) abs).sum(1, 3);
    }

    @Override
    public int sum(int a, int b) {
        System.out.println(a + b);
        return a + b;
    }
}