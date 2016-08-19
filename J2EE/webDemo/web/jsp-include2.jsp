<%@ page contentType="text/html;charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
	<title>include测试</title>
</head>
<body>
	<!-- 错误提醒页面 -->
<jsp:include page="forward-result.jsp">
<jsp:param name="age" value="32"/>
</jsp:include>
</body>
</html>
