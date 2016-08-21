<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取请求头/请求参数</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
%>
你的名字：<%=name%>
<hr/>
你的性别：<%=gender%>
<hr/>
</body>
</html>
