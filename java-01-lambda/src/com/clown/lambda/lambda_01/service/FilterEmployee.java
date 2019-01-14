package com.clown.lambda.lambda_01.service;

@FunctionalInterface
public interface FilterEmployee<T> {

    boolean filter(T t);

    //boolean filter2(T t);
}
