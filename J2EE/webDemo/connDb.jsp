<%@ page contentType="text/html;charset=utf-8" language="java" errorPage="error.jsp" %>
<%@ page import="java.sql.*" %>
<%@ page info="你妹纸的" %>
<!DOCTYPE html>
<html>
<head>
	<title>欢迎</title>
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
<table bgcolor="#9999dd" border="1" width="300">
<%
 //遍历结果
 while(rs.next())
{%>
<tr>
	<td><%=rs.getString(1)%></td>
	<td><%=rs.getString(2)%></td>
</tr>
<%}%>
</table>
<%=getServletInfo()%>
</body>
</html>
