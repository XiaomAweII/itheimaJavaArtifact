package com.maxiaowei.d3_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE}) // 声明注解的范围
@Retention(RetentionPolicy.RUNTIME) // 这个注解始终活着
public @interface MyTest3 {
}
