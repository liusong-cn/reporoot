package com.common.threadcommunication;

public class DrawAccount extends Thread {
    private Account account;

    private int drawmoney;

    public  DrawAccount(Account account, int drawmoney,String name){
        super(name);
        this.account = account;
        this.drawmoney = drawmoney;

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.draw(drawmoney);
            System.out.println("取钱成功：" + drawmoney + ":余额是：" + account.getMoney());
        }
    }
}
