package com.yangbo.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author: yangbo
 * @Date: 2022-03-14-19:10
 * @Description:
 */
public class Request {
    //请求信息
    private String requestInfo;
    //请求方法
    private String method;
    //请求url
    private String url;
    //请求参数
    private String queryStr;

    String CRLF = "\r\n";

    //构造方法
    public Request(Socket socket) throws IOException {
        this(socket.getInputStream());
    }
    //构造方法
    public Request(InputStream in){
        byte[] bytes = new byte[1024*10240];
        int len;
        try{
            len = in.read(bytes);
            this.requestInfo = new String(bytes,0,len);
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        //分解字符串
        parseRequestInfo();
    }
    //分解字符串   将请求中的字符串  url  name  请求地址  等分解出来
    private void parseRequestInfo(){
        System.out.println("分解----");
        System.out.println(requestInfo);
        //获取GET  POST
        method = requestInfo.substring(0,this.requestInfo.indexOf("/"));
        this.method = method.trim();
        System.out.println(method);

        //获取 url
        int indexStart = this.requestInfo.indexOf("/")+1;
        int endStart = this.requestInfo.indexOf("HTTP/");
        url = requestInfo.substring(indexStart,endStart);

        //获取参数
        int queryId = this.url.indexOf("?");
        if(queryId>=0){
            //转义
            String[] urlArray = this.url.split("\\?");
            this.url = urlArray[0];
            queryStr = urlArray[1];
        }

        System.out.println(url);
        System.out.println(queryStr);

        if(method.equals("POST")){
            String qStr = requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if(queryStr==null){
                queryStr = qStr;
            }else {
                queryStr += "&"+qStr;
            }
        }
        queryStr = queryStr==null?"":queryStr;


    }

}
