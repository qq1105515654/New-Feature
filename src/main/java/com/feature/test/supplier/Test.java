package com.feature.test.supplier;

import com.feature.test.lamdba.Person;

import java.util.function.Supplier;

/**
 * @author snh
 * @version 1.0
 * @className Test
 * @description TODO Supplier 接口测试
 * @date 2019/11/1 14:53
 **/
public class Test {


    public static void main(String[] args) {
        Supplier<Person> supplier=Person::new;
        // new Person();
        Person person=supplier.get();
        System.out.println(person);
    }
}
