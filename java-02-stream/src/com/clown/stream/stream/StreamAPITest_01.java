package com.clown.stream.stream;

import com.clown.stream.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 **/
public class StreamAPITest_01 {

    /**
     * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
     *   给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
     */
    //map
    @Test
    public void test1(){
        Integer[] nums = new Integer[]{1,2,3,4};
        Arrays.stream(nums)
                .map((x) -> x * x)
                .forEach(System.out::println);
    }

    List<Employee> employeeList = Arrays.asList(
            new Employee("张3",30,9999.99, Employee.Status.FREE),
            new Employee("李4",32,8888.88, Employee.Status.BUSY),
            new Employee("王5",36,7777.77, Employee.Status.VOCATION),
            new Employee("赵6",25,6666.66, Employee.Status.BUSY),
            new Employee("田7",40,5555.55, Employee.Status.FREE),
            new Employee("田7",40,5555.55, Employee.Status.FREE)
    );

    /**
     * map && reduce 计算出有多少个Employee
     */
    @Test
    public void test2(){
        Optional<Integer> sum = employeeList.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(sum.get());
    }

}
