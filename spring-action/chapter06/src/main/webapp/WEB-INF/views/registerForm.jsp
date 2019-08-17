<%--
  Created by IntelliJ IDEA.
  User: Seven Year
  Date: 2019/8/10
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <style type="text/css">
        span.error{
            color: red;
        }
        div.errors{
            background-color: #ffcccc;
            border: 2px solid red;
        }
        label.error{
            color: red;
        }
        input.error{
            background-color: #ffcccc;
        }
    </style>
</head>
<body>
<h1>Register</h1>
<sf:form method="post" modelAttribute="spittle">
    <sf:errors path="*" element="div" cssClass="errors"/>
   <sf:label path="firstName" cssErrorClass="error"> First name:</sf:label> <sf:input path="firstName" cssErrorClass="error"/>
    <br/>
    Last name: <sf:input path="lastName"/><br/>
    Username: <sf:input path="username"/><br/>
    Password: <sf:password path="password"/><br/>
    <input type="submit" value="register">
</sf:form>
<%--<form method="post">--%>
<%--First name: <input type="text" name="firstName"/><br/>--%>
<%--Last name: <input type="text" name="lastName"/><br/>--%>
<%--Username: <input type="text" name="username"/><br/>--%>
<%--Password: <input type="password" name="password"/><br/>--%>
<%--<input type="submit" value="register">--%>
<%--</form>--%>
</body>
</html>
