package com.jennie.study.account.email;

import com.jennie.study.account.email.exception.AccountEmailException;

/**
 * @author : jennie
 * date: 2019/6/30
 * Time: 17:20
 */
public interface AccountEmailService {

    void sendEmail(String to,String subject,String htmlText) throws AccountEmailException;
}
