package com.learning.test.charpter18;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 对文件部分加锁
 */
public class FilePartLock {

    private static class LockAndModify extends Thread{
        private int start;

        private int end;

        private ByteBuffer buff;

        private FileChannel fc;

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
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
