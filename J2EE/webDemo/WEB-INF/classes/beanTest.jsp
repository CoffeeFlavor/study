<%@ page contentType="text/html;charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
	<title>java bean 测试</title>
</head>
<body>
  <jsp:useBean id="pl"  scope="page" class="Person">
  <jsp:setProperty name="pl" property="name" value="crazyyit.org"/>
  <jsp:setProperty name="pl" property="age" value="23"/>
  <jsp:getProperty name="pl" property="name"/>
  <br/>
  <jsp:getProperty name="pl" property="age"/>
  </jsp:useBean>
</body>
</html>
