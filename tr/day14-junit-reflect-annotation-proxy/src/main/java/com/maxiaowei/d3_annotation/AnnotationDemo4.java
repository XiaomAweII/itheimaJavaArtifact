package com.maxiaowei.d3_annotation;

import java.lang.reflect.Method;

public class AnnotationDemo4 {
    // 目标：搞清楚注解的应用场景：标记后，让别人特殊处理。
    public void test1() {
        System.out.println("===========test1=======");
    }

    @TestDlei
    public void test2() {
        System.out.println("===========test2=======");
    }

    public void test3() {
        System.out.println("===========test3=======");
    }

    @TestDlei(2)
    public void test4() {
        System.out.println("===========test4=======");
    }

    public static void main(String[] args) throws Exception {
        AnnotationDemo4 t = new AnnotationDemo4();
        // 有注解的跑他，没有注解的不跑他
        Class c = AnnotationDemo4.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            // 判断这个方法上是否陈列了注解，是就跑
            if (method.isAnnotationPresent(TestDlei.class)) {
                // 跑它
                TestDlei dlei = method.getDeclaredAnnotation(TestDlei.class);
                int count = dlei.value();
                for (int i = 0; i < count; i++) {
                    method.invoke(t);
                }
            }
        }
    }
}
