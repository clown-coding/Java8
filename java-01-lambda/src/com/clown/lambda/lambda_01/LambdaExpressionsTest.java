package com.clown.lambda.lambda_01;

import com.clown.lambda.lambda_01.model.Employee;
import com.clown.lambda.lambda_01.service.FilterEmployee;
import com.clown.lambda.lambda_01.service.impl.FilterEmployeeByAge;
import com.clown.lambda.lambda_01.service.impl.FilterEmployeeBySalary;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/14
 * 初识Lambda Stream
 **/
public class LambdaExpressionsTest {

    /*
     * 需求: 获取当前公司中员工年龄大于35的员工信息
     * 需求: 获取当前公司中员工工资大于6000的员工信息
     */

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

//=======================原始写法==============================================

    @Test
    public void lambdaTest01(){
        List<Employee> employeeListByAge = findEmployeeByAge(list);
        for (Employee employee : employeeListByAge) {
            System.out.println(employee);
        }

        List<Employee> employeeListBySalary = findEmployeeBySalary(list);
        for (Employee employee : employeeListBySalary) {
            System.out.println(employee);
        }
    }

    private List<Employee> findEmployeeByAge(List<Employee> list){
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge()>= 35) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    private List<Employee> findEmployeeBySalary(List<Employee> list){
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSalary()>= 6000) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }


//*************************************公用方法***********************************

    private List<Employee> findEmployee(List<Employee> list, FilterEmployee<Employee> filterEmployee){
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : list) {
            if (filterEmployee.filter(employee)) {
                employeeList.add(employee);
            }
        }
        return  employeeList;
    }

//**********************************公用方法************************************

//=======================优化方式1==============================================

    /**
     *  策略设计模式
     */
    @Test
    public void lambdaTest02(){
        List<Employee> employeeListByAge = findEmployee(list, new FilterEmployeeByAge());
        for (Employee employee : employeeListByAge) {
            System.out.println(employee);
        }

        System.out.println("-----------------------------------------------");

        List<Employee> employeeListBySalary = findEmployee(list, new FilterEmployeeBySalary());
        for (Employee employee : employeeListBySalary) {
            System.out.println(employee);
        }
    }

//=======================优化方式2==============================================

    @Test
    public void lambdaTest03(){
        List<Employee> employeeList = findEmployee(list, new FilterEmployee<Employee>() {
            @Override
            public boolean filter(Employee employee) {
                return employee.getSalary() <= 8000;
            }
        });

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

//=======================优化方式3: Lambda表达式 ==============================================

    @Test
    public void lambdaTest04(){
        List<Employee> employeeListBySalary = findEmployee(list, (e) -> e.getSalary() <= 8000);
        List<Employee> employeeListByAge = findEmployee(list, (e) -> e.getAge() >= 20);
        employeeListBySalary.forEach(System.out::println);
        System.out.println("---------------------------------------------");
        employeeListByAge.forEach(System.out::println);
    }

//=======================优化方式4: StreamAPI ==============================================

    /**
     * 假设现在没有 上面的所有方法: 公用方法也没有,FilterEmployee接口没有,2个实现类也没有
     */
    @Test
    public void lambdaTest05(){
        list.stream()
                .filter((e) -> e.getSalary() >= 6000)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("-----------------------------------------");

        list.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }


}
