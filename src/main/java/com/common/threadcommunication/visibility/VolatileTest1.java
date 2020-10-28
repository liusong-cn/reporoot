package com.common.threadcommunication.visibility;

/**
 * @author:ls
 * @date: 2020/10/27 19:03
 **/
public class VolatileTest1 {
    public int i = 0;

    public static void main(String[] args) throws InterruptedException {
        VolatileTest1 v = new VolatileTest1();
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            v.i++;
            System.out.println("t1" + v.i);
        });
        t1.start();
        //o.join(),使得其他线程等待o的死亡再执行
        t1.join();
        Thread t2 = new Thread(()->{
            v.i++;
            System.out.println("t2" + v.i);
        });
        t2.start();
        t2.join();
        //由于使用了join()，使得main等待两个子线程执行完毕后再运行，因此结果可能为2，也可能为1，因为每个子线程中的操作并非原子操作
        //目前未测试出结果为1的情况
        System.out.println(v.i);



    }
}
