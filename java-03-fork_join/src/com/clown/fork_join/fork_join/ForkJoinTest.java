package com.clown.fork_join.fork_join;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 **/
public class ForkJoinTest {

    @Test
    public void test1(){

        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinCalculate(0,10000000L);

        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间: "+Duration.between(start,end).toMillis());//3045
    }

    @Test
    public void test2(){

        Instant start = Instant.now();

        long sum = 0L;
        for (long i =0; i<=50000000L;i++){
            sum +=i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费时间: "+Duration.between(start,end).toMillis());//2767
    }

    /**
     * java8并行流
     */
    @Test
    public void test3(){
        Instant start = Instant.now();

        LongStream.rangeClosed(0,10000000L)
                  .parallel()
                  .reduce(0,Long::sum);
        Instant end = Instant.now();
        System.out.println("耗费时间: "+Duration.between(start,end).toMillis());//2588

    }
}
