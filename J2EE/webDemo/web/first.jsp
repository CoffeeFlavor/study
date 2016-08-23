<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request处理</title>
</head>
<body>
<%
    pageContext.setAttribute("test","hello",PageContext.SESSION_SCOPE);
    String bal = request.getParameter("balance");
    double qian = Double.parseDouble(bal);
    if (qian < 500) {
        out.println("给你" + qian + "块");
        out.println("账户减少" + qian);
        out.println(pageContext.getAttributesScope("test"));
        out.println(pageContext.getAttribute("test",PageContext.PAGE_SCOPE));
    } else {
        List<String> info = new ArrayList<>();
        info.add("1111111");
        info.add("2222222");
        info.add("3333333");
        request.setAttribute("info", info);
        request.getRequestDispatcher("/second.jsp").forward(request,response);
%>
<%--<jsp:forward page="second.jsp"/>--%>
<%}%>
</body>
</html>
