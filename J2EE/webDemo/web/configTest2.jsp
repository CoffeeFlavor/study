
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试config内置对象</title>
</head>
<body>
name 配置参数的值:<%=config.getInitParameter("name")%>
<br/>
age 配置参数的值：<%=config.getInitParameter("age")%>
</body>
</html>
