package com.clown.optional.model;

import java.util.Optional;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 **/
public class NewMan {

    private Optional<Goddess> goddess = Optional.empty();

    public NewMan() {
    }

    public NewMan(Optional<Goddess> goddess) {
        this.goddess = goddess;
    }

    public Optional<Goddess> getGoddess() {
        return goddess;
    }

    public void setGoddess(Optional<Goddess> goddess) {
        this.goddess = goddess;
    }

    @Override
    public String toString() {
        return "NewMan{" +
                "goddess=" + goddess +
                '}';
    }
}
