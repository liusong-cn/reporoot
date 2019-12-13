package com.learning.test.charpter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 用于测试标准输入输出流
 */
public class OSExecute {
    public static void command(String command){
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split("")).start();
            //将cmd的输入流接入bufferedReader,这里使用了适配器模式对inputstream进行适配，使其能够被bufferedReader使用
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = in.readLine()) != null){
                System.out.println(s);
            }
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = error.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (err)
            throw new RuntimeException("命令错误：" + command);

    }
}
