<%@ page import="lee.Person" %>
<%@ page contentType="text/html;charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
    <title>java bean 测试</title>
</head>
<body>
<%--<jsp:useBean  class="lee.Person"  scope="page" id="pl" />--%>
<%--<jsp:setProperty name="pl" property="name" value="crazyyit.org"/>--%>
<%--<jsp:setProperty name="pl" property="age" value="23"/>--%>
<%--<jsp:getProperty name="pl" property="name"/>--%>
<%--<br/>--%>
<%--<jsp:getProperty name="pl" property="age"/>--%>
<%
    Person p1 = new Person();
    pageContext.setAttribute("p1",p1);
    p1.setName("wawa");
    p1.setAge(23);
%>
<%=p1.getName()%>
<%=p1.getAge()%>
</body>
</html>
