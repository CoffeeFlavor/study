package lee;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

/**
 * User: jennie
 * Date: 2016/8/25
 * Time: 21:15
 */
@WebServlet(name ="firstServlet",urlPatterns = {"/firstServlet"})
public class FirstServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("text/html;charset=UTF-8");
        String name=req.getParameter("name");
        String gender=req.getParameter("gender");
        String[] color=req.getParameterValues("color");
        String national=req.getParameter("country");
        PrintStream out=new PrintStream(resp.getOutputStream());
        out.println("<html>");
        out.println("<head>");
        out.println("<title>servlet 测试</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("你的名字："+name+"<hr/>");
        out.println("你的性别："+gender+"<hr/>");
        out.println("你喜欢的颜色：");
        for (String c : color) {
            out.println(c+" ");
        }
        out.println("你喜欢的颜色：");
        out.println("你来自的国家"+national+"<hr/>");
        out.println("</body>");
        out.println("</html>");
    }
}
