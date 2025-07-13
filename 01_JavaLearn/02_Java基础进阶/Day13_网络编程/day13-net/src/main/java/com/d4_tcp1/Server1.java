package com.d4_tcp1;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws Exception {
        System.out.println("==服务端启动===");
        // 目标：掌握TCP通信服务端的开发。
        // 1、注册端口
        ServerSocket serverSocket = new ServerSocket(9999);

        // 2、阻塞等待客户端的socket链接请求
        Socket socket = serverSocket.accept();

        // 3、从通信管道socket中得到一个字节输入流
        InputStream is = socket.getInputStream();

        // 4、把字节输入流包装成特殊数据输入流
        DataInputStream dis = new DataInputStream(is);

        // 5、收数据
        System.out.println("收到1：" + dis.readInt());
        System.out.println("收到2：" + dis.readUTF());

        // 6、释放资源
        socket.close();
    }
}
