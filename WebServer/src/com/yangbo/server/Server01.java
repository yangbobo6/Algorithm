package com.yangbo.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: yangbo
 * @Date: 2022-03-14-9:43
 * @Description:  使用ServerSocket建立与浏览器的连接，获取请求协议
 */
public class Server01 {
    //定义成员变量
    private ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        Server01 server01 = new Server01();
        server01.start();
    }

    //启动服务
    public void start() throws IOException {
        //本地服务器监听端口
        serverSocket = new ServerSocket(8888);
        receive();
    }

    //获取客户端内容,接受连接处理
    public void receive() throws IOException {
        Socket client = serverSocket.accept();
        System.out.println("一个客户端建立了连接");

        //获取请求协议
        InputStream inputStream = client.getInputStream();
        byte[] datas = new byte[1024*1024];
        int len = inputStream.read(datas);
        String requestInfo = new String(datas,0,len);
        System.out.println(requestInfo);

    }

    //停止服务
    public void stop(){

    }
}
