package com.clown.annotaion.annotaiontest;

import com.clown.annotaion.annotaiontest.annotation.MyAnnotation;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 *
 * 重复注解与类型注解
 *
 **/
public class AnnotationTest {


    @MyAnnotation("clown ")
    @MyAnnotation("is ")
    @MyAnnotation("laughing ")
    @MyAnnotation("at ")
    @MyAnnotation("you...")
    private void listen(@MyAnnotation("clown is laughing at you...") String str){
    }

    @Test
    public void test() throws NoSuchMethodException {
        Class<AnnotationTest> clazz = AnnotationTest.class;
        Method listen = clazz.getMethod("listen");

        MyAnnotation[] annotations = listen.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation annotation : annotations) {
            System.out.print(annotation.value());
        }
        System.out.println("\n");

        Arrays.asList(annotations).forEach(System.out::println);
    }

}
