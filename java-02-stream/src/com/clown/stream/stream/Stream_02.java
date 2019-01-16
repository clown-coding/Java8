package com.clown.stream.stream;

import com.clown.stream.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
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
 * 中间操作
 *
 * 筛选与切片
 * 		filter——接收 Lambda ， 从流中排除某些元素。
 * 		limit——截断流，使其元素不超过给定数量。
 * 		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
 * 		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
 *
 **/
public class Stream_02 {

    /**
     * 数据
     */
    List<Employee> list = Arrays.asList(
        new Employee("张3",30,9999.99),
        new Employee("李4",32,8888.88),
        new Employee("王5",36,7777.77),
        new Employee("赵6",25,6666.66),
        new Employee("田7",40,5555.55),
        new Employee("田7",40,5555.55),
        new Employee("田7",40,5555.55)
    );

    //filter
    //过滤:中间操作不会做执行操作,直到终止操作执行才会执行全部操作, 即 "惰性求值"
    //内部迭代: 迭代操作由StreamAPI完成
    @Test
    public void test1(){
       Stream<Employee> stream = list.stream().filter((e) -> e.getAge() > 30);
        stream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test2(){
        Iterator<Employee> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    //limit
    @Test
    public void test3(){
            list.stream()
                .filter((e) -> {
                    System.out.println("短路！！！");
                    return e.getAge() > 30;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    //skip
    @Test
    public void test4(){
        list.stream()
                .filter((e) ->  e.getAge() > 20)
                .skip(2)
                .forEach(System.out::println);
    }

    //distinct 去重
    @Test
    public void test5(){
        list.stream()
                .filter((e) ->  e.getAge() > 20)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }
}
