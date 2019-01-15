package com.clown.reference;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/15
 *
 * 数组引用:
 *
 * Type::new
 *
 **/
public class ArrayReference {

    @Test
    public void test(){
        Function<Integer,String[]> fun = (e) -> new String[e];
        String[] strList = fun.apply(10);
        System.out.println(strList.length);

        Function<Integer,String[]> fun1 = String[]::new;
        String[] strList1 = fun1.apply(20);
        System.out.println(strList1.length);
    }
}
