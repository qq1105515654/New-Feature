package com.feature.test.lamdba;

import lombok.Data;

/**
 * @author snh
 * @version 1.0
 * @className Person
 * @description TODO
 * @date 2019/11/1 11:57
 **/
@Data
public class Person {

    private String firstName;

    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }
}
