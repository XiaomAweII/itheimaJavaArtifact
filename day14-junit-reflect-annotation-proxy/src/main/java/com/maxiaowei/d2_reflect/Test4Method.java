package com.maxiaowei.d2_reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 目标：掌握获取类的成员方法，并对其进行操作。
 */
public class Test4Method {
    @Test
    public void testGetMethods() throws Exception {
        //  1、反射第一步：先得到Class对象。
        Class c = Cat.class;
        // 2、获取类的全部成员方法。
        Method[] methods = c.getDeclaredMethods();
        // 3、遍历这个数组中的每个方法对象
        for (Method method : methods) {
            System.out.println(method.getName() + " " + method.getParameterCount());
        }

        // 4、定位单个方法
        Method eat1 = c.getDeclaredMethod("eat");
        Method eat2 = c.getDeclaredMethod("eat", String.class);

        // 5、定位方法的目的是：依然是执行它！
        Cat cat = new Cat();
        Object result = eat1.invoke(cat);
        System.out.println(result);

        eat2.setAccessible(true);
        Object result2 = eat2.invoke(cat, "鱼儿");
        System.out.println(result2);
    }
}
