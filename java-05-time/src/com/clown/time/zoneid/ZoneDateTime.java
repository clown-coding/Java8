package com.clown.time.zoneid;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 *
 * Zoneid: 时区操作
 *  ZoneDate  ZoneTime  ZoneDateTime
 *
 **/
public class ZoneDateTime {

    @Test
    public void test(){
        Set<String> zone = ZoneId.getAvailableZoneIds();
        zone.forEach(System.out::println);
    }

    @Test
    public void test1(){
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);
    }

    @Test
    public void test2(){
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zone = now.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zone);
    }
}
