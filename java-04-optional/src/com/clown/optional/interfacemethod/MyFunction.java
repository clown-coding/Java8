package com.clown.optional.interfacemethod;

public interface MyFunction {

    default String listen(){
        return "clown is laughing at you...";
    }

    static void listening(){
        System.out.println("clown is laughing at you...");
    }
}
