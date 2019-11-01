package com.feature.test.predicate;

import com.feature.test.lamdba.Person;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author snh
 * @version 1.0
 * @className Test
 * @description TODO Predicate 接口测试
 * @date 2019/11/1 14:31
 **/
public class Test {


    public static void main(String[] args) {
        Predicate<String> predicate=(s) -> s.length() >0;
        //根据设定的规则进行校验
        System.out.println(predicate.test("foo"));
        //对校验的结果进行取反
        System.out.println(predicate.negate().test("foo"));


        Predicate<Object> nonNull= Objects::nonNull;
        Predicate<Object> isNull=Objects::isNull;
        Predicate<String> isEmpty=String::isEmpty;
        Predicate<String> isNotEmpty=isEmpty.negate();

        System.out.println("nonNull："+nonNull.test(null));
        System.out.println("isNull："+isNull.test(new Person()));
        System.out.println("isEmpty："+isEmpty.test(""));
        System.out.println("isNotEmpty："+isNotEmpty.test(""));
    }

}
