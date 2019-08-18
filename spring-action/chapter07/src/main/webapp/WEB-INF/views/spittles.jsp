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
<c:forEach items="${spittleMessage}" var="spittle">
    <li id="spittle_<c:out value="${spittle.id}"/>">
        <div class="spittleMessage">
            <c:out value="${spittle.message}"/>
        </div>
        <span class="spittleTime">
            <c:out value="${spittle.time}"/>
        </span>
        <span>
            (<c:out  value="${spittle.latitude}"/>,
            <c:out value="${spittle.longitude}"/>
            )
        </span>
    </li>
</c:forEach>
</body>
</html>
