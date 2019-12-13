package com.learning.test.charpter18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过使用内存映射文件可以将整个文件仿佛放在了内存中直接读取
 */
public class UsingMappingByteBuffer {
    public static void main(String[] args) throws IOException {
        int length = 0x8FFFFFF;
        MappedByteBuffer mbf = new RandomAccessFile("d://testMappedByteBuffer.dat","rw").getChannel().map(FileChannel.MapMode.READ_WRITE,0,length);
        //实际测试发现存储数据时间在3s内
        for (int i = 0; i < length; i++)
            mbf.put((byte)'x');
        for (int i = length/2; i < length/2 + 6; i++)
            System.out.println((char)mbf.get(i));

    }
}

