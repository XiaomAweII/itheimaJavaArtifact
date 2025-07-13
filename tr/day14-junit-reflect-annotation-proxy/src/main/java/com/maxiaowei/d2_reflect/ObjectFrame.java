package com.maxiaowei.d2_reflect;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class ObjectFrame {
    // 目标：保存任意对象的字段和其数据到文件中去
    public static void saveObject(Object obj) throws Exception {
        // 但是这个对象中有多少个字段，我们不清楚的，谁清楚呢？？ 只有反射可以解决。
        PrintWriter pw = new PrintWriter(new FileWriter("day14-junit-reflect-annotation-proxy/src/obj.txt", true));
        Class c = obj.getClass();
        // 0.还得知道是啥对象。
        // String className = c.getName(); // com.itheima....Student
        String className = c.getSimpleName(); // Student
        pw.println("==================" + className + "====================");

        // 1、提取这个Class对象中的全部字段
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            field.setAccessible(true);
            String value = field.get(obj) + "";
            pw.println(name + "=" + value);
        }
        pw.close();
    }
}
