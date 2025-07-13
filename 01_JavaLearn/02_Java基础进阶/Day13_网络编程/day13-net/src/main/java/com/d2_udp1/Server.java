package com.d2_udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("===服务器启动成功===");
        // 目标：开始开发一个服务端程序。（接收端）
        // 1、创建接收端对象，注册端口（接收端人）
        DatagramSocket socket = new DatagramSocket(8888);

        // 2、创建一个数据包对象（韭菜盘子）
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // 3、接收数据（接收韭菜）
        socket.receive(packet); // 暂停等待！！

        // 4、把数据输出
        // 获取本轮收到多少字节。
        int len = packet.getLength();

        String msg = new String(buffer,0,len);
        System.out.println(msg);

        // 获取发送端的IP和端口!!
        InetAddress ip = packet.getAddress();
        System.out.println("对方ip:" +ip.getHostAddress());
        System.out.println("对方端口:" + packet.getPort());

        // 5、释放资源
        socket.close();
    }
}
