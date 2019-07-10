package com.jennie.study.account.service;

/**
 * @author : jennie
 * date: 2019/7/7
 * Time: 16:47
 */
public interface AccountService {

    String generateCaptchaKey() throws AccountServiceException;

    byte[] generateCaptchaImage(String captchaKey) throws AccountServiceException;

    void signUp(SignUpRequest signUpRequest) throws AccountServiceException;

    void activate(String activationNumber) throws AccountServiceException;

    void login(String id,String password) throws AccountServiceException;
}
