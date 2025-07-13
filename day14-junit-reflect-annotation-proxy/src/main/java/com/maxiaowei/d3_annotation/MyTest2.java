package com.maxiaowei.d3_annotation;

public @interface MyTest2 {
    String value();

    int age() default 70;
}
