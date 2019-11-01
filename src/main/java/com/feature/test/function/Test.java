package com.feature.test.function;

import java.util.function.Function;

/**
 * @author snh
 * @version 1.0
 * @className Test
 * @description TODO Function 接口测试
 * @date 2019/11/1 14:47
 **/
public class Test {


    public static void main(String[] args) {

        Function<String,Integer> toInteger=Integer::valueOf;
        Function<String,String> backToString=toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("123").getClass().getTypeName());
        System.out.println(toInteger.compose(String::valueOf).apply("789").getClass().getTypeName());
    }
}
