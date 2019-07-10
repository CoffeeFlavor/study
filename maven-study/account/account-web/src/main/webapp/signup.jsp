<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.jennie.study.account.service.*,
                org.springframework.context.ApplicationContext,
                org.springframework.web.context.support.WebApplicationContextUtils"
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
    AccountService accountService = (AccountService) context.getBean("accountService");
    String captchaKey = accountService.generateCaptchaKey();
%>

<div class="text-field">
    <h2>注册新用户</h2>
    <form name="signup" action="signup" method="post">
        <label>账户ID：</label>><input type="text" name="id"/></input>
        <br/>
        <label>Email：</label><input type="text" name="email"/></input>
        <br/>
        <label>显示名称：</label>><input type="text" name="name"/></input>
        <br/>
        <label>密码：</label><input type="text" name="password"/></input>
        <br/>
        <label>确认密码：</label><input type="text" name="confirm_password"/></input>
        <br/>
        <label>验证码：</label><input type="text" name="captcha_value"/></input>
        <input type="hidden" name="captcha_key" value="<%=captchaKey%>>">
        <img src="<%=request.getContextPath()%>/captcha_image?key=<%=captchaKey%>">
        <button>确认并提交</button>
    </form>

</div>
</body>
</html>
