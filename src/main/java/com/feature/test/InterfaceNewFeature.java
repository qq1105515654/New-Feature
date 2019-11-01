package com.feature.test;

/**
 * @author snh
 * @version 1.0
 * @className InterfaceNewFeature
 * @description TODO JDK1.8 接口新特性
 * @date 2019/11/1 9:18
 **/
public interface InterfaceNewFeature {

    double calculate(int i);


    default double sqrt(int i){
        return Math.sqrt(i);
    }

}
