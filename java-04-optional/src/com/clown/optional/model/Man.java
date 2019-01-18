package com.clown.optional.model;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 **/
public class Man {

    private Goddess  goddess;

    public Man() {
    }

    public Man(Goddess goddess) {
        this.goddess = goddess;
    }

    public Goddess getGoddess() {
        return goddess;
    }

    public void setGoddess(Goddess goddess) {
        this.goddess = goddess;
    }

    @Override
    public String toString() {
        return "Man{" +
                "goddess=" + goddess +
                '}';
    }
}
