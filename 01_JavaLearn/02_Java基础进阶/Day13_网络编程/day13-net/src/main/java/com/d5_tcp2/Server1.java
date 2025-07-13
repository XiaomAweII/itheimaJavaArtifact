package com.d5_tcp2;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("==服务端启动===");
            // 目标：掌握TCP通信服务端的开发。
            // 1、注册端口
            ServerSocket serverSocket = new ServerSocket(9999);

            // 2、阻塞等待客户端的socket链接请求
            Socket socket = serverSocket.accept();
            System.out.println("上线了~~~");


            // 3、从通信管道socket中得到一个字节输入流
            InputStream is = socket.getInputStream();

            // 4、把字节输入流包装成特殊数据输入流
            DataInputStream dis = new DataInputStream(is);

            while (true) {
                // 5、收数据
                System.out.println("收到：" + dis.readUTF());
                System.out.println("谁发的：" + socket.getInetAddress().getHostAddress());
                System.out.println("它的端口：" + socket.getPort());
                System.out.println("------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("下线了~~~");
        }
    }
}
