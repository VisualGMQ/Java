import java.io.*;
import java.util.*;

class IOOperator {
    public static void main(String[] args) {
        // readWriteFile();
        // readChar();
    }

    private static void readChar() {
        System.out.println("please iput a character");
        InputStreamReader reader = new InputStreamReader(System.in);
        try {
            char c = (char) reader.read();
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readWriteFile() {
        File file = new File("./test.txt");
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }

        try {
            FileWriter is = new FileWriter(file);
            is.write("this is s string\nWrittened By VisualGMQ");
            is.close();
            FileReader os = new FileReader(file);
            char[] text = new char[100];
            os.read(text);
            String context = new String(text);
            System.out.println(context);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
};