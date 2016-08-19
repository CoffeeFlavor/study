<%@ page contentType="text/html;charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
	<title>forward的原始页</title>
</head>
<body>
  <h3>forward的原始页</h3>
  <jsp:forward page="forward-result.jsp">
  <jsp:param name="age" value="29"/>
  </jsp:forward>
</body>
</html>