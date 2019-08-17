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
<div class="spittleView">
    <div class="spittleMeseage">
        <c:out value="${spittle.message}"/>
    </div>
    <span class="spittleTime">
        <c:out value="${spittle.time}"/>
    </span>
</div>
</body>
</html>
