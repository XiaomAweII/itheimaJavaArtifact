package com.maxiaowei.d3_annotation;

// 自定义注解
public @interface MyTest {
    String name();

    double money() default 100;

    String[] authors();
}
