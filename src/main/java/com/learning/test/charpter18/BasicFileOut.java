package com.learning.test.charpter18;

import java.io.*;

public class BasicFileOut {
    public static void main(String[] args) throws IOException {
        File file = new File("d://Maven1.txt");
        //使用缓冲流更有利于效率
        BufferedReader br = new BufferedReader(new StringReader(BufferedInputFile.read("d://笔记/Maven.txt")));
        int lineCount = 1;
        //使用包装模式逐层包装，使用printwriter用于输出格式化的，使用bufferedwriter用于缓冲流的处理
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        //目前printwriter可以使用这种简化的方式，省去包装，但是目前的输入任务都没有简化的方式
        //该简化的方式实现了pw所实现的功能
        //PrintWriter pw1 = new PrintWriter(file);
        String s;
        while ( (s = br.readLine()) != null){
            pw.println(lineCount++ + ":" + s);
        }
        br.close();
        pw.close();
    }
}
