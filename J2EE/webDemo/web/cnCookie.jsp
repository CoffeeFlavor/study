<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie c=new Cookie("cnName", URLEncoder.encode("黄英","utf-8"));
    c.setMaxAge(24*3600);
    response.addCookie(c);

    Cookie[] cookies=request.getCookies();
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("cnName")) {
            out.println(URLDecoder.decode(cookie.getValue(),"utf-8"));
        }
    }
%>
</body>
</html>
