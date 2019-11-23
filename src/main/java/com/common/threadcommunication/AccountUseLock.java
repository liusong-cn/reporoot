package com.common.threadcommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AccountUseLock {
    private static final ReentrantLock lock = new ReentrantLock();

    //使用condition来控制线程之间的通信
    private final Condition condition = lock.newCondition();

    private String no;

    private int balance;
    //是否已有存款
    private boolean flag;

    public int getBalance() {
        return balance;
    }

    public AccountUseLock(String no, int balance) {
        this.no = no;
        this.balance = balance;
    }

    public void deposite(int money){
        lock.lock();
        try {
            if(flag){
                //由于没有使用synchronized来修饰，故此处没有隐式的同步监视器对象，传统的通信方法wait，notify无法使用
                //使用condition来代替同步监视器的功能
                condition.await();
            }else{
                balance += money;
                flag = true;
                condition.signalAll();
                System.out.println("存款成功,余额是" + balance );
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void draw(int money){
        lock.lock();
        try {
            if (flag){
                balance -= money;
                flag = false;
                System.out.println("取钱成功，余额是" + balance);
                condition.signalAll();
            }else{
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
