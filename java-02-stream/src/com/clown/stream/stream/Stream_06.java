package com.clown.stream.stream;

import com.clown.stream.model.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/16
 *
 * Stream 操作的三个步骤
 * 1.创建Stream
 * 2.中间操作
 * 3.终止操作(终端操作)
 *
 * 归约
 * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
 *
 * 收集
 * collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
 *
 *
 **/
public class Stream_06 {

    /**
     * 数据
     */
    List<Employee> employeeList = Arrays.asList(
        new Employee("张3",30,9999.99, Employee.Status.FREE),
        new Employee("李4",32,8888.88, Employee.Status.BUSY),
        new Employee("王5",36,7777.77, Employee.Status.VOCATION),
        new Employee("赵6",25,6666.66, Employee.Status.BUSY),
        new Employee("田7",40,5555.55, Employee.Status.FREE),
        new Employee("田7",40,5555.55, Employee.Status.FREE)
    );

    //归约
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    @Test
    public void test2(){
        Optional<Double> sum = employeeList.stream()
                                           .map(Employee::getSalary)
                                           .reduce(Double::sum);
        System.out.println(sum.get());
    }

    //收集
    @Test
    public void test3(){
        employeeList.stream()
                    .map(Employee::getName)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
    }

    @Test
    public void test4(){
        employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    @Test
    public void test5(){
        employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new))
                .forEach(System.out::println);
    }

    //总数
    @Test
    public void test6(){
        Long count = employeeList.stream()
                .collect(Collectors.counting());
        System.out.println(count);
    }

    //平均值
    @Test
    public void test7(){
        Double avg = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);
    }

    //工资总和
    @Test
    public void test8(){
        Double avg = employeeList.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(avg);
    }

    @Test
    public void test9(){
        Optional<Employee> salary = employeeList.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(salary.get());
    }

    @Test
    public void test10(){
        Optional<Double> max = employeeList.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));
        System.out.println(max.get());
    }

    @Test
    public void test11(){
        Optional<Double> min = employeeList.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());
    }

    //分组
    @Test
    public void test12(){
        Map<Employee.Status, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    //多列分组
    @Test
    public void test13(){
        Map<Employee.Status, Map<String, List<Employee>>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (((Employee) e).getAge() <= 30) {
                        return "青年";
                    } else if (((Employee) e).getAge() < 40) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(map);
    }

    //分区
    @Test
    public void test14(){
        Map<Boolean, List<Employee>> map = employeeList.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 7000));
        System.out.println(map);
    }

    @Test
    public void test15(){
        DoubleSummaryStatistics collect = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect.getMax());
        System.out.println(collect.getAverage());
        System.out.println(collect.getMin());
        System.out.println(collect.getCount());
        System.out.println(collect.getSum());
    }

    @Test
    public void test16(){
        String str = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",","===","==="));
        System.out.println(str);

    }

}
