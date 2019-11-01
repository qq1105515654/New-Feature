package com.feature.test.consumer;

import com.feature.test.lamdba.Person;

import java.util.function.Consumer;

/**
 * @author snh
 * @version 1.0
 * @className Test
 * @description TODO Consumer 接口测试
 * @date 2019/11/1 14:55
 **/
public class Test {

    public static void main(String[] args) {
        //Consumer接口表示在单个参数上的操作
        Consumer<Person> getter=(p) -> System.out.println("Hello," +p.getFirstName());
        getter.accept(new Person("Luke","TheShy"));

    }
}
