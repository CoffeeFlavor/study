<%@ page import="javax.naming.Context" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    try {
    Context ctx = new InitialContext();
    DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dstest");
    Connection conn = ds.getConnection();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from member ");
        while (rs.next()) {
           out.print(rs.getString(1) + "\t" + rs.getString(2) + "<br/>");
        }
    }catch (Exception e){
        e.printStackTrace();
    }
%>
</body>
</html>
