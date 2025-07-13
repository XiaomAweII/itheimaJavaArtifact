package com.d7_tcp4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
                String msg = dis.readUTF();
                System.out.println("收到：" + msg);
                System.out.println("谁发的：" + socket.getInetAddress().getHostAddress());
                System.out.println("它的端口：" + socket.getPort());
                System.out.println("------------------------------------------------------");

                // 马上把这个消息分发给当前全部在线的socket
                sendMsgToAll(msg);
            }

        } catch (Exception e) {
            System.out.println(socket.getInetAddress().getHostAddress() + " ==> 下线了~~~");
            Server1.allSockets.remove(socket);
        }
    }

    private void sendMsgToAll(String msg) throws Exception {
        // 遍历全部在线socket，把消息分出去
        for (Socket sk : Server1.allSockets) {
            DataOutputStream dos = new DataOutputStream(sk.getOutputStream());
            dos.writeUTF(socket.getInetAddress().getHostAddress() + "说了：" + msg);
            dos.flush();
        }
    }
}
