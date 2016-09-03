package lee;

import com.mysql.jdbc.NotUpdatable;

import javax.print.attribute.standard.MediaSize;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;

/**
 * User: jennie
 * Date: 2016/8/31
 * Time: 21:05
 */
public class QueryTag extends SimpleTagSupport {

    private String driver;
    private String url;
    private String user;
    private String pass;
    private String sql;

    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private ResultSetMetaData rsmd=null;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public ResultSetMetaData getRsmd() {
        return rsmd;
    }

    public void setRsmd(ResultSetMetaData rsmd) {
        this.rsmd = rsmd;
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            rsmd=rs.getMetaData();
            int colomnCount=rsmd.getColumnCount();
            Writer out=getJspContext().getOut();
            out.write("<table border=1 bgColor='#9999cc' width=400> ");
            while (rs.next()){
                out.write("<tr>");
                for (int i=1;i<=colomnCount;i++){
                    out.write("<td>");
                    out.write(rs.getString(i));
                    out.write("</td>");
                }
                out.write("</tr>");
            }
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            throw new JspException("自定义标签错误"+cnfe.getMessage());
        }catch (SQLException e){
            e.printStackTrace();
            throw new JspException("自定义标签错误"+e.getMessage());
        }finally {
            try {
                if (rs!= null){
                    rs.close();
                }
                if (stmt!= null){
                    stmt.close();
                }
                if (conn!= null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
