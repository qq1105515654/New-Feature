package com.feature.test.date.clock;

import org.apache.tomcat.jni.Local;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author snh
 * @version 1.0
 * @className Test
 * @description TODO 新的 Date API 测试 Clock
 * @date 2019/11/1 16:13
 **/
public class Test {


    public static void main(String[] args) {
        Clock clock=Clock.systemDefaultZone();
        long millis=clock.millis();
        System.out.println(millis);
        System.out.println(clock.getZone().getId());
        Instant instant=clock.instant();
        //转换为 java.util.Date 对象
        Date date=Date.from(instant);
        //获取所有时区的 ZoneId
        //ZoneId.getAvailableZoneIds().forEach(zone-> System.out.println(zone));
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1=ZoneId.of("Europe/Berlin");
        ZoneId zone2=ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());
        //获取不同时区的本地时间
        LocalTime now1=LocalTime.now(zone1);
        LocalTime now2=LocalTime.now(zone2);
        //false
        System.out.println(now1.isBefore(now2));

        long hoursBetween= ChronoUnit.HOURS.between(now1,now2);
        long minutesBetween=ChronoUnit.MINUTES.between(now1,now2);
        //-3
        System.out.println(hoursBetween);
        //-239
        System.out.println(minutesBetween);



        LocalTime late= LocalTime.of(23,59,59);
        System.out.println(late);

        DateTimeFormatter germanFormat=DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.GERMAN);

        LocalTime leetTime=LocalTime.parse("12:37",germanFormat);
        System.out.println(leetTime);

        LocalDate now=LocalDate.now();
        //在当前的时间基础上 增加指定单位的时间：DAYS天
        LocalDate tomorrow=now.plus(1,ChronoUnit.DAYS);
        //在当前时间基础上，减去指定天数
        LocalDate yesterday=tomorrow.minusDays(2);
        LocalDate independenceDay=LocalDate.of(2014, Month.JULY,4);
        DayOfWeek dayOfWeek=independenceDay.getDayOfWeek();
        System.out.println(now);
        System.out.println(tomorrow);
        System.out.println(yesterday);
        System.out.println(dayOfWeek);
    }
}
