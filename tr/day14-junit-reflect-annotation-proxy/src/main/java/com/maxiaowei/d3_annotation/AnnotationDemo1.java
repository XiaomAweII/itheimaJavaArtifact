package com.maxiaowei.d3_annotation;

@MyTest(name = "从入门到跑路", money = 9.9, authors = {"阿猫", "阿狗"})
//@MyTest2(value = "删除")
//@MyTest2(value = "删除", age = 23)
@MyTest2("删除")
public class AnnotationDemo1 {

    @MyTest(name = "从入门到跑路2", authors = {"阿猫2", "阿狗2"})
    private String name;

    @MyTest(name = "从入门到跑路", authors = {"阿猫", "阿狗"})
    public static void main(String[] args) {
        // 目标：掌握注解的使用。
        @MyTest(name = "从入门到跑路3", authors = {"阿猫3", "阿狗3"})
        int age = 12;
    }
}
