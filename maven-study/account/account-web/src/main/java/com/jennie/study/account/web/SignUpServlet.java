package com.jennie.study.account.web;

import com.jennie.study.account.service.AccountService;
import com.jennie.study.account.service.AccountServiceException;
import com.jennie.study.account.service.SignUpRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : jennie
 * date: 2019/7/8
 * Time: 7:06
 */
public class SignUpServlet extends HttpServlet {

    private ApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context= WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String email=req.getParameter("email");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String confirmPassword=req.getParameter("confirm_password");
        String captchaKey=req.getParameter("captcha_key");
        String captchaValue=req.getParameter("captcha_value");

        if (id==null||id.length()==0||email==null
                ||email.length()==0||name==null||name.length()==0
                ||password==null||password.length()==0
                ||confirmPassword==null||confirmPassword.length()==0
                ||captchaKey==null||captchaKey.length()==0
                ||captchaValue==null||captchaValue.length()==0
        ){

            resp.sendError(400,"Parameter Incomplete");
        }

        AccountService service=(AccountService) context.getBean("accountService");
        SignUpRequest request=new SignUpRequest();

        request.setId(id);
        request.setEmail(email);
        request.setName(name);
        request.setPassword(password);
        request.setConfirmPassword(confirmPassword);
        request.setCaptchaKey(captchaKey);
        request.setCaptchaValue(captchaValue);

        request.setActivateServiceUrl(getServletContext().getRealPath("/")+"activate");

        try {
            service.signUp(request);
            resp.getWriter().print("Account is created,please check you email box for activation link.");
        }catch (AccountServiceException e){
            resp.sendError(400,e.getMessage());
        }
    }
}
