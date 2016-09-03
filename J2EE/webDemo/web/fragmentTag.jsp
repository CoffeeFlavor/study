<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="mytag" uri="http://www.crazyit.org/mytaglib" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>下面显示的是自定义标签的内容</h2>
<mytag:fragment>
    <jsp:attribute name="fragment">
        <mytag:helloWorld/>
    </jsp:attribute>
</mytag:fragment>
<br>
<mytag:fragment>
    <jsp:attribute name="fragment">
        ${pageContext.request.remoteAddr}
    </jsp:attribute>
</mytag:fragment>
</body>
</html>
