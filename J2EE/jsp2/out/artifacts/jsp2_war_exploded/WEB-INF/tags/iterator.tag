<%@ tag pageEncoding="utf-8" import="java.util.List" %>
<!--定义四个标签属性-->
<%@attribute name="bgColor" %>
<%@attribute name="cellColor" %>
<%@attribute name="title" %>
<%@attribute name="bean" %>
<table border="1" bgcolor="${bgColor}">
    <%
        List<String> list = (List<String>) request.getAttribute("a");
        //遍历输出list结合元素
        for (Object ele : list) {
    %>
    <tr>
        <td bgcolor="${cellColor}}">
            <%=ele%>
        </td>
    </tr>
    <%
        }
    %>
</table>