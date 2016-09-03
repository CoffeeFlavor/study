<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="mytag" uri="http://www.crazyit.org/mytaglib" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>下面显示的是自定义标签中的内容</h2>
<h4>指定两个属性</h4>
<mytag:dynaAttr name="crazyit" url="crazyit.org"/><br>
<h4>指定四个属性</h4>
<mytag:dynaAttr 书名="疯狂Java讲义" 价格="99.0"
 出版时间="2008年" 描述="Java图书"/><br>
</body>
</html>
