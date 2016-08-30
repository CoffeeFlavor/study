<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies=request.getCookies();
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("username")) {
            out.println(cookie.getValue());
        }
    }
%>
</body>
</html>
