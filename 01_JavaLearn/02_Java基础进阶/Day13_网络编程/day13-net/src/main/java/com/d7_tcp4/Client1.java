package com.d7_tcp4;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws Exception {
        // 目标：TCP通信客户端开发。 一发多收 群聊
        // 1、创建socket管道与服务端建立链接
        Socket socket = new Socket("127.0.0.1", 9999);
        // 客户端上线后，马上找个线程负责读取他的消息
        new ClientReaderThread(socket).start();

        // 2、从socket管道中得到一个字节输出流，往外写数据出去。
        OutputStream os = socket.getOutputStream();

        // 3、把低级流包装成特殊数据输出流
        DataOutputStream dos = new DataOutputStream(os);

        Scanner sc = new Scanner(System.in);
        while (true) {
            // 4、发数据出去给服务端
            System.out.println("请说：");
            String msg = sc.nextLine();

            if("exit".equals(msg)){
                System.out.println("退出成功！");
                socket.close();
                break;
            }

            dos.writeUTF(msg);
            dos.flush();
        }
    }
}
