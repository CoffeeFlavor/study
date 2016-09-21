package lee;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * User: jennie
 * Date: 2016/9/6
 * Time: 20:53
 */
public class GetConnListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            ServletContext application=sce.getServletContext();
            String driver=application.getInitParameter("driver");
            String url =application.getInitParameter("url");
            String user=application.getInitParameter("user");
            String pass=application.getInitParameter("pass");
            Class.forName(driver);
            Connection conn= DriverManager.getConnection(url,user,pass);
            application.setAttribute("conn",conn);
        }catch (Exception e){
            System.out.println("Listener 中获取数据库连接出现异常"+e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        ServletContext application=sce.getServletContext();
        Connection conn=(Connection) application.getAttribute("conn");
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
