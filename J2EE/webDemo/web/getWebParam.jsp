<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: CoffeeFlavor
  Date: 2016/8/20
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application测试</title>
</head>
<body>
<%
    String driver=application.getInitParameter("driver");
    String url=application.getInitParameter("url");
    String user=application.getInitParameter("user");
    String pass=application.getInitParameter("pass");
    Class.forName(driver);
    Connection conn= DriverManager.getConnection(url);
    Statement stmt=conn.createStatement();
    ResultSet rs=stmt.executeQuery("SELECT * FROM resource");
%>
  <table bgcolor="#9999dd" border="1" width="480">
      <%
          while (rs.next()){
      %>
      <tr>
          <td><%=rs.getString(1)%>/td>
          <td><%=rs.getString(2)%>/td>
      </tr>
      <%}%>
  </table>
</body>
</html>
