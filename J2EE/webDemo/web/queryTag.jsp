<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<!-- �����ǩ�⣬ָ��mytagǰ׺�ı�ǩ��
��http://www.crazyit.org/mytaglib�ı�ǩ�⴦�� -->
<%@ taglib uri="http://www.crazyit.org/mytaglib" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>�Զ����ǩʾ��</title>
    <meta name="website" content="http://www.crazyit.org" />
</head>
<body bgcolor="#ffffc0">
<h2>������ʾ���ǲ�ѯ��ǩ�Ľ��</h2>
<!-- ʹ�ñ�ǩ ������mytag�Ǳ�ǩǰ׺������taglib�ı���ָ�
	mytagǰ׺����http://www.crazyit.org/mytaglib�ı�ǩ�⴦�� -->
<mytag:query
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/liuyan"
        user="root"
        pass="root"
        sql="select * from user_inf"/><br/>
</body>
</html>