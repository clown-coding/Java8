package com.clown.stream.stream;

import com.clown.stream.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/16
 *
 * Stream 操作的三个步骤
 * 1.创建Stream
 * 2.中间操作
 * 3.终止操作(终端操作)
 *
 * 查找与匹配
 *
 *      allMatch——检查是否匹配所有元素
 * 		anyMatch——检查是否至少匹配一个元素
 * 		noneMatch——检查是否没有匹配的元素
 * 		findFirst——返回第一个元素
 * 		findAny——返回当前流中的任意元素
 * 		count——返回流中元素的总个数
 * 		max——返回流中最大值
 * 		min——返回流中最小值
 *
 **/
public class Stream_05 {

    /**
     * 数据
     */
    List<Employee> employeeList = Arrays.asList(
        new Employee("张3",30,9999.99, Employee.Status.FREE),
        new Employee("李4",32,8888.88, Employee.Status.BUSY),
        new Employee("王5",36,7777.77, Employee.Status.VOCATION),
        new Employee("赵6",25,6666.66, Employee.Status.BUSY),
        new Employee("田7",40,5555.55, Employee.Status.FREE)
    );

    /**
     *  allMatch——检查是否匹配所有元素
     */
    @Test
    public void test1(){
        boolean b = employeeList.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
    }

    /**
     * anyMatch——检查是否至少匹配一个元素
     */
    @Test
    public void test2(){
        boolean b = employeeList.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.VOCATION));
        System.out.println(b);
    }

    /**
     * noneMatch——检查是否没有匹配的元素
     */
    @Test
    public void test3(){
        boolean b = employeeList.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.VOCATION));
        System.out.println(b);
    }

    /**
     * findFirst——返回第一个元素
     */
    @Test
    public void test4(){
        Optional<Employee> employee = employeeList.stream()
                .sorted((x, y) -> -Double.compare(x.getSalary(), y.getSalary()))
                .findFirst();
        System.out.println(employee.get());
    }

    /**
     * findAny——返回当前流中的任意元素
     */
    @Test
    public void test5(){
        Optional<Employee> employee = employeeList.parallelStream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(employee.get());
    }

    /**
     * count——返回流中元素的总个数
     */
    @Test
    public void test6(){
        long count = employeeList.stream()
                .count();
        System.out.println(count);
    }

    /**
     * max——返回流中最大值
     */
    @Test
    public void test7(){
        Optional<Employee> employee = employeeList.stream()
                .max((x, y) -> Double.compare(x.getSalary(), y.getSalary()));
        System.out.println(employee.get());
    }

    /**
     * max——返回流中最大值
     */
    @Test
    public void test8(){
        Optional<Employee> employee = employeeList.stream()
                .min((x, y) -> Double.compare(x.getSalary(), y.getSalary()));
        System.out.println(employee.get());
    }

    /**
     * 获取最小的工资是多少
     */
    @Test
    public void test9(){
        Optional<Double> min = employeeList.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(min.get());
    }




}
