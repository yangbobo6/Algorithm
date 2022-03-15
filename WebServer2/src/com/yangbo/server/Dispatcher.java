package com.yangbo.server;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author: yangbo
 * @Date: 2022-03-15-17:23
 * @Description:
 */
public class Dispatcher implements Runnable{

    private Socket client;
    private Response response;
    private Request request1;
    public Dispatcher(Socket client){
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
            Servlet servlet = WebApp.getServlet(request1.getUrl());

            if (servlet != null) {
                servlet.service(request1, response);
                //关注了状态码
                response.pushToBrowser(200);
            } else {
                //错误
                response.pushToBrowser(404);
            }
        }catch (Exception e){
            try {
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
