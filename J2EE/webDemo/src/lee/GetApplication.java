package lee;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: jennie
 * Date: 2016/8/20
 * Time: 10:06
 */
@WebServlet(name = "get-application",urlPatterns = {"/get-application"})
public class GetApplication extends HttpServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=gb2312");
        PrintWriter out=res.getWriter();
        out.print("<html><head><title>");
        out.print("测试application");
        
    }
}
