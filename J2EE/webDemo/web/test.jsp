<%@ page contentType="text/html;charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
	<title>欢迎</title>
</head>
<body>
<%
  for (int i=0;i<7 ;i++) {
  	out.println("<font size='"+i+"'>");
%>
疯狂java训练营（Wild Java Camp）</font>
<br/>
<%}%>
</body>
</html>