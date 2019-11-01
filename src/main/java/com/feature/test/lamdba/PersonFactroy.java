package com.feature.test.lamdba;

/**
 * @author snh
 * @version 1.0
 * @className PersonFactroy
 * @description TODO
 * @date 2019/11/1 14:18
 **/
public interface PersonFactroy<P extends Person> {
    /**
     * 创建实例
     * @param firstName
     * @param lastName
     * @return
     */
    P create(String firstName,String lastName);
}
