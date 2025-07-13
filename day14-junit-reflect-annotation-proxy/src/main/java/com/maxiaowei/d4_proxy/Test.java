package com.maxiaowei.d4_proxy;

public class Test {
    public static void main(String[] args) {
        // 目标：动态代理
        // 1、创建一个明星对象
        SuperStar zrn = new SuperStar("章若楠");

        // 2、创建章若楠的代理对象，以后找代理唱歌，跳舞。（本节课重点）
        Star proxy = ProxyUtil.createProxy(zrn);
        System.out.println(proxy.sing("好日子"));
        proxy.dance("科目三");
    }
}
