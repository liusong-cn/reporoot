package com.common.threadcommunication;

public class Test {
    public static void main(String[] args) {
        /*Account account = new Account("zhang",0);
        new Thread(new DrawAccount(account,500,"取钱")).start();
        new Thread(new DepositeMoney(account,500,"存钱")).start();
        new Thread(new DepositeMoney(account,500,"存钱")).start();
        new Thread(new DepositeMoney(account,500,"存钱")).start();*/

        AccountUseLock account = new AccountUseLock("zhang",500);
        new Thread(new DrawUseLock("取钱",500,account)).start();
        new Thread(new DepositeUseLock("存钱",account,500)).start();
        new Thread(new DepositeUseLock("存钱",account,500)).start();
        new Thread(new DepositeUseLock("存钱",account,500)).start();
    }
}
