package com.common.threadcommunication.visibility;

/**
 * @author:ls 测试多线程情况下对象的可见性
 * @date: 2020/9/28 10:31
 **/
public class ObjectWithNothing {

    private ImmutableObject immutableObject;

    public ImmutableObject get(){
        return immutableObject;
    }

    public void set(int age){
        immutableObject = new ImmutableObject(age);
    }

    public static void main(String[] args) {
        ObjectWithNothing objectWithNothing = new ObjectWithNothing();
        objectWithNothing.set(1);
        System.out.println("开始： " + objectWithNothing.get().getAge());
        //开启新线程设置age为新值
        new Thread(()->{
            objectWithNothing.set(2);
            System.out.println("第x次： " + objectWithNothing.get().getAge());
        }).start();
        new Thread(()->{
            objectWithNothing.set(3);
            System.out.println("第y次： " + objectWithNothing.get().getAge());
        }).start();
        //多线程情况下，setage新值时由于并没有对其他线程可见，因此此处打印很可能还是为1而不是2
        System.out.println("第一次： " + objectWithNothing.get().getAge());
        //此处一样并非设置新值后立即对该get().getAge()可见，因此可能为2而不是3
        System.out.println("第二次： " + objectWithNothing.get().getAge());

    }
}
