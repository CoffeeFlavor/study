<%@ page contentType="text/html;charset=utf-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<title>错误提醒页面</title>
</head>
<body>
	<!-- 错误提醒页面 -->
	系统出现异常<br/>
    异常类型是：<%=exception.getClass()%><br>
    异常信息是:<%=exception.getMessage()%>

</body>
</html>
