package com.learning.test.charpter18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 对文件部分加锁
 */
public class FilePartLock {

    private static final int LENGTH = 0x8FFFFFF;//128M

    private static FileChannel fc;

    public static void main(String[] args) throws IOException {
        fc = new RandomAccessFile("d://test.dat","rw").getChannel();
        MappedByteBuffer mb = fc.map(FileChannel.MapMode.READ_WRITE,0,LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            mb.put((byte)'x');
        }
        //由于在带参构造函数中已经调用了start（），故此处不用显示调用
        new LockAndModify(mb,0,4);
        new LockAndModify(mb,6,9);
    }

    private static class LockAndModify extends Thread{
        private int start;

        private int end;

        private ByteBuffer buff;

        public LockAndModify(ByteBuffer bbf, int start, int end){
            this.start = start;
            this.end = end;
            bbf.limit(end);
            bbf.position(start);
            buff = bbf.slice();
            //使线程就绪
            start();
        }

        @Override
        public void run() {
            try {
                FileLock fl = fc.lock(start, end, false);
                System.out.println("start lock: start " + start + " end " + end );
                while (buff.position() < buff.limit() - 1){
                    buff.put((byte)(buff.get() + 1));
                }
                //手动释放锁
                fl.release();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
