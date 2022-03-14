package com.yangbo.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Author: yangbo
 * @Date: 2022-03-14-9:43
 * @Description:
 *
 * 目标：封装响应信息
 * 1.内容可以动态添加
 * 2.关注状态码，拼接好协议信息
 */
public class Server03 {
    //定义成员变量
    private ServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        Server03 server03 = new Server03();
        server03.start();
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

        //获取请求协议
        InputStream inputStream = client.getInputStream();
        byte[] datas = new byte[1024*10240];
        int len = inputStream.read(datas);
        String requestInfo = new String(datas,0,len);
        System.out.println(requestInfo);


        Response response = new Response(client);

        //关注了内容
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("The server is ok");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("the server of yang is ok");
        response.print("hello ,my name is tanXiaoZhu");
        response.print("</body>");
        response.print("</html>");

        //关注了状态码
        response.pushToBrowser(200);

    }

    //停止服务
    public void stop(){

    }
}
