<%@ page import="javax.lang.model.element.Name" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name=request.getParameter("name");
    Cookie cookie=new Cookie("username",name);
    cookie.setMaxAge(24*3600);
    response.addCookie(cookie);
%>
</body>
</html>
