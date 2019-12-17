package com.learning.test.charpter18;

import java.io.*;
import java.util.zip.*;

public class DeflaterTest {

    public static void main(String[] args) throws IOException {
        //useGzip();
        useZip();
    }

    public static void useGzip() throws IOException{
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d://testDeflater.txt"));
        // \n换行符可能在不同的平台上不一致
        for (int i = 0; i < 100; i++) {
            bos.write("today is a good day \n".getBytes());
        }
        bos.close();
        //reader同时实现了readable和cloneable接口，可以同时具有字符和字节的读取方式
        BufferedReader br = new BufferedReader(new FileReader("d://testDeflater.txt"));
        //适配器模式和装饰器模式的结合，适配器体现在fileoutstream中，将file字符类型的适配为outputstream当成字节流来使用
        //在jdk类库中有很多适配器模式的体现，命名规则：adaptee + adapter，例如 file + outputstream
        //gzip和zip是jdk自带的文件压缩方式
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("d://test.gz")));
        int c;
        while ( (c = br.read()) != -1)
            out.write(c);
        br.close();
        out.close();
        //此处的inputstreamreader同样使用了适配器模式，inputstream + reader，将字节流当成字符流使用
        BufferedReader bur = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("d://test.gz"))));
        String s;
        while ((s = bur.readLine()) != null)
            System.out.println(s);
    }

    public static void useZip() throws IOException{
        FileOutputStream fos = new FileOutputStream("d://学习使用的测试文件/test.zip");
        //检查算法有两种，adler32和crc32，前者速度快，后者更准确
        CheckedOutputStream cos = new CheckedOutputStream(fos,new Adler32());
        ZipOutputStream zos = new ZipOutputStream(cos);
        BufferedOutputStream bos = new BufferedOutputStream(zos);
        zos.setComment("use zip to deflater");
        for (int i = 0; i < 5; i++) {
            zos.putNextEntry(new ZipEntry("ceshi" + i + ".txt"));
            bos.write("测试打包文件".getBytes());
            //在文件打包过程中，一定要推送缓存，否则文件没有内容
            bos.flush();
        }
        bos.close();
    }
}
