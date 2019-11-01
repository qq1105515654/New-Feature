package com.feature.test;

import com.feature.test.lamdba.Person;
import com.feature.test.lamdba.PersonFactroy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author snh
 * @version 1.0
 * @className Test
 * @description TODO
 * @date 2019/11/1 9:31
 **/
public class Test {


    public static void main(String[] args) {

        InterfaceNewFeature feature=new InterfaceNewFeature() {
            @Override
            public double calculate(int i) {
                return sqrt(i);
            }
        };
        System.out.println(feature.calculate(10));

        List<String> names=new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");

        //lambda 表达式排序第一种写法
        Collections.sort(names,(a,b)->{
            return a.compareTo(b);
        });
        //第二种写法
        Collections.sort(names,(String a,String b) -> a.compareTo(b));

        //第三种写法 自动推导类型
        Collections.sort(names,(a,b) -> b.compareTo(a));


        Converter<String,Integer> converter=(from -> Integer.valueOf(from));
        Converter<String,Integer> converter1=(from) ->Integer.valueOf(from);
        Converter<String,Integer> converter2=Integer::valueOf;
        int convert=converter.convert("123");
        System.out.println(convert);
        System.out.println(converter1.convert("789"));
        System.out.println(converter2.convert("456"));

        PersonFactroy<Person> factroy=Person::new;
        Person person=factroy.create("诸葛","孔明");
        System.out.println(person);


        //在Lambda 表达式之中使用了 num变量之后，不能在后面改变 num的值，否则编译通不过
        //在lambda 中使用的本地变量必须是最终变量，或这是实际上的最终变量,隐式的使用final修饰了变量
        // final int num=2
        int num=2;
        Converter<Integer,String> stringConverter=(from) -> String.valueOf(from+num);
        System.out.println(stringConverter.convert(10));




    }


}
