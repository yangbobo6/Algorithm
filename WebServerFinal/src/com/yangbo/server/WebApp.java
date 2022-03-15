package com.yangbo.server;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @Author: yangbo
 * @Date: 2022-03-15-11:32
 * @Description:
 */
public class WebApp {
    private static WebContext context = null;
    static {
        //sax解析
        //1.获取解析工厂
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //2.从解析工厂中获取解析器
            SAXParser parse = null;
            parse = factory.newSAXParser();
            //3.加载文档 Document注册解析器
            //4.编写处理器
            WebHandler handler = new WebHandler();

            //5.解析  当前线程的类加载器
            parse.parse(Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("web.xml"),handler);
            //获取数据  在WebContext 构造方法中，有访问的跟路径，定位到类名称
            context = new WebContext(handler.getEntities(),handler.getMappings());


        } catch (Exception e){
            System.out.println("解析配置文件错误");
        }
    }


    //通过url  以反射方式  获取配置文件对应的servlet
    public static Servlet getServlet(String url){
        //假设输入 /login
        String className = context.getClz("/"+url);
        System.out.println(className);

        Class clz;
        try {
            clz = Class.forName(className);
            Servlet servlet = (Servlet) clz.getConstructor().newInstance();
            return servlet;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
