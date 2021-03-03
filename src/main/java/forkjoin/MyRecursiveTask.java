package forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author: ls
 * @date: 2021/3/2 15:50
 * 带有返回值的操作
 **/
public class MyRecursiveTask extends RecursiveTask<Integer> {

    @Override
    protected Integer compute() {

        return 100;
    }
}
