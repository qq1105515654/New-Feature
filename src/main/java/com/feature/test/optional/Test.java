package com.feature.test.optional;

import java.util.Optional;

/**
 * @author snh
 * @version 1.0
 * @className Test
 * @description TODO Optional 接口测试
 * @date 2019/11/1 15:08
 **/
public class Test {

    public static void main(String[] args) {

        Optional<String> optional=Optional.of("opt");
        //true
        System.out.println(optional.isPresent());
        // "opt"
        System.out.println(optional.get());
        // 如果 optional 中的值为null，则返回 "fallback",不为 null 返回自己
        System.out.println(optional.orElse("fallback"));

        Optional<String> opt=Optional.empty();
        //"fallback"
        System.out.println(opt.orElse("fallback"));

        // "o"
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }
}
