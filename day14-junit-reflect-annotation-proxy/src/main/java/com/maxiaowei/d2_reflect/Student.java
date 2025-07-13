package com.maxiaowei.d2_reflect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private String name;
    private int age;
    private char sex;
    private double height;
    private String hobby;

    public Student(String name, int age, char sex, double height, String hobby) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.hobby = hobby;
    }
}
