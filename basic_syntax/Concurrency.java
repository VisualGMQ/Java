import java.util.*;

import javafx.beans.property.SetProperty;

class thread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        Thread.yield();
    }
}

public class Concurrency {
    public static void main(String[] args) {
        Thread t1 = new Thread(new thread());
        Thread t2 = new Thread(new thread());
        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
        }
        t2.start();
        System.out.println("haha");
    }
}