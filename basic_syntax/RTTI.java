import java.util.*;
import java.lang.reflect.*;

class Point {
    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    private int x;
    private int y;
}

public class RTTI {
    public static void main(String[] args) {
        try {
            // Class CPoint = Class.forName("Point");
            // Point p = new Point;
            // p.getClass()
            Class CPoint = Point.class;
            System.out.println(CPoint.getName());
            System.out.println(CPoint.getSimpleName());
            System.out.println(CPoint.getCanonicalName());
            System.out.println(CPoint.isLocalClass());
            System.out.println(CPoint.isInterface());
            Class superclass = CPoint.getSuperclass();
            System.out.println(superclass);
            Point p = (Point) CPoint.newInstance();
            System.out.println(p);
            System.out.println(p instanceof Point);
            Field[] fields = CPoint.getDeclaredFields();
            for (Field f : fields)
                System.out.println(f);

            Constructor[] construct = CPoint.getConstructors();
            Method[] methods = CPoint.getMethods();
            for (Constructor c : construct) {
                System.out.println(c);
            }
            for (Method m : methods) {
                System.out.println(m);
                System.out.println(m.getReturnType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}