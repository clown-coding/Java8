package com.clown.lambda.lambda_04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/15
 *
 * Java8 内置4大核心函数式接口
 *
 * 1. Consumer<T>               消费型接口
 *      void accept(T t);
 *
 * 2. Supplier<T>               供给型接口
 *      T get();
 *
 * 3. Function<T,R>             函数型接口
 *      R apply(T t);
 *
 * 4. Predicate<T t>            断言型接口
 *      boolean test(T t);
 *
 **/
public class LambdaExpressionsTest {

    private void happy(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    /**
     * 消费
     */
    @Test
    public void lambdaConsumerTest(){
       happy(10000,(money) -> System.out.println("大宝剑消费"+money+"元,DD感觉活不错..."));
    }

//=========================================================================================

    private List<Integer> getNumList(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= num; i++){
            list.add(supplier.get());
        }
        return list;
    }

    /**
     * 产生指定个数的随机数放入到集合中
     */
    @Test
    public void lambdaSupplierTest(){
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }

//=========================================================================================

    @Test
    public void lambdaFunctionTest(){
        System.out.println(strHandler("clown is laughing at you...",(str) -> str.toUpperCase()));
        System.out.println(strHandler("clown is laughing at you   ...  ",(str) -> str.trim()));
        System.out.println(strHandler("clown is laughing at you...",(str) -> str.substring(0,5)));
    }
    /**
     * 用于处理字符串
     */
    private String strHandler(String str, Function<String,String> function){
        return function.apply(str);
    }

//=========================================================================================

    /**
     * 处理字符串,将满足条件的字符串添加到集合中
     */
    private List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

    @Test
    public void lambdaPredicateTest(){
        List<String> list = Arrays.asList("clown","is","laughing","at","you");
        List<String> strList = filterStr(list, (str) -> str.length() > 2);
        for (String str : strList) {
            System.out.println(str);
        }
    }
}
