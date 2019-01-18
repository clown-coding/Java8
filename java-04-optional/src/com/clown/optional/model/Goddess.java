package com.clown.optional.model;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 **/
public class Goddess {

    private String name;

    public Goddess() {
    }

    public Goddess(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goddess{" +
                "name='" + name + '\'' +
                '}';
    }
}
