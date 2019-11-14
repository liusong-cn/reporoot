package com.learning.test.charpter18;

import java.io.File;

public class FileList {
    public static void main(String[] args) {
        File path = new File("d://29");
        for (String p : path.list()) {
            System.out.println(p);
        }
        System.out.println("_______________");
        for (String p1:path.list(new DirFil(".")) ) {
            System.out.println(p1);
        }
    }
}
