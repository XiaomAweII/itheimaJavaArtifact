package com.d8_bs;

import java.io.PrintStream;
import java.net.Socket;

/**
 * 服务端读数据的线程
 */
public class ServerReaderRunnable implements Runnable{
    private Socket socket;

    public ServerReaderRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println(); // 必须换行
            ps.println("<div style='color:red;font-size:120px;'>牛逼的就业班147期~</div>");
            ps.println("<img src='https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2021%2F0909%2Fa0283b9aj00qz5uda001ic000hs00qoc.jpg&thumbnail=660x2147483647&quality=80&type=jpg' ></img>");
            ps.flush();

            ps.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(socket.getInetAddress().getHostAddress() + " ==> 下线了~~~");
        }
    }
}
