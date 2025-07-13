package com.d1_inetAddress;

import java.net.InetAddress;

public class InetAddressDemo1 {
    public static void main(String[] args) throws Exception {
        // 目标：InetAddress类代表IP地址对象，用来操作IP地址。
        // 1、获取本机IP地址对象
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());

        // 2、指定获取对方主机的IP地址对象
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostAddress());
        System.out.println(ip2.getHostName());

        // 3、判断本机与该主机是否能够联通：ping
        System.out.println(ip2.isReachable(5000));
    }
}
