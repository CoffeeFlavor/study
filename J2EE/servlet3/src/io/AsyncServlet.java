package io;


import lee.MyAsyncListener;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * User: jennie
 * Date: 2016/9/27
 * Time: 17:33
 */
@WebServlet(urlPatterns = "/io/async",asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=GBK");
        PrintWriter out=res.getWriter();
        out.println("<title>非阻塞IO示例</title>");
        out.println("进入Servlet的时间"+new Date()+".<br/>");
        AsyncContext context=req.startAsync();
        context.setTimeout(60*1000);
        ServletInputStream inputStream=req.getInputStream();
        inputStream.setReadListener(new MyReadListener(inputStream,context));
        out.println("结束servlet时间："+new Date()+".</br>");
        out.flush();
    }
}
