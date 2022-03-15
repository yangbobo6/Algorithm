package com.yangbo.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.List;

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

    Map<String, List<String>> stringListMap;

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
        url = requestInfo.substring(indexStart,endStart).trim();

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

    //字符串已经分解，现在将分解后的字符串放入到 Map里面  name=yang&pwd=123&others=
    public void convertMap(){
        String[] strings = queryStr.split("&");

        for (String s:strings
             ) {
            String[] strings1 = s.split("=");
            //转化为全部都存在
            strings1 = Arrays.copyOf(strings1, 2);

            String kv1 = strings1[0];
            String kv2 = strings1[1]==null?null:decode(strings1[1],"utf-8");

            if(!stringListMap.containsKey(kv1)){
                stringListMap.put(kv1, new ArrayList<>());
            }
            stringListMap.get(kv1).add(kv2);
        }
    }

    //获取map里面值的内容
    public String[] getParameters(String key){
        List<String> values = stringListMap.get(key);
        if(values==null||values.size()==0){
            return null;
        }
        //转换为String[] 数组类型
        return values.toArray(new String[0]);
    }

    //通过key获取一个值
    public String getParameter(String key){
        String[] parameters = getParameters(key);
        return parameters==null?null:parameters[0];
    }

    //处理中文乱码
    private String decode(String value,String enc){
        try {
            return java.net.URLDecoder.decode(value,enc);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }




    //get方法，向外边提供接口
    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getQueryStr() {
        return queryStr;
    }
}
