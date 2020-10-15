package com.common.threadcommunication.visibility;

/**
 * @author:ls
 * @date: 2020/9/28 10:47
 **/
public final class ObjectWithVolatile {

    //volatile表示易变的，线程可见
    private volatile ImmutableObject immutableObject;

    public ImmutableObject get(){
        return immutableObject;
    }

    public void set(int age){
        immutableObject = new ImmutableObject(age);
    }

    public static void main(String[] args) {
        ObjectWithVolatile ObjectWithVolatile = new ObjectWithVolatile();
        ObjectWithVolatile.set(1);
        System.out.println("开始： " + ObjectWithVolatile.get().getAge());
        //开启新线程设置age为新值
        new Thread(()->{
            ObjectWithVolatile.set(2);
        }).start();
        //多线程情况下，setage新值时由于并没有对其他线程可见，因此此处打印很可能还是为1而不是2
        System.out.println("第一次： " + ObjectWithVolatile.get().getAge());
        new Thread(()->{
            ObjectWithVolatile.set(3);
        }).start();
        //此处一样并非设置新值后立即对该get().getAge()可见，因此可能为2而不是3
        System.out.println("第二次： " + ObjectWithVolatile.get().getAge());
    }
}
