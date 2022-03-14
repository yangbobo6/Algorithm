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

    public Request(InputStream in){
        byte[] bytes = new byte[1024*10240];
        int len;
        try{
            len = in.read();
            String requestInfo = new String(bytes,0,len);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Request(Socket socket) throws IOException {
        this(socket.getInputStream());
    }


}
