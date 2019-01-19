package com.clown.time.localdatetime;

import org.junit.Test;

import java.time.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 *
 * LocalDate LocalTime LocalDateTime
 *
 **/
public class LocalDateTimeTest {

    //LocalDate LocalTime LocalDateTime
    @Test
    public void test1(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt1 = LocalDateTime.of(2019, 1, 19, 23, 23, 23);
        System.out.println(ldt1);

        LocalDateTime ldt2 = ldt.plusYears(2);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.minusMonths(2);
        System.out.println(ldt3);

        System.out.println("--------------------------");

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfWeek());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }

    //instant 时间戳(1970年1月1日0时0分0秒到某个指定时间的毫秒值)
    @Test
    public void test2(){
        Instant ins = Instant.now();
        System.out.println(ins);

        OffsetDateTime ins1 = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(ins1);

        Map<String, String> map = new HashMap<>(64);
        map.put("CTT","Asia/Shanghai");
        ZonedDateTime ins2 = ins.atZone(ZoneId.of("CTT",map));
        System.out.println(ins2);

        System.out.println(ins.toEpochMilli());

        Instant ins3 = Instant.ofEpochSecond(60);
        System.out.println(ins3);
    }

    //Duration: 计算两个'时间' 之间的间隔的
    @Test
    public void tsst3(){
        Instant ins = Instant.now();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        Instant ins1 = Instant.now();
        Duration between = Duration.between(ins, ins1);
        System.out.println(between.getSeconds());
        System.out.println(between.toMillis());
    }

    //Period:   计算两个'日期' 之间的间隔的
    //Duration: 计算两个'时间' 之间的间隔的
    @Test
    public void test4(){
        LocalTime now = LocalTime.now();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        LocalTime future = LocalTime.now();

        Duration between = Duration.between(now, future);
        System.out.println(between.getSeconds());
        System.out.println(between.toMillis());
    }

    @Test
    public void test5(){
        LocalDate now = LocalDate.now();
        LocalDate future = LocalDate.of(2021, 5, 20);

        Period between = Period.between(now, future);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
        System.out.println(between.toTotalMonths());
    }
}
