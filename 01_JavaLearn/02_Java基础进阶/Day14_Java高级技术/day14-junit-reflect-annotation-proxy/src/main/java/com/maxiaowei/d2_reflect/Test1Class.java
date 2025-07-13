package com.maxiaowei.d2_reflect;

/**
 * 目标：获取Class对象。
 */
public class Test1Class {
    public static void main(String[] args) throws Exception {
        // 目标：反射第一步：获取Class对象。
        // 1、方式一：类名.class
        Class c1 = Student.class;
        System.out.println("c1 = " + c1);

        // 2、方式二：Class.forName(全类名)
        Class c2 = Class.forName("com.maxiaowei.d2_reflect.Student");
        System.out.println("c2 = " + c2);

        // 3、对象.getClass();
        Student s1 = new Student();
        Class c3 = s1.getClass(); // 继承自Object的getClass方法
        System.out.println("c3 = " + c3);

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);
    }
}
