package com.clown.time.simpledateformat;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 **/
public class SimpleDateFormatTest_02 {

    @Test
    public void test1() throws Exception{
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task =new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20181215",dtf);
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> list = new ArrayList<>();

        for(int i = 0; i<10;i++){
            list.add(pool.submit(task));
        }
        for (Future<LocalDate> future : list) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
