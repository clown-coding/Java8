package com.clown.optional.interfacemethod.methodtest;

import com.clown.optional.interfacemethod.MyFunction;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 *
 * 类优先: 若一个接口定义了一个默认方法,另一个父类又定义了一个同名方法
 *
 * ① 选择父类中的方法:如果父类提供了具体的实现,那么接口中具有相同方法名,相同参数的方法将会被忽略
 * ② 接口冲突:如果一个父接口提供了一个默认方法,而另一个接口也提供了一个具有相同方法名,相同参数的方法(不管方法是否是默认),必须覆盖该方法来解决冲突
 *
 *
 **/
public class MyFunctionStaticTest {

    public static void main(String[] args){
        MyFunction.listening();

    }
}
