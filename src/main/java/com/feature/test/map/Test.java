package com.feature.test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author snh
 * @version 1.0
 * @className Test
 * @description TODO Map 新的操作方式测试
 * @date 2019/11/1 15:50
 **/
public class Test {

    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>(10);
        //putIfAbsent 表示我们不需要检查这个key 的存在性做额外的检查，如果key存在则不会重复put和更改值
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i,"val"+i);
        }
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i,"val"+(i+1));
        }
        map.forEach((id,val) -> System.out.println(val));

        //val33
        map.computeIfPresent(3,(num,val)-> val+ num);
        System.out.println(map.get(3));
        //false
        map.computeIfPresent(9,(num,val) -> null);
        System.out.println(map.containsKey(9));
        //true
        map.computeIfAbsent(23,num -> "val"+num);
        System.out.println(map.containsKey(23));
        //val33
        map.computeIfAbsent(3,num -> "value");
        System.out.println(map.get(3));


        //val33
        map.remove(3,"val3");
        System.out.println(map.get(3));
        //null
        map.remove(3,"val33");
        System.out.println(map.get(3));
        // not fount
        System.out.println(map.getOrDefault(42,"not fount"));

        //val9
        map.merge(9,"val9",(value,newValue)-> value.concat(newValue));
        System.out.println(map.get(9));
        //val9concat
        map.merge(9,"concat",(value,newValue) -> value.concat(newValue));
        System.out.println(map.get(9));
    }

}
