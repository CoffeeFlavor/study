<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String bal=request.getParameter("balance");
    double qian=Double.parseDouble(bal);
    List<String> info=(List<String>) request.getAttribute("info");
    for (String temp : info) {
        out.println(temp+"<br/>");
    }
    out.println("取钱"+qian+"块");
    out.println("账户减少"+qian);
%>
<%=pageContext.getAttribute("test",PageContext.SESSION_SCOPE)%>
</body>
</html>
