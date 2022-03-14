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
 * @Description:  使用ServerSocket建立与浏览器的连接，获取请求协议
 */
public class Server02 {
    //定义成员变量
    private ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        Server02 server02 = new Server02();
        server02.start();
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
        byte[] datas = new byte[1024*10240];
        int len = inputStream.read(datas);
        String requestInfo = new String(datas,0,len);
        System.out.println(requestInfo);

        /*
        * 下面是对浏览器的返回  response
        * 分为 响应内容和响应响应头信息
        *
        * */
        //响应内容，放到stringBuffer
        StringBuilder content = new StringBuilder();
        content.append("<html>");
        content.append("<head>");
        content.append("<title>");
        content.append("服务器响应成功");
        content.append("</title>");
        content.append("</head>");
        content.append("<body>");
        content.append("yang的服务器响应成功了");
        content.append("hello ,my name is tanZHUZHU");
        content.append("</body>");
        content.append("</html>");
        int size = content.toString().getBytes().length;

        //获取响应头信息，存到stringBuilder里面
        StringBuilder responseInfo = new StringBuilder();
        String blank = " ";
        String CRLF = "\r\n";

        //返回
        //返回响应协议
        //1.响应行： HTTP/1.1 200 OK
        responseInfo.append("HTTP/1.1").append(blank);
        responseInfo.append(200).append(blank);
        responseInfo.append("OK").append(CRLF);
        /**
         * 2.响应头：
         * Date:Mon,31Dec209904:25:57GMT
         * Server:shsxt Server/0.0.1;charset=GBK
         * Content-type:text/html
         * Content-length:39725426
         */
        responseInfo.append("Date:").append(new Date()).append(CRLF);
        responseInfo.append("Server:").append("Server/0.0.1;charset=GBK").append(CRLF);
        responseInfo.append("Content-type:").append(CRLF);
        responseInfo.append("Content-length:").append(size).append(CRLF);
        responseInfo.append(CRLF);
        //3.正文 （空行）
        responseInfo.append(content.toString());

        //写到客户端
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        bw.write(responseInfo.toString());
        bw.flush();

    }

    //停止服务
    public void stop(){

    }
}
