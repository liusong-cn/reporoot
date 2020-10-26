package com.learning.test.general;

/**
 * @author:ls
 * @date: 2020/10/26 13:55
 * 用于测试线之间不共享变量的情况，若想共享，一般通过设置public static实现
 **/
public class ThreadLocalTest {

    public static void main(String[] args) {
        MyRunnable runnable1 = new MyRunnable();
        Thread t1 = new Thread(runnable1);
        t1.start();
        //使用lambda表达式实现runnable接口
//        Thread t2 = new Thread(()->{
//            ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//            for (int i = 0; i < 4; i++) {
//                threadLocal.set(i);
//                System.out.println("线程2:" + threadLocal.get());
//            }
//        });
//        t2.start();
        Thread t3 = new Thread(runnable1);
        t3.start();

    }


}
class MyRunnable implements Runnable{

    //用于存储线程间不共享的变量,常规使用static表示跟类绑定，但是threadlocal会跟线程绑定
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            threadLocal.set(i);
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        }
    }
}
