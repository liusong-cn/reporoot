package forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author: ls
 * @date: 2021/3/2 15:24
 **/
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //基础forkjoin
//        forkJoinPool.submit(new MyRecursiveAction());

        //分解任务
//        forkJoinPool.submit(new MyRecursiveAction1(1, 10));

        //有执行结果的任务
        ForkJoinTask<Integer> task = forkJoinPool.submit(new MyRecursiveTask());
        //1 get方法返回值抛出的异常可以被main线程捕获
//        try {
//            System.out.println(task.get());
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        //2 join方法返回值有异常则直接抛出，不能为main捕获
        System.out.println(task.join());

        //让子任务有充分时间执行
        Thread.sleep(5000);
    }
}
