package com.yangbo.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: yangbo
 * @Date: 2022-03-14-9:43
 * @Description:  处理 404  505  首页 等问题
 */
public class Server {
    //定义成员变量
    private ServerSocket serverSocket;
    private boolean isRunning;

    public static void main(String[] args) throws Exception {
        Server server04 = new Server();
        server04.start();
    }

    //启动服务
    public void start(){
        try {
            //本地服务器监听端口
            serverSocket = new ServerSocket(8888);
            isRunning = true;
            receive();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("服务器启动失败");
            stop();
        }
    }

    //获取客户端内容,接受连接处理
    public void receive() throws Exception {
        while (isRunning){
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接");

                //多线程处理
                new Thread(new Dispatcher1(client)).start();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("客户端错误");
            }
        }
    }

    //停止服务
    public void stop(){
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器已停止");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
