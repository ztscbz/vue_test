package com.zt.m08day07;


import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @Description:
 * @author: ZT
 * @date: 2020/8/21 16:22
 */
public class Test6 {
    public static void main(String[] args) {
        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = LocalDateTime.of(2020, 8, 26,13,00,00);
        System.out.println(end.toLocalDate().toEpochDay() - start.toLocalDate().toEpochDay());

        Duration duration = Duration.between(start,end);
        long days = duration.toDays(); //相差的天数
        long hours = duration.toHours();//相差的小时数
        long minutes = duration.toMinutes();//相差的分钟数
        System.out.println(days + "     "+ hours + "     " + minutes );
        if(days == 0) days = hours;
        if(days == 0) days = minutes;
        System.out.println(days);

        Long aa = 125L;
        System.out.println(aa.intValue());
    }
}
