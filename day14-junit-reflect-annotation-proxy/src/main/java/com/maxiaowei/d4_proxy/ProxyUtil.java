package com.maxiaowei.d4_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    // 为实现类对象创建代理对象，并返回。
    public static Star createProxy(SuperStar zrn) {
        /**
         * 参数一：类加载器，加载底层代理类。
         * 参数二：代理也需要实现的接口。
         * 参数三：代理要做的事情。
         */
        Star proxy = (Star) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                zrn.getClass().getInterfaces(), new InvocationHandler() {
                    //
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 代理要做的事情，在这里实现。
                        //  proxy 代理对象本身，一般我们不用！
                        //  method:正在代理的方法，哪个方法调用invoke，method就代表哪个方法
                        //  args : 正在被代理的方法参数
                        if ("sing".equals(method.getName())) {
                            System.out.println("准备话筒，收钱20万！");
                        } else if ("dance".equals(method.getName())) {
                            System.out.println("准备场地，收钱300万！");
                        }
                        // 其他的行为都是真实明星对象自己去做！
                        Object result = method.invoke(zrn, args);
                        return result;
                    }
                });
        return proxy;
    }
}
