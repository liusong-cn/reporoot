package com.learning.test.charpter18;

import java.io.*;

public class BufferedInputFile {
    public static String read(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        //由于默认的filereader没有自定义charset的构造器，故此使用基于inputstreamreader
        BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"gbk"));
        StringBuffer sb = new StringBuffer();
        String s ;
        while ((s = br1.readLine() )!= null){
            sb.append(s + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print(BufferedInputFile.read("d://笔记/Maven.txt"));
    }
}
