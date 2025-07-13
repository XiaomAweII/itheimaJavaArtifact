package com.d2_udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 需求：一发 一收。
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 目标：客户端实现(发送端)
        // 1、创建发送端对象（抛韭菜的人）
        DatagramSocket socket = new DatagramSocket(); // 默认会分配端口

        // 2、创建一个数据包对象，负责封装要发送的数据。（盘子）
        /**
         * 参数一：要发送的数据，字节数组
         * 参数二：发送的数据大小
         * 参数三：目的地IP地址
         * 参数四：接收端端口号
         */
        byte[] buffer = "今晚一起啤酒、龙虾、小烧烤，约吗？？".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(),
               8888); // 盘子

        // 3、把这一包数据发出去（抛出去韭菜）
        socket.send(packet);

        // 4、释放资源
        socket.close();

        System.out.println("客户端已经发送完毕！");
    }
}
