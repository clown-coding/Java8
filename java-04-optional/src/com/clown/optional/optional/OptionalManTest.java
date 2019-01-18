package com.clown.optional.optional;

import com.clown.optional.model.Goddess;
import com.clown.optional.model.Man;
import com.clown.optional.model.NewMan;
import org.junit.Test;

import java.util.Optional;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 *
 * Optional 容器类：用于尽量避免空指针异常
 *
 **/
public class OptionalManTest {

    //获取一个男人心中女神的名字
    private String getGoddessName(Man man){
        if (man != null) {
           Goddess goddess =  man.getGoddess();
            if (goddess != null) {
                return goddess.getName();
            }
        }
        return "苍老师";
    }

    @Test
    public void test1(){
        Man man = new Man();
        String goddessName = getGoddessName(man);
        System.out.println(goddessName);
    }

    //获取一个新时代男人心中女神的名字
    private String getNewGoddessName(Optional<NewMan> newMan){
        return newMan.orElse(new NewMan())
                     .getGoddess()
                     .orElse(new Goddess("苍老师"))
                     .getName();
    }



    @Test
    public void test2(){
        Optional<Goddess> goddess = Optional.ofNullable(new Goddess("波多老师"));
        //Optional<Goddess> goddess = Optional.ofNullable(null);
        //Optional<NewMan> newMan = Optional.ofNullable(null);
        Optional<NewMan> newMan = Optional.ofNullable(new NewMan(goddess));
        String goddessName = getNewGoddessName(newMan);
        System.out.println(goddessName);
    }


}
