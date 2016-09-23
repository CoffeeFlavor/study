<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: CoffeeFlavor
  Date: 2016/9/23
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>迭代器tag file</h2>
<%
    //创建集合对象，用于测试tag file 所定义的标签
    List<String> a=new ArrayList<>();
    a.add("疯狂Java讲义");
    a.add("轻量级Java EE企业应用实战");
    a.add("疯狂Ajax讲义");
    //将集合对象放入页面范围
    request.setAttribute("a",a);
%>
<h3>使用自定义标签</h3>
<tags:iterator cellColor="#9999cc" bgColor="#99dd99" title="迭代器标签" bean="a"></tags:iterator>
</body>
</html>
