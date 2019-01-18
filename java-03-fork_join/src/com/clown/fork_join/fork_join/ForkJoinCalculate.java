package com.clown.fork_join.fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 **/
public class ForkJoinCalculate extends RecursiveTask<Long> {

    /**
     * 累加操作
     * @return
     */

    private long start;
    private long end;

    private static final long THRESHOLD = 10000;

    public ForkJoinCalculate(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = 0; i <= end; i++ ){
                sum += i;
            }
            return sum;
        }else{
            long middle = (start+end)/2;

            ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
            left.fork();//拆分子任务,同时压入线程队列

            ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
