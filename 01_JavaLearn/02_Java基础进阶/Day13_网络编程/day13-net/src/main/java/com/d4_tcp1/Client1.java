package com.d4_tcp1;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws Exception {
        // 目标：TCP通信客户端开发。 一发一收
        // 1、创建socket管道与服务端建立链接
        Socket socket = new Socket("127.0.0.1", 9999);

        // 2、从socket管道中得到一个字节输出流，往外写数据出去。
        OutputStream os = socket.getOutputStream();

        // 3、把低级流包装成特殊数据输出流
        DataOutputStream dos = new DataOutputStream(os);

        // 4、发数据出去给服务端
        dos.writeInt(12);
        dos.writeUTF("服务端您好，我是骚气的客户端，请问约吗？6666~~~~");
        dos.flush();

        // 5、释放资源
        socket.close();
    }
}
