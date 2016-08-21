<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="javax.print.attribute.standard.MediaSize" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out 测试</title>
</head>
<body>

<%
    //注册数据库驱动
    Class.forName("com.mysql.jdbc.Driver");
//获取数据库连接
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/visualtravel","root","root");
//创建statement
    Statement stmt=conn.createStatement();
//执行查询
    ResultSet rs=stmt.executeQuery("select * from resource");
%>
<table bgcolor="#9999dd" border="1" width="400">
<%
  while (rs.next()){

      out.println("<tr>");
      out.println("<td>");
      out.println(rs.getString(1));
      out.println("</td>");
      out.println("<td>");
      out.println(rs.getString(2));
      out.println("</td>");
      out.println("</tr>");
  }
%>
</table>
</body>
</html>
