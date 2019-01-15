package com.clown.reference;

import com.clown.lambda.lambda_01.model.Employee;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/15
 *
 * 构造器引用:
 *
 * 构造器引用语法格式: className::new
 *
 * [注意]: 需要调用的构造器的参数列表要与函数式接口中的抽象方法的参数列表保持一致
 *
 **/
public class ConstructorReference {

    @Test
    public void test(){
        Supplier<Employee> sup = () -> new Employee();
        Employee employee = sup.get();
        System.out.println(employee);

        Supplier<Employee> sup1 =Employee::new;
        Employee employee1 = sup.get();
        System.out.println(employee1);


    }

    @Test
    public void test01(){
        Function<String,Employee> funOne = (e) -> new Employee(e);
        System.out.println(funOne.apply("clown"));

        Function<String,Employee> funOne1 = Employee::new;
        System.out.println(funOne1.apply("clown"));

        BiFunction<String,Integer,Employee> funTwo = (x,y) -> new Employee(x,y);
        System.out.println(funTwo.apply("clown",12));

        BiFunction<String,Integer,Employee> funTwo1 = Employee::new;
        System.out.println(funTwo1.apply("clown",12));

    }


}
