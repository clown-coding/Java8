package com.clown.time.temporaladjuster;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 *
 * TimeAdjuster: 时间矫正器
 *
 **/
public class TemporalAdjusterTest {

    @Test
    public void test1(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime now1 = now.withDayOfMonth(10);
        System.out.println(now1);

        LocalDateTime now2 = now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(now2 );

        //自定义: 下一个工作日是什么时间
        LocalDateTime workTime = now.with((t) -> {
            LocalDateTime ldt = (LocalDateTime) t;
            DayOfWeek dayOfWeek = ldt.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return ldt.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return ldt.plusDays(2);
            } else {
                return ldt.plusDays(1);
            }
        });

        System.out.println(workTime);

    }
}
