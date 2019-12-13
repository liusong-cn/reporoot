package com.learning.test.charpter18;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {

    private static void symmetricScramble(CharBuffer charBuffer){
        while (charBuffer.hasRemaining()){
            charBuffer.mark();
            //交换相邻字符的顺序
            char a = charBuffer.get();
            char b = charBuffer.get();
            //将charbuffer的mark标记恢复刚才mark（）时的状态
            charBuffer.reset();
            charBuffer.put(b).put(a);
        }
    }

    public static void main(String[] args) {
        char[] charArray = "usingchararray".toCharArray();
        ByteBuffer buffer = ByteBuffer.allocate(charArray.length*2);
        CharBuffer charbuffer = buffer.asCharBuffer();
        charbuffer.put(charArray);
        System.out.println(charbuffer.rewind());
        symmetricScramble(charbuffer);
        System.out.println(charbuffer.rewind());
        symmetricScramble(charbuffer);
        System.out.println(charbuffer.rewind());
    }
}
