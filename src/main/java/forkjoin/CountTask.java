package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author: Administrator
 * @date: 2021/3/2 19:56
 * 利用数字累加来验证fork join 框架的作用 eg： 1+2+3+4
 */
public class CountTask extends RecursiveTask<Integer> {

    private final int  THRESHOLD = 2;

    private int start;

    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        boolean canCompute = (end - start) <= THRESHOLD;
        int sum = 0;
        if(canCompute){
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }else {
            int mid = (end - start)/2;
            CountTask leftTask = new CountTask(start, mid);
            CountTask rightTask = new CountTask(mid + 1, end);
            //继续进行任务拆分
            leftTask.fork();
            rightTask.fork();
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            sum = leftResult + rightResult;

        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        //得到任务结果
        ForkJoinTask<Integer> r = pool.submit(new CountTask(1, 4));
        System.out.println(r.join());
    }
}
