package com.common.threadcommunication.visibility;

/**
 * @author:ls
 * @date: 2020/9/28 10:47
 * 并发编程三概念
 * 1.原子性 需要对保持数据一致性的代码块进行synchronized或加锁，对基本数据类型的变量赋值为原子性，否则必定经过从主存取数据，然后写入线程内内存过程
 * 2.可见性 单个线程中修改变量后不一定会立即更新到主存，需要通过sync或锁保持一致，因sync执行完毕或者解锁后会进行写值到主存，通过volatile也会线程内值修改后立即刷新到主存
 * 3.有序性 每行代码的执行顺序不一定按照所写的来，会通过cpu进行指令重排，但是会保证重排后顺序不影响执行结果。多线程中不能保证重排的影响
 **/
public final class ObjectWithVolatile {

    //volatile表示易变的，线程可见
    private volatile ImmutableObject immutableObject;

    private volatile int a = 0;

    public volatile int c = 0;

    public ImmutableObject get(){
        return immutableObject;
    }

    public void set(int age){
        immutableObject = new ImmutableObject(age);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        ObjectWithVolatile ObjectWithVolatile = new ObjectWithVolatile();
        ObjectWithVolatile.set(1);
        System.out.println(String.format("开始：io.age=%d,a=%d,c=%d",ObjectWithVolatile.get().getAge(),ObjectWithVolatile.getA(),ObjectWithVolatile.c));
        //开启新线程设置age为新值
        new Thread(()->{
//            ObjectWithVolatile.set(2);
//            ObjectWithVolatile.setA(3);
            System.out.println(ObjectWithVolatile.c );
            ObjectWithVolatile.c = 10;
        }).start();
        //多线程情况下，setage新值时由于并没有对其他线程可见，因此此处打印很可能还是为1而不是2
        System.out.println(String.format("第一次：io.age=%d,a=%d,c=%d",ObjectWithVolatile.get().getAge(),ObjectWithVolatile.getA(),ObjectWithVolatile.c));
        new Thread(()->{
//            ObjectWithVolatile.set(3);
//            ObjectWithVolatile.setA(4);
            System.out.println(ObjectWithVolatile.c );
            ObjectWithVolatile.c = 11;
        }).start();
        //此处一样并非设置新值后立即对该get().getAge()可见，因此可能为2而不是3
        System.out.println(String.format("第二次：io.age=%d,a=%d,c=%d",ObjectWithVolatile.get().getAge(),ObjectWithVolatile.getA(),ObjectWithVolatile.c));
    }
}
