package com.clown.lambda.lambda_03;

import com.clown.lambda.lambda_01.model.Employee;
import com.clown.lambda.lambda_03.service.MyFunction;
import com.clown.lambda.lambda_03.service.MyFunction2;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/15
 **/
public class LambdaExpressionsTest {

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
     * 按年龄进行排序
     */
    @Test
    public void lambdaTest01(){
        Collections.sort(employeeList, (e1,e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    /**
     * 需求: 处理字符串
     */
    @Test
    public void lambdaTest02(){
        System.out.println(strHandler(" clown is laughing at you ...  ", (str) -> str.trim()));
        System.out.println(strHandler("clown is laughing at you...", (str) -> str.toUpperCase()));
        System.out.println(strHandler("clown is laughing at you...", (str) -> str.substring(0,5)));
    }
    private String strHandler(String str, MyFunction myFunction){
        return myFunction.getValue(str);
    }


    @Test
    public void lambdaTest03(){
        operation(100L,200L,(x,y) -> x + y);
        operation(100L,200L,(x,y) -> x * y);
    }
    private void operation(Long l1, Long l2, MyFunction2<Long,Long> myFunction2){
        System.out.println(myFunction2.getValue(l1,l2));
    }
}
