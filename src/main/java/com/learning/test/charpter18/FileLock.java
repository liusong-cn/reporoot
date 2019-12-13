package com.learning.test.charpter18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileLock {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("d://testMappedByteBuffer.dat");
        //trylock 和lock的区别在于前者是非阻塞式后者是阻塞式
        java.nio.channels.FileLock lock = fos.getChannel().tryLock();
        if (lock != null){
            System.out.println("获得了文件锁");
        }
        //释放锁
        lock.release();
        fos.close();
    }
}
