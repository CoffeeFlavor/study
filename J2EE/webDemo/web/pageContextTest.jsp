<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext 测试</title>
</head>
<body>
<%
    pageContext.setAttribute("page","hello");
    request.setAttribute("request","hello");
    pageContext.setAttribute("request2","hello",PageContext.REQUEST_SCOPE);
    session.setAttribute("session","hello");
    pageContext.setAttribute("session2","hello",PageContext.SESSION_SCOPE);
    application.setAttribute("app","hello");
    pageContext.setAttribute("app2","hello",PageContext.APPLICATION_SCOPE);
    out.println("page 变量所在范围："+pageContext.getAttributesScope("page")+"</br>");
    out.println("request 变量所在范围："+pageContext.getAttributesScope("request")+"</br>");
    out.println("request2 变量所在范围："+pageContext.getAttributesScope("request2")+"</br>");
    out.println("session 变量所在范围："+pageContext.getAttributesScope("session")+"</br>");
    out.println("session2 变量所在范围："+pageContext.getAttributesScope("session2")+"</br>");
    out.println("app 变量所在范围："+pageContext.getAttributesScope("app")+"</br>");
    out.println("app2 变量所在范围："+pageContext.getAttributesScope("app2")+"</br>");
%>
</body>
</html>
