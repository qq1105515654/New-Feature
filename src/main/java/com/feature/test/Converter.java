package com.feature.test;

/**
 * @author snh
 * @version 1.0
 * @className Converter
 * @description TODO 自定义 Lambda 表达式接口
 * @date 2019/11/1 9:46
 **/
@FunctionalInterface
public interface Converter<F,T> {

    /**
     * 类型转换
     * @param from
     * @return
     */
    T convert(F from);

}
