package com.clown.optional.optional;

import com.clown.optional.model.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 *
 * Optional 容器类：用于尽量避免空指针异常
 *
 **/
public class OptionalTest {

    //Optional.of(T t)  创建一个 Optional 实例
    @Test
    public void test1(){
        //Optional<Employee> employee = Optional.of(new Employee());
        //快速锁定空指针的位置
        Optional<Employee> employee = Optional.of(null);
        System.out.println(employee.get());
    }

 	//Optional.empty() : 创建一个空的 Optional 实例
    @Test
    public void test(){
        Optional<Employee> employee = Optional.empty();
        System.out.println(employee.get());
    }

  	//Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
    @Test
    public void test3(){
        //Optional<Employee> employee = Optional.ofNullable(new Employee());
        Optional<Employee> employee = Optional.ofNullable(null);
        System.out.println(employee.get());
    }

  	//isPresent() : 判断是否包含值
    @Test
    public void test4(){
        //Optional<Employee> employee = Optional.ofNullable(new Employee());
        Optional<Employee> employee = Optional.ofNullable(null);
        if (employee.isPresent()) {
            System.out.println(employee.get());
        }
    }

  	//orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
    @Test
    public void test5(){
        //Optional<Employee> employee = Optional.ofNullable(new Employee());
        Optional<Employee> employee = Optional.ofNullable(null);
        Employee emp = employee.orElse(new Employee("张3", 18, 8888.88, Employee.Status.FREE));
        System.out.println(emp);
    }

 	//orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
    @Test
    public void test6(){
        Optional<Employee> employee = Optional.ofNullable(null);
        Employee emp = employee.orElseGet(() -> new Employee());
        System.out.println(emp);
    }

 	//map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
    @Test
    public void test7(){
        Optional<Employee> employee = Optional.ofNullable(new Employee("张3", 18, 8888.88, Employee.Status.FREE));
        Optional<String> name = employee.map((e) -> e.getName());
        System.out.println(name.get());
    }

  	//flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
    @Test
    public void test8(){
        Optional<Employee> employee = Optional.ofNullable(new Employee("张3", 18, 8888.88, Employee.Status.FREE));
        Optional<String> name = employee.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(name.get());
    }

}
