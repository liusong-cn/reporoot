package com.learning.test.charpter18;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        //此处相对路径错误
       // StringReader sr = new StringReader(BufferedInputFile.read("DirFil.java"));
        //改为一段固定的字符
        StringReader sr1 = new StringReader("hello world");
        int c;
        while ((c = sr1.read() )!= -1){
           // System.out.print(c);
            //此处应该不会丢失精度
            System.out.print((char)c);
        }
    }
}
