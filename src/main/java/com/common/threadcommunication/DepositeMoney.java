package com.common.threadcommunication;

public class DepositeMoney extends Thread {

    private Account account;

    private int depositemoney;

    public DepositeMoney(Account account, int depositemoney, String name){
        super(name);
        this.account = account;
        this.depositemoney = depositemoney;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.deposite(depositemoney);
            System.out.println("存钱成功：" + depositemoney + ":余额是：" + account.getMoney());
        }
    }
}
