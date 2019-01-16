package com.clown.stream.stream;

import com.clown.stream.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/16
 *
 * Stream 操作的三个步骤
 * 1.创建Stream
 * 2.中间操作
 * 3.终止操作(终端操作)
 *
 * 创建stream流
 *
 **/
public class Stream_01 {

    @Test
    public void streamTest01(){
        //1.通过Collection 序列集合提供的 stream() 或 parallelStream() 获取流
        List<String> lsit = new ArrayList<>();
        Stream<String> stream1 = lsit.stream();

        //2.通过Arrarys中的静态方法 stream获取数组流
        Employee[] employee = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employee);

        //3.通过Stream中的静态方法 of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc", "dd");

        //4.创建无限流
        //4.1 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (e) -> e + 2);
        stream4.limit(10).forEach(System.out::println);

        //4.2生成
        Stream<Double> stream5 = Stream.generate(() -> Math.random());
        stream5.limit(5).forEach(System.out::println);
    }
}
