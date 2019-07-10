package com.jennie.study.account.email.impl;

import com.jennie.study.account.email.AccountEmailService;
import com.jennie.study.account.email.exception.AccountEmailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author : jennie
 * date: 2019/6/30
 * Time: 17:22
 */
public class AccountEmailServiceImpl implements AccountEmailService {


    private JavaMailSender javaMailSender;

    private String systemEmail;

    @Override
    public void sendEmail(String to, String subject, String htmlText) throws AccountEmailException {

        try {
            MimeMessage msg=javaMailSender.createMimeMessage();
            MimeMessageHelper msgHelper=new MimeMessageHelper(msg);
            msgHelper.setFrom(systemEmail);
            msgHelper.setSubject(subject);
            msgHelper.setTo(to);
            msgHelper.setText(htmlText,true);
            javaMailSender.send(msg);
        }catch ( MessagingException e)
        {
            throw new AccountEmailException("Faild to send email",e);
        }
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }
}
