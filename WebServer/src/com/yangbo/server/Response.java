package com.yangbo.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @Author: yangbo
 * @Date: 2022-03-14-11:29
 * @Description:  将response封装起来，这些基本不会变
 */
public class Response {
    private BufferedWriter bw;
    //正文
    private StringBuilder content;
    //协议头（状态行，请求头，回车）
    private StringBuilder headInfo;
    //正文字节数
    private int len;

    private final String blank = " ";
    private final String CRLF = "\r\n";

    private Response(){
        content = new StringBuilder();
        headInfo = new StringBuilder();
        len = 0;
    }
    public Response(Socket client){
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        }catch (IOException e){
            e.printStackTrace();
            headInfo = null;
        }

    }
    public Response(OutputStream os){
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    //动态添加内容
    public Response print(String info){
        content.append(info);
        len+=info.getBytes().length;
        return this;
    }

    public Response println(String info){
        content.append(info).append(CRLF);
        len+=(info+CRLF).getBytes().length;
        return this;
    }

    public void pushToBrowser(int code)throws Exception{
        if(headInfo==null){
            code = 500;
        }
        createHeadInfo(code);
        bw.append(headInfo);
        bw.append(content);
        bw.flush();
    }



    //构建头信息
    private void createHeadInfo(int code){
        headInfo.append("HTTP/1.1").append(blank);
        headInfo.append(code).append(blank);
        switch (code){
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("Not Found").append(CRLF);
                break;
            case 500:
                headInfo.append("Server Error").append(CRLF);
                break;
        }
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("Server/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:").append(CRLF);
        headInfo.append("Content-length:").append(len).append(CRLF);
        headInfo.append(CRLF);
    }





}
