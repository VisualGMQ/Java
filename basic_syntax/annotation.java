import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface UserAnnotation {
    String anName() default "no name";

    int ID() default -1;
}

public class annotation {
    @UserAnnotation(anName = "test", ID = 1)
    private static void saySomething() {
        System.out.println("I want to say something...");
    }

    public static void main(String[] args) {
        saySomething();
        Class c = annotation.class;
        Method[] method = c.getMethods();
        for (Method m : method) {
            if (m.isAnnotationPresent(UserAnnotation.class)) {
                UserAnnotation ann = m.getAnnotation(UserAnnotation.class);
                System.out.println(ann.anName());
                System.out.println(ann.ID());
            }
        }
    }
}