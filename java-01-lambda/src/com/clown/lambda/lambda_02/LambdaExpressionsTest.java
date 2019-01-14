package com.clown.lambda.lambda_02;

import com.clown.lambda.lambda_02.service.MyFun;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/14
 *
 * Lambda表达式的基础语法
 * 1.java8引入了一个新的操作符 "->" 该操作符我们成为Lambda操作符
 * 2.->将Lambda表达式拆分成2部分 左侧 右侧
 *  左侧: Lambda表达式的参数列表
 *  右侧: Lambda表达式中所需要执行的功能 即Lambda体
 *
 * Lambda语法格式
 * 1. 无参数 && 无返回值:
 *      () -> System.out.println("clown is laughing at you...");
 *
 * 2. 1个参数 && 无返回值
 *      (e) -> System.out.println(e);
 *
 * 3. 如果只有1个参数 && 无返回值 [参数的小括号可以不写,实际还是写上]
 *      e -> System.out.println(e);
 *
 * 4. 2个以上参数 && 有返回值 && Lambda体中有多条语句
 *      Comparator<Integer> com = (x,y) -> {
 *             System.out.println("clown is laughing at you...");
 *             return Integer.compare(x,y);
 *         };
 *         System.out.println(com.compare(6,5));
 *
 * 5. 2个以上参数 && 有返回值 && Lambda体中只有一条语句 [return and {} 都可以省略不写]
 *      Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
 *      System.out.println(com.compare(6,5));
 *
 * 6. Lambda表达式的参数列表的数据类型可以省略不写,因为JVM编译器可以通过上下文推断出数据类型 [类型推断]
 *      (Integer x,Integer y) -> Integer.compare(x,y);
 *      List<String> list = new ArrayList<>();
 *
 * [总结]:
 *  左右遇一括号省
 *          1个参数 && 无返回值                    不用写小括号
 *          多个参数 && Lambda体中只有一条语句       不用写大括号
 *  左侧推断类型省
 *          左侧参数类型有推断,右侧就不用写参数类型
 *
 *  Lambda表达式需要函数式接口的支持
 *  函数式接口:若接口中只有一个抽象方法的接口,成为函数式接口
 *           可以使用注解@FunctionInterface 修饰一下,就可以检查这个接口是否是函数式接口:只能有一个抽象方法
 *
 *                                  ************
 *                                  *  能省则省  *
 *                                  ************
 *
 *                       ++++++                      ++++++
 *                       * 左 *                       * 左 *
 *                       * 右 *                       * 侧 *
 *                       * 遇 *                       * 推 *
 *                       * 一 *                       * 断 *
 *                       * 括 *                       * 类 *
 *                       * 号 *                       * 型 *
 *                       * 省 *                       * 省 *
 *                       ++++++                      ++++++
 *
 *
 **/
public class LambdaExpressionsTest {

    /**
     * 语法格式1
     */
    @Test
    public void lambdaTest01(){

        //jdk1.7前,这个变量必须+final关键字
        //final int num =1;
        //jdk1.8后,这个变量还是final,只不过你不用+final关键字了
        int num =528491;

        //原始写法
        Runnable runnable01 = new Runnable() {
            @Override
            public void run() {
                System.out.println("clown is laughing at you..."+num);
            }
        };
        runnable01.run();

        System.out.println("-------------------------------------------");

        Runnable runnable02 = () -> System.out.println("clown is laughing at you..."+num);
        runnable02.run();
    }

    /**
     * 语法格式2
     */
    @Test
    public void lambdaTest02(){
        Consumer<String> con = (e) -> System.out.println(e);
        con.accept("clown is laughing at you...");
    }

    /**
     * 语法格式3
     */
    @Test
    public void lambdaTest03(){
        Consumer<String> con = e -> System.out.println(e);
        con.accept("clown is laughing at you...");
    }

    /**
     * 语法格式4
     */
    @Test
    public void lambdaTest04(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("clown is laughing at you...");
            return Integer.compare(x,y);
        };
        System.out.println(com.compare(6,5));
    }

    /**
     * 语法格式5
     */
    @Test
    public void lambdaTest05(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        System.out.println(com.compare(6,5));
    }

    /**
     * 需求:对一个数进行运算
     */
    @Test
    public void lambdaTest06(){
        System.out.println(operation(100,(x) -> x * x));
        System.out.println(operation(200,(x) -> x + 200));
    }

    private Integer operation(Integer num,MyFun myFun){
        return myFun.getValue(num);
    }

}
