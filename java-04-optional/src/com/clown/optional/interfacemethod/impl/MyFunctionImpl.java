package com.clown.optional.interfacemethod.impl;

import com.clown.optional.interfacemethod.MyFunction;
import com.clown.optional.interfacemethod.MyFunction2;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 **/
public class MyFunctionImpl implements MyFunction, MyFunction2 {

    @Override
    public String listen() {
        return MyFunction2.super.listen();
    }
}
