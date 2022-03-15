package com.yangbo.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: yangbo
 * @Date: 2022-03-14-9:43
 * @Description:
 *
 * 目标：封装响应信息
 * 1.内容可以动态添加
 * 2.关注状态码，拼接好协议信息
 */
public class Server07 {
    //定义成员变量
    private ServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        Server07 server04 = new Server07();
        server04.start();
    }

    //启动服务
    public void start() throws Exception {
        //本地服务器监听端口
        serverSocket = new ServerSocket(8888);
        receive();
    }

    //获取客户端内容,接受连接处理
    public void receive() throws Exception {
        Socket client = serverSocket.accept();
        System.out.println("一个客户端建立了连接");

        //通过request请求协议  封装好了
        Request request1 = new Request(client);
        //通过response回应信息
        Response response = new Response(client);

        Servlet servlet = WebApp.getServlet(request1.getUrl());
        System.out.println("--->"+servlet);
        if(servlet!=null){
            servlet.service(request1,response);
            //关注了状态码
            response.pushToBrowser(200);
        }else {
            //错误
            response.pushToBrowser(404);
        }

    }

    //停止服务
    public void stop(){

    }
}
