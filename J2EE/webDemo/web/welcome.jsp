<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <title> 欢迎页面 </title>

    <meta name="website" content="http://www.crazyit.org" />

</head>

<body>

<h3>欢迎登录</h3>

<%=session.getAttribute("name")%>,欢迎登录！
</body>
</html>
