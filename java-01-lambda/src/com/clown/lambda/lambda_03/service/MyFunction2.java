package com.clown.lambda.lambda_03.service;

@FunctionalInterface
public interface MyFunction2<T,R> {

    R getValue(T t1,T t2);
}
