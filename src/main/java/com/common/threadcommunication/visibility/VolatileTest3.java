package com.common.threadcommunication.visibility;

import static java.lang.Thread.currentThread;

/**
 * @author:ls
 * @date: 2020/10/27 10:50
 * 使用volatile测试并发编程的可见性，以及原子性
 **/
public class VolatileTest3 {

    //通过volatile保证线程可见性
    public volatile int inc = 0;

    public void increase() {
        //由于++不是原子操作，因此无法保证多线程情形下的正确性
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest3 test = new VolatileTest3();
        for(int i=0;i<1000;i++){
            new Thread1("" + i,test).start();
        }
        //实际测试时发现activecount一般大于1，除了main线程，还有ctrl控制线程
        while(Thread.activeCount()>2) { //保证前面的线程都执行完
            Thread.yield();
            //获取当前线程组内的线程，由于线程组在一颗线程组树上，因此实际线程会更多
//            Thread.sleep(5000);
//            ThreadGroup group = Thread.currentThread().getThreadGroup();
//            Thread[] threads = new Thread[Thread.activeCount()];
//            int size = group.enumerate(threads);
//            System.out.println("查看系统线程组");
//            for (Thread thread : threads) {
//                System.out.println(thread.getName());
//            }

        }
        //多次测试时发现test.inc的结果不一定是1000，这就是因为volatile只能保证原子操作的多线程可见性，而非原子操作依然有可能
        //导致多线程不正确性，需要正确性，可通过synchronize或者lock等加锁方式实现
        System.out.println(test.inc);
    }

}

class Thread1 extends Thread{

    private VolatileTest3 test;

    public Thread1(String name,VolatileTest3 test) {
        super(name);
        this.test = test;
    }

    @Override
    public void run() {
        test.increase();
        System.out.println(super.getName() + ":111" );
    }
}
