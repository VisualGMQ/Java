import java.io.*;
import java.util.*;

class DirOperator {
    public static void main(String[] args) {
        /*
         * // list all file in this path File path = new File(".");
         * System.out.println("files in this path:"); String[] files = path.list(); for
         * (String str : files) System.out.println(str);
         * 
         * // create new file File newfile; if (args.length >= 1) { newfile = new
         * File("./" + args[0]); if (!newfile.exists()) { try {
         * System.out.println("file " + args[0] + "is created!\n");
         * newfile.createNewFile(); } catch (Exception e) {
         * System.out.println("file create failed"); e.printStackTrace(); } } }
         */
        // showPath();
        // travelDir("../");
    }

    public static void showPath() {
        File path = new File(".");
        String[] list = path.list();
        for (String str : list) {
            final String prefix = "./";
            File file = new File(prefix + str);
            String type;
            if (file.isDirectory())
                type = "Directory";
            else
                type = "File";
            System.out.println(type + ":" + str);
        }
    }

    public static void travelDir(String dir) {
        if (dir != ".")
            dir = dir.substring(0, dir.length() - 1);
        travelPath(dir, "");
    }

    private static void travelPath(final String prefix, final String dir) {
        String nextprefix = prefix + dir + "/";
        File path = new File(nextprefix);
        String[] list = path.list();
        for (String str : list) {
            File file = new File(nextprefix + str);
            if (file.isFile())
                System.out.println(str + " is file");
            else {
                System.out.println("in directory " + str);
                travelPath(nextprefix, str);
            }
        }
    }
};