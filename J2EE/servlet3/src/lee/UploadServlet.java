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

@WebServlet(name="upload" , urlPatterns={"/upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
						HttpServletResponse response)
			throws IOException , ServletException
	{
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("GBK");
		// 获取普通请求参数
		String name = request.getParameter("name");
		out.println("普通的name参数为：" + name + "<br/>");
		// 获取文件上传域
		Part part = request.getPart("file");
		// 获取上传文件的文件类型
		out.println("上传文件的的类型为："
				+ part.getContentType() + "<br/>");
		//获取上传文件的大小。
		out.println("上传文件的的大小为：" + part.getSize()  + "<br/>");
		// 获取该文件上传域的Header Name
		Collection<String> headerNames = part.getHeaderNames();
		// 遍历文件上传域的Header Name、Value
		for (String headerName : headerNames)
		{
			out.println(headerName + "--->"
					+ part.getHeader(headerName) + "<br/>");
		}
		// 获取包含原始文件名的字符串
		String fileNameInfo = part.getHeader("content-disposition");
		// 提取上传文件的原始文件名
		String fileName = fileNameInfo.substring(
				fileNameInfo.indexOf("filename=\"") + 10 , fileNameInfo.length() - 1);
		// 将上传的文件写入服务器
		part.write(getServletContext().getRealPath("/uploadFiles")
				+ "/" + fileName );               // ①
	}
}