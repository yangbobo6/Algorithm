package com.yangbo.server;

/**
 * @Author: yangbo
 * @Date: 2022-03-15-15:59
 * @Description:
 */
public class OtherServlet implements Servlet{

    @Override
    public void service(Request request1, Response response) {
        response.print("other pages");
    }
}
