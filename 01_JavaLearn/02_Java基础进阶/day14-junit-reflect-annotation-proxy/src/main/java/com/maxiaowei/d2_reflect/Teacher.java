package com.maxiaowei.d2_reflect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Teacher {
    private String name;
    private double salary;

    public Teacher(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
