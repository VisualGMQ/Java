
public class testClass {
    static enum ENUM {
        ITEM1, ITEM2, ITEM3
    }

    void test() {
        int a = 0;
        a++;
    }

    public static void main(String[] args) {
        int a = 2;
        System.out.println("a:" + a);
        int result = sum(1, 2, 3, 4, 5);
        System.out.println("result:" + result);
        ENUM e = ENUM.ITEM1;
        int[] arr;
        arr = new int[] { 1, 2, 3 };
        ENUM.values();
        System.out.println(e);
        char c = (char) a;
        System.out.println(c);
    }

    public static int sum(int... list) {
        int sum = 0;
        for (int i : list)
            sum += i;
        return sum;
    }
}