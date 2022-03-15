package com.yangbo.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author: yangbo
 * @Date: 2022-03-15-17:23
 * @Description:  加入状态内容处理  404  505
 */
public class Dispatcher1 implements Runnable{

    private Socket client;
    private Response response;
    private Request request1;
    public Dispatcher1(Socket client){
        this.client = client;
        try {
            //封装请求和响应
            this.request1 = new Request(client);
            this.response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
    }

    @Override
    public void run() {
        try {
            if(request1.getUrl()==null){
                InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
                response.println(new String(inputStream.readAllBytes()));
                response.pushToBrowser(200);
                inputStream.close();
                return;
            }
            Servlet servlet = WebApp.getServlet(request1.getUrl());

            if (servlet != null) {
                servlet.service(request1, response);
                //关注了状态码
                response.pushToBrowser(200);
            } else {
                //错误  在多线程里面，通过类加载器，定位资源
                InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
                response.println(new String(inputStream.readAllBytes()));
                inputStream.close();
                response.pushToBrowser(404);
            }
        }catch (Exception e){
            try {
                response.println("你好，我不好，我会马上好");
                response.pushToBrowser(500);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        release();
    }

    //释放资源
    private void release(){
        try {
            client.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
