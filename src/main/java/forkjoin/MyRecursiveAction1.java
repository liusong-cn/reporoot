package forkjoin;

import java.util.concurrent.RecursiveAction;

/**
 * @author: ls
 * @date: 2021/3/2 15:27
 **/
public class MyRecursiveAction1 extends RecursiveAction {
    private int begin;

    private int end;

    public MyRecursiveAction1(int begin, int end) {
        super();
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected void compute() {
        System.out.println(Thread.currentThread().getName() + "---------");
        if(end - begin > 2){
            int mid = (begin + end)/2;
            MyRecursiveAction1 left = new MyRecursiveAction1(begin, mid);
            MyRecursiveAction1 right = new MyRecursiveAction1(mid, end);
            invokeAll(left, right);
        }else {
            System.out.println(Thread.currentThread().getName() + ": " + begin + "-" + end);
        }
    }
}
