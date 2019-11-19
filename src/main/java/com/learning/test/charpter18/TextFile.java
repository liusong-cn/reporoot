package com.learning.test.charpter18;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;

public class TextFile extends ArrayList<String> {

    /**
     *
     * @param fileName
     * @return 返回文件内容
     */
    public static String read(String fileName) {
        String s;
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                while ((s = br.readLine()) != null) {
                    sb.append(s + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                br.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     *
     * @param fileName
     * @param charsetName
     * @return 通过重载字符集的方式返回文件内容
     */
    public static String read(String fileName,String charsetName){
        String s;
        StringBuilder sb = new StringBuilder();
        try {
            if ("".equals(charsetName) || charsetName == null) charsetName = "gbk";
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),charsetName));
            try {
                while((s = br.readLine()) != null){
                    sb.append(s + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                br.close();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
