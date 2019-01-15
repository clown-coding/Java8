package com.clown.reference;

import com.clown.lambda.lambda_01.model.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/15
 *
 * 方法引用: 若 Lambda 体中的内容有方法已经实现了,我们可以使用 "方法引用"
 *         (可以理解为方法引用是 Lambda 表达式的另外一种表现形式)
 *
 * 主要有三种语法格式:
 *
 *  1. 对象::实例方法名
 *
 *  2. 类::静态方法名
 *
 *  3. 类::实例方法名
 *
 *  [注意]:
 *        ①. Lambda 体中调用方法的参数列表与返回值类型,要与函数式接口中抽象方法的参数列表和返回值保持一致
 *        ②.若 Lambda 参数列表中的第一个参数是实例方法的调用者,而第二个参数是实例方法的参数时,可以使用 className::method
 *
 *
 **/
public class MethodReference {


    //对象::实例方法名
    @Test
    public void test01(){
        //第一种写法
        PrintStream ps = System.out;
        Consumer<String> con = (e) -> ps.println(e);
        con.accept("clown is laughing at you...");

        //对象::实例方法名
        PrintStream ps0 = System.out;
        Consumer<String> con0 = ps::println;
        con0.accept("clown is laughing at you...");

        //第三种写法
        Consumer<String> con1 = System.out::println;
        con1.accept("clown is laughing at you...");

        Employee employee = new Employee();
        employee.setName("华安");
        Supplier<String> sup = () -> employee.getName();
        System.out.println(sup.get());

        Employee employee1 = new Employee();
        employee1.setName("小强");
        Supplier<String> sup1 = employee1::getName;
        System.out.println(sup1.get());
    }


    //类::静态方法名
    @Test
    public void test02(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x,y);
        System.out.println(com.compare(10,9));

        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com.compare(10,9));
    }

    //类::实例方法名
    @Test
    public void test03(){
        BiPredicate<String,String> bp = (x,y) -> x.equals(y);
        System.out.println(bp.test("clown","clown"));

        BiPredicate<String,String> bp1 = String::equals;
        System.out.println(bp1.test("clown","clown"));
    }
}
