package com.common.threadcommunication;

public class DepositeUseLock extends Thread {
    private AccountUseLock a;

    private int money;

    private String name;

    public DepositeUseLock(String name, AccountUseLock a, int money) {
        super(name);
        this.a = a;
        this.money = money;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            a.deposite(money);
        }
    }
}
