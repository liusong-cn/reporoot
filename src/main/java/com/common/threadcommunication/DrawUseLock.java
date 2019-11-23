package com.common.threadcommunication;

public class DrawUseLock extends Thread {
    private String name;

    private int money;

    private AccountUseLock a;

    public DrawUseLock(String name, int money, AccountUseLock a) {
        super(name);
        this.money = money;
        this.a = a;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            a.draw(money);
        }
    }
}
