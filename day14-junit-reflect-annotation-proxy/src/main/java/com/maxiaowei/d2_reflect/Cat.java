package com.maxiaowei.d2_reflect;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cat {
    public static int a;
    public static final String COUNTRY = "中国";
    private String name;
    private int age;

    public Cat() {
        System.out.println("无参数构造器执行了~~");
    }

    private Cat(String name, int age) {
        System.out.println("有参数构造器执行了~~");
        this.name = name;
        this.age = age;
    }

    private void run() {
        System.out.println("🐱跑的贼快~~");
    }

    public void eat() {
        System.out.println("🐱爱吃猫粮~");
    }

    private String eat(String name) {
        return "🐱最爱吃:" + name;
    }

}
