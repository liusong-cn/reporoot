package com.learning.test.charpter18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *  通道channel的基本使用
 */
public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        try {
            FileChannel fc = new FileInputStream("D:\\text.txt").getChannel();
            fc.write(ByteBuffer.wrap("some text".getBytes()));
            fc.close();
            fc = new RandomAccessFile("D:\\text.txt","rw").getChannel();
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("extra txt".getBytes()));
            fc.close();
            fc = new FileInputStream("D:\\text.txt").getChannel();
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);
            fc.read(buff);
            //缓冲器做好准备被读取
            buff.flip();
            while (buff.hasRemaining())
                System.out.print((byte)buff.get());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
