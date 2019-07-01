package com.jennie.study.account.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;

import static org.junit.Assert.*;

/**
 * @author : jennie
 * @date: 2019/6/30
 * @Time: 17:49
 */

public class AccountEmailServiceTest {

    private GreenMail greenMail;

    @Before
    public void startMailServer()  throws Exception {
        greenMail=new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("test3@jennie.com","123456");
        greenMail.start();
    }

    @Test
    public void  testSendEmail() throws Exception{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService accountEmailService=(AccountEmailService) ctx.getBean("accountEmailService");
        String subject="Text Subject";
        String htmlText="<h3>Test</h3>";
        accountEmailService.sendEmail("1239142342@qq.com",subject,htmlText);
        greenMail.waitForIncomingEmail(2000,1);
        Message[] msgs=greenMail.getReceivedMessages();
        assertEquals(1,msgs.length);
        assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
    }

    @After
    public void stopMailServer() throws Exception{
        greenMail.stop();;
    }

}
