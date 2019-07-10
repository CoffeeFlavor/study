package com.jennie.study.account.web;

import com.jennie.study.account.service.AccountService;
import com.jennie.study.account.service.AccountServiceException;
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
 * Time: 21:23
 */
public class LoginServlet extends HttpServlet {

    private ApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context= WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService service=(AccountService) context.getBean("accountService");
        String id=req.getParameter("id");
        String password=req.getParameter("password");
        try {
            service.login(id,password);
        } catch (AccountServiceException e) {
            resp.sendError(400,e.getMessage());
        }

    }
}
