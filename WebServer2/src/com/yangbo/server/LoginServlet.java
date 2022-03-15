package com.yangbo.server;

/**
 * @Author: yangbo
 * @Date: 2022-03-14-8:34
 * @Description:
 */
public class LoginServlet implements Servlet{
    @Override
    public void service(Request request1, Response response) {
        //关注了内容
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("login");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("this is login page");
        response.print("hello ,my name is tanXiaoZhu");
        response.print("</body>");
        response.print("</html>");
    }
}
