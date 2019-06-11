import java.io.*;
import java.lang.annotation.*;
import java.util.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface UserAnnotation {

}

class annotation {

    private static void saySomething() {
        System.out.println("I want to say something...");
    }

    public static void main(String[] args) {
        saySomething();
    }
}