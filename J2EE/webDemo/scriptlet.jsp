<%@ page contentType="text/html;charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
	<title>欢迎</title>
</head>
<body>
<!-- Java 脚本，这些脚本对html的标签产生作用 -->
<table bgcolor="#9999dd" border="1" width="300px">
<%
  for (int i=0;i<10 ;i++ ) {
  	
%>
<!-- 上面的循环将控制<tr> 标签循环 -->
        <tr>
          <td>循环值</td>
          <td><%=i%><td>
        </tr>
<%}%>
</table>
</body>
</html>