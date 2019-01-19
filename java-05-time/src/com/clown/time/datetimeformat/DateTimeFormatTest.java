package com.clown.time.datetimeformat;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 *
 * DateTimeFormat: 格式化日期和时间
 *
 **/
public class DateTimeFormatTest {

    @Test
    public void test1(){
        //DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        String str = ldt.format(dtf);
        System.out.println(str);

        DateTimeFormatter mydtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日:HH:mm:ss");
        String myStr = mydtf.format(ldt);
        System.out.println(myStr);

        LocalDateTime parse = ldt.parse(myStr,mydtf);
        System.out.println(parse);
    }
}
