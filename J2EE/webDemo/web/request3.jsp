<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取包含非西欧字符的GET请求参数</title>
</head>
<body>
<%
    String rawQueryStr=request.getQueryString();
    out.println("原始查询字符串："+rawQueryStr+"<hr/>");
    String queryStr=java.net.URLDecoder.decode(rawQueryStr,"UTF-8");
    out.println("解码后的查询字符串："+queryStr+"<hr/>");
    String[] paramPairs=queryStr.split("&");
    for (String paramPair : paramPairs) {
        out.println("每个请求参数名、值对为："+paramPair+"<br>");
        String[] nameValue=paramPair.split("=");
        out.println(nameValue[0]+"参数的值是："+nameValue[1]+"<hr>");
    }
    String rawName=request.getParameter("name");
    byte[] rawBytes=rawName.getBytes("utf-8");
    String name=new String(rawBytes,"utf-8");
    out.println(name);
%>
</body>
</html>
