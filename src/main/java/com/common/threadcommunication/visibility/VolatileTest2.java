package com.common.threadcommunication.visibility;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:ls
 * @date: 2020/10/27 19:20
 * 使用countdownlatch(闭锁)来控制线程执行顺序，保证主线程在所有子线程执行完毕后执行
 * 做法：1.主线程维护countdownlatch
 * 2.子线程引用countdownlatch并进行业务操作
 * 3.子线程操作完毕后进行countdownlatch递减
 * 4.子线程启动后在主线程中进行countdownlatch.await()
 * 5.主线程执行业务操作
 **/
public class VolatileTest2 {

    private CountDownLatch latch;

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        VolatileTest2 v = new VolatileTest2();
        v.setLatch(new CountDownLatch(2));
        executorService.execute(new B(v.getLatch(),"b"));
        executorService.execute(new C(v.getLatch(),"c"));
        v.getLatch().await();
        System.out.println(v.getLatch().getCount());

    }
}


class B implements Runnable{

    private CountDownLatch latch;


    private String name;

    public B(CountDownLatch latch, String name) {
        super();
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("b");
        //子线程业务操作后需要进行countdown()操作调整计数器,否则线程一致都在
        latch.countDown();
    }
}

class C implements Runnable{

    private CountDownLatch latch;


    private String name;

    public C(CountDownLatch latch, String name) {
        super();
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("c");
        //子线程业务操作后需要进行countdown()操作调整计数器
        latch.countDown();
    }
}

