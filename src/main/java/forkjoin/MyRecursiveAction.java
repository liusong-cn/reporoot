package forkjoin;

import java.util.concurrent.RecursiveAction;

/**
 * @author: ls
 * @date: 2021/3/2 15:23
 **/
public class MyRecursiveAction extends RecursiveAction {
    @Override
    protected void compute() {
        System.out.println("执行任务");
    }
}
