package com.clown.stream.service;

@FunctionalInterface
public interface FilterEmployee<T> {

    boolean filter(T t);

    //boolean filter2(T t);
}
