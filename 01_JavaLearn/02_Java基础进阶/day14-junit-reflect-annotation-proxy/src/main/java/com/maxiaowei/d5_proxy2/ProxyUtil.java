package com.maxiaowei.d5_proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static UserService createProxy(UserServiceImpl obj) {
        UserService proxy = (UserService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader()
                , obj.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long startTime = System.currentTimeMillis();

                        // 真正走业务对象的方法
                        Object result = method.invoke(obj, args);

                        long end = System.currentTimeMillis();
                        System.out.println(method.getName() + "方法耗时：" + (end - startTime) / 1000.0);

                        return result;
                    }
                });
        return proxy;
    }
}
