package com.maxiaowei.d3_annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationDemo3 {
    // 测试方法：公开的，无参数的，无返回值的
    @Test
    public void parseClass() {
        // 目标：注解的解析。
        Class c = Demo.class;
        // 1、判断类上面是否陈列了该注解
        if (c.isAnnotationPresent(MyTest4.class)) {
            // 2、得到这个注解对象
            MyTest4 myTest4 = (MyTest4) c.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.value());
            System.out.println(myTest4.aaa());
            System.out.println(Arrays.toString(myTest4.bbb()));
        }
    }

    @Test
    public void parseMethod() throws Exception {
        // 目标：注解的解析。
        Class c = Demo.class;
        Method method = c.getDeclaredMethod("test1");
        // 1、判断方法上面是否陈列了该注解
        if (method.isAnnotationPresent(MyTest4.class)) {
            // 2、得到这个注解对象
            MyTest4 myTest4 = (MyTest4) method.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.value());
            System.out.println(myTest4.aaa());
            System.out.println(Arrays.toString(myTest4.bbb()));
        }
    }
}

@MyTest4(value = "Java入门", bbb = {"dlei", "黑马"})
class Demo {
    @MyTest4(value = "色即是空", aaa = 999, bbb = {"心经", "空即是色", "受想行识亦复如是"})
    public void test1() {
    }
}