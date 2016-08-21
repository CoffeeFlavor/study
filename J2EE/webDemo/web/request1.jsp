<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取请求头/请求参数</title>
</head>
<body>
<%
    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        out.println(headerName + "-->" + request.getHeader(headerName) + "<br>");
    }
    out.println("<hr/>");
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String[] color = request.getParameterValues("color");
    String national = request.getParameter("country");
%>
你的名字：<%=name%>
<hr/>
你的性别：<%=gender%>
<hr/>
你喜欢的颜色：
<%
    for (String c : color) {
        out.println(c+" ");
    }
%><hr/>
你来自的国家：<%=national%><hr/>
</body>
</html>
