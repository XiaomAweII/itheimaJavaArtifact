package com.d6_tcp3;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * 服务端读数据的线程
 */
public class ServerReaderThread extends Thread{
    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
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
            System.out.println(socket.getInetAddress().getHostAddress() + " ==> 下线了~~~");
        }
    }
}
