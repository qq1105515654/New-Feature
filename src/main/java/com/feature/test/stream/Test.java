package com.feature.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author snh
 * @version 1.0
 * @className Test
 * @description TODO Stream 接口测试
 * @date 2019/11/1 15:19
 **/
public class Test {

    public static void main(String[] args) {
        List<String> strList=new ArrayList<String>();
        strList.add("ddd2");
        strList.add("aaa2");
        strList.add("bbb1");
        strList.add("aaa1");
        strList.add("bbb3");
        strList.add("ccc");
        strList.add("bbb2");
        strList.add("ddd1");

        /**
         * Filter 过滤
         */
        // 输出 aaa2   aaa1
        //strList.stream().filter((s) -> s.startsWith("a")).forEach(str -> System.out.println(str));
        /**
         * sort 排序 不会修改源数据，会创建一个排序好的 Stream
         */
        //输出 aaa1   aaa2
        //strList.stream().sorted().filter((s) -> s.startsWith("a")).forEach(str -> System.out.println(str));

        /**
         * map 映射
         */
        //strList.stream().map(String::toUpperCase).forEach(str -> System.out.println(str));

        /**
         * match 匹配
         */
        //任意一个匹配到返回 true
        boolean anyMatch=strList.stream().anyMatch((s) -> s.startsWith("a"));
        //System.out.println("anyMatch："+anyMatch);
        //所有的值都得匹配到
        boolean allMatch=strList.stream().allMatch((s) -> s.startsWith("a"));
        //System.out.println("allMatch："+allMatch);
        //没有值能匹配到
        boolean noneMatch=strList.stream().noneMatch((s) -> s.startsWith("s"));
        //System.out.println("noneMatch："+noneMatch);

        /**
         * count 计数
         */
        //System.out.println(strList.stream().filter((s) -> s.startsWith("b")).count());

        /**
         * reduce 规约
         */
        //输出 aaa1→aaa2→bbb1→bbb2→bbb3→ccc→ddd1→ddd2
        Optional<String> reduce=strList.stream().sorted().reduce((s1,s2) -> s1+"→"+s2);
        //System.out.println(reduce.get());


        /**
         *  并行 Streams 排序所需时间比 串行节省了将近 50%的时间
         *  计算串行排序跟并行排序的计算使用时间
         */
        //串行
        serial();
        //并行
        parallel();

    }

    /**
     * 串行排序
     */
    public static void serial(){
        int max=1000000;
        List<String> values=new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid=UUID.randomUUID();
            values.add(uuid.toString());
        }
        long t0=System.nanoTime();
        long count=values.stream().sorted().count();
        System.out.println("Count："+count);
        long t1=System.nanoTime();
        long millis= TimeUnit.NANOSECONDS.toMillis(t1-t0);
        System.out.println(String.format("sequential sort took：%d ms",millis));
    }

    /**
     * 并行排序
     */
    public static void parallel(){
        int max=1000000;
        List<String> values=new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid=UUID.randomUUID();
            values.add(uuid.toString());
        }
        long t0=System.nanoTime();
        long count=values.parallelStream().sorted().count();
        System.out.println("Count："+count);
        long t1=System.nanoTime();
        long millis=TimeUnit.NANOSECONDS.toMillis(t1-t0);
        System.out.println(String.format("parallel sort took：%d ms",millis));
    }
}
