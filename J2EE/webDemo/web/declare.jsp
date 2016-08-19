<%@ page contentType="text/html;charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
	<title>欢迎</title>
</head>
<body>
<%!
//声明一个整形变量
public int count;
//声明一个方法
public String info(){
	return "hello";
}
%>
<br/>
<%
  //将count的值输出后再加1
  out.println(count++);
%>
<br/>
<%=count++%>
<br/>
<%
  //输出info（）方法的返回值
  out.println(info());
%>
</body>
</html>