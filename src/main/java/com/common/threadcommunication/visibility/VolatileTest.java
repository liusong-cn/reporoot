package com.common.threadcommunication.visibility;

/**
 * @author:ls
 * @date: 2020/10/27 10:26
 * 测试使用volatile进行多线程可见性测试
 **/
public class VolatileTest {

    private Integer c = 0;

    public void increase(){
        c++;
//        synchronized (c){
//            c++;
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest v = new VolatileTest();
        for (int i = 0; i < 2; i++) {
            new Thread(() ->{
                    System.out.println(Thread.currentThread().getName() + "before:" + v.c);
                    v.increase();
                    System.out.println(Thread.currentThread().getName() + "after:" + v.c);

            }).start();
        }
//        while (Thread.activeCount()>1){
//            Thread.yield();
//        }
//        v.wait(5000);
        System.out.println(v.c);
    }
}
