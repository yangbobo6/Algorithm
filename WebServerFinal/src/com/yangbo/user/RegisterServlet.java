package com.yangbo.user;

import com.yangbo.server.Request;
import com.yangbo.server.Response;
import com.yangbo.server.Servlet;

/**
 * @Author: yangbo
 * @Date: 2022-03-14-8:35
 * @Description:
 */
public class RegisterServlet implements Servlet {

    @Override
    public void service(Request request1, Response response) {
        //关注了内容
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("register");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("register page");
        response.print("</body>");
        response.print("</html>");
    }
}
