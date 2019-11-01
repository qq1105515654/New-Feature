package com.feature.test.comparator;

import com.feature.test.lamdba.Person;

import java.util.Comparator;

/**
 * @author snh
 * @version 1.0
 * @className Test
 * @description TODO Comparator 接口测试
 * @date 2019/11/1 15:02
 **/
public class Test {


    public static void main(String[] args) {

        Comparator<Person> comparator=(p1,p2)-> p1.getFirstName().compareTo(p2.getFirstName());

        Person p1=new Person("John","Doe");
        Person p2=new Person("Alice","Wonderland");
        // > 0
        System.out.println(comparator.compare(p1,p2));
        // < 0
        System.out.println(comparator.reversed().compare(p1,p2));
    }
}
