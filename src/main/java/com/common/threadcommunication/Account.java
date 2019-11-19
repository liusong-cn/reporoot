package com.common.threadcommunication;

public class Account {

    private String no;

    private int money;

    //是否已有存款
    private boolean flag = false;
    public int getMoney(){
        return this.money;
    }

    public Account(String no, int money){
        this.no = no;
        this.money = money;
    }

    public synchronized void deposite(int money){
        try{
            if(flag) {
                wait();
            }else {
                this.money += money;
                flag = true;
                notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized  void draw(int money){
        try {
            if(!flag){
                wait();
            }else{
                this.money -= money;
                flag = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
