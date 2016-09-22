package online.lee;

import lee.DbDao;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

/**
 * User: jennie
 * Date: 2016/9/22
 * Time: 10:25
 */
@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    //当用户到达时，被初始化时被处发
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String ip = request.getRemoteAddr();
        String page = request.getRequestURI();
        String user = (String) session.getAttribute("user");
        user = user == null ? "游客" : user;
        try {
            DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/online_inf", "root", "root");
            ResultSet rs =dd.query("select * from online_inf where session_id=?",sessionId);
            if (rs.next()){
                rs.updateString(4,page);
                rs.updateLong(5,System.currentTimeMillis());
                rs.updateRow();
                rs.close();
            }else {
                dd.insert("insert into online_inf values(?,?,?,?,?)",sessionId,user,ip,page,System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
