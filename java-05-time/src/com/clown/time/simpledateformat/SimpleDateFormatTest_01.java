package com.clown.time.simpledateformat;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 **/
public class SimpleDateFormatTest_01 {

    @Test
    public void test1() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> task =new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return sdf.parse("20181224");
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> list = new ArrayList<>();

        for(int i = 0; i<10;i++){
            list.add(pool.submit(task));
        }

        for (Future<Date> future : list) {
            System.out.println(future.get());
        }

        pool.shutdown();
    }
}
