package lee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@WebServlet(urlPatterns="/async",asyncSupported=true)
public class AsyncServlet extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest request
			, HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.println("<title>异步调用示例</title>");
		out.println("进入Servlet的时间："
				+ new java.util.Date() + ".<br/>");
		// 创建AsyncContext，开始异步调用
		AsyncContext actx = request.startAsync();
		// 设置异步调用的超时时长
		actx.addListener(new MyAsyncListener());
		actx.setTimeout(60 * 1000);
		// 启动异步调用的线程，该线程以异步方式执行
		actx.start(new GetBooksTarget(actx));
		out.println("结束Servlet的时间："
				+ new java.util.Date() + ".<br/>");
		out.flush();
	}
}
