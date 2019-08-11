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

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Register</h1>
<form method="post">
    First name: <input type="text" name="firstName"/><br/>
    Last name: <input type="text" name="lastName"/><br/>
    Username: <input type="text" name="username"/><br/>
    Password: <input type="password" name="password"/><br/>
<input type="submit" value="register">
</form>
</body>
</html>
