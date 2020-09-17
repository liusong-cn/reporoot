package com.learning.test.charpter18;

import java.io.*;

public class BasicFileOut {
    public static void main(String[] args) throws IOException {
//        File file = new File("d://Maven1.txt");
//        //使用缓冲流更有利于效率
//        BufferedReader br = new BufferedReader(new StringReader(BufferedInputFile.read("d://笔记/Maven.txt")));
//        int lineCount = 1;
//        //使用包装模式逐层包装，使用printwriter用于输出格式化的，使用bufferedwriter用于缓冲流的处理
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
//        //目前printwriter可以使用这种简化的方式，省去包装，但是目前的输入任务都没有简化的方式
//        //该简化的方式实现了pw所实现的功能
//        //PrintWriter pw1 = new PrintWriter(file);
//        String s;
//        while ( (s = br.readLine()) != null){
//            pw.println(lineCount++ + ":" + s);
//        }
//        br.close();
//        pw.close();
        useTryWithResource();
    }

    //通过try-with-resource结构保证资源被关闭，资源以打开顺序相反的循序关闭
    //需实现autocloseable或者closeable接口
    public static void useTryWithResource(){
        File file = new File("d://email.java");
        //允许一次打开多个资源，以；分割
        try(BufferedReader br = new BufferedReader(new StringReader(BufferedInputFile.read("D:\\weichat\\WeChat Files\\wxid_7onk6zjief6w22\\FileStorage\\File\\2020-09\\EmailUtil.java")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        ){
            int linecount = 1;
            String s;
            while ((s= br.readLine())!= null){
                pw.println(linecount++ + ":" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
