package com.clown.stream.stream;

import com.clown.stream.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
 * 排序:
 *  sorted(): 自然排序
 *  sorted(Comparator com): 定制排序
 *
 **/
public class Stream_04 {

    /**
     * 数据
     */
    List<Employee> employeeList = Arrays.asList(
        new Employee("张3",30,9999.99),
        new Employee("李4",32,8888.88),
        new Employee("王5",36,7777.77),
        new Employee("赵6",25,6666.66),
        new Employee("田7",40,5555.55)
    );

    /**
     * 自然排序
     */
    @Test
    public void test1(){
        List<String> list = Arrays.asList("aa","bb","cc","dd","ee");
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * 定制排序
     */
    @Test
    public void test2(){
        employeeList.stream()
                .sorted((x,y) -> {
                    if (x.getAge() == y.getAge()) {
                        return x.getName().compareTo(y.getName());
                    }else{
                        return Integer.compare(x.getAge(),y.getAge());
                    }
                }).forEach(System.out::println);
    }

}
