package online.lee;

import lee.DbDao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * User: jennie
 * Date: 2016/9/22
 * Time: 10:51
 */
@WebListener
public class OnlineListener implements ServletContextListener{

    public final int MAX_MILLIS=60*1000;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/online_inf", "root", "root");
                    ResultSet rs=dd.query("select*from online_inf");
                    StringBuffer beRemove=new StringBuffer().append("(");
                    while (rs.next()){
                        if (System.currentTimeMillis()-rs.getLong(5)>MAX_MILLIS){
//                            rs.deleteRow();
                            beRemove.append("'").append(rs.getString(1)).append("',");
                        }
                    }
                    if (beRemove.length()>3){
                        beRemove.setLength(beRemove.length()-1);
                        beRemove.append(")");
                        dd.modify("delete from online_inf where session_id in "+beRemove);
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
