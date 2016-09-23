<%--
  Created by IntelliJ IDEA.
  User: CoffeeFlavor
  Date: 2016/9/23
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表达式语言-内置对象</title>
</head>
<br>
<form action="implicit-objects.jsp" method="post">
    你的名字=<input type="text" name="name" value="${param['name']}">
    <input type="submit" value="提交">
</form></br>
<%
    session.setAttribute("user","abc");
    Cookie c=new Cookie("name","yeeku");
    c.setMaxAge(24*3600);
    response.addCookie(c);
%>
<table border="1" width="660" bgcolor="#aaaadd">
    <tr>
        <td width="170"><b>功能</b></td>
        <td width="200"><b>表达式语言</b></td>
        <td width="300"><b>计算结果</b></td>
    </tr>
    <tr>
        <!--使用两种方式获取请求参数值-->
        <td>取的请求参数值</td>
        <td>\${param.name}</td>
        <td>${param.name}&nbsp;</td>
    </tr>
    <tr>
        <td>取的请求参数值</td>
        <td>\${param['name']}</td>
        <td>${param['name']}&nbsp;</td>
    </tr>
    <tr>
        <!--使用两种方式取的请求头的值-->
        <td>取的请求头的值</td>
        <td>\${header.host}</td>
        <td>${header.host}</td>
    </tr>
    <tr>
        <td>取的请求头的值</td>
        <td>\${header['accept']}</td>
        <td>${header['accept']}</td>
    </tr>
    <!--获取web应用的初始化参数-->
    <tr>
        <td>取得初始化参数值</td>
        <td>\${initParam["author"]}</td>
        <td>${initParam["author"]}</td>
    </tr>
    <!--获取session返回的属性值-->
    <tr>
        <td>取得session返回的属性值</td>
        <td>\${sessionScope['user']}</td>
        <td>${sessionScope['user']}</td>
    </tr>
    <!--获取指定cookie的值-->
    <tr>
        <td>取得指定cookie的值</td>
        <td>\${cookie["name"].value}</td>
        <td>${cookie["name"].value}</td>
    </tr>
</table>

</body>
</html>
