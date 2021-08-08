package com.coding.beautiful.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author : champ
 * @version V1.0
 * @Description:
 * @date 2021年08月08日 15:14
 */
@Data
public class Person {

    private Integer id;
    private String name;
//    1:male, 2 female
    private Integer gender;
    private Integer age;
    private String address;

    public Person(Integer id, String name, Integer gender, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }
}
