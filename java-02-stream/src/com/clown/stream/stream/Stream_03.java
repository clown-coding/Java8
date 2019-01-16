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
 * 中间操作
 *
 * 映射
 * 	map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
 * 	flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
 *
 *
 **/
public class Stream_03 {

    /**
     * 数据
     */
    List<Employee> list = Arrays.asList(
        new Employee("张3",30,9999.99),
        new Employee("李4",32,8888.88),
        new Employee("王5",36,7777.77),
        new Employee("赵6",25,6666.66),
        new Employee("田7",40,5555.55)
    );

    @Test
    public void test1(){
        List<String> list = Arrays.asList("aa","bb","cc","dd","ee");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
    }

    @Test
    public void test2(){
        list.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

    }

    @Test
    public void test3(){
        List<String> list = Arrays.asList("aa","bb","cc","dd","ee");
        Stream<Stream<Character>> stream1 = list.stream()
                .map(Stream_03::filterCharacter);
        stream1.forEach((sm) -> sm.forEach(System.out::println));

        System.out.println("--------------------------------------");

        list.stream()
                .flatMap(Stream_03::filterCharacter)
                .forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray() ) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     *  集合测试
     *  add: 将整个集合作为一个元素添加到集合中
     *  addAll: 将集合中每一个元素添加到集合中
     */
    @Test
    public void testList(){
        List<String> list1 = Arrays.asList("aa","bb","cc","dd");
        List  list2 = new ArrayList<>();
        list2.add(11);
        list2.add(22);
        list2.add(33);
        //list2.add(list1);
        list2.addAll(list1);
        System.out.println(list2);
    }
}
