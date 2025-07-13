package com.d7_tcp4;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server1 {
    public static List<Socket> allSockets = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("==服务端启动===");
            // 目标：掌握TCP通信服务端的开发。
            // 1、注册端口
            ServerSocket serverSocket = new ServerSocket(9999);

            while (true) {
                // 2、阻塞等待客户端的socket链接请求
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress() + " ==> 上线了~~~");
                allSockets.add(socket);
                // 3、把这个客户端管道交给一个独立的子线程来处理。
                new ServerReaderThread(socket).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
