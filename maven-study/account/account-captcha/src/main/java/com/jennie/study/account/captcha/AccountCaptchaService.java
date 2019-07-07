package com.jennie.study.account.captcha;


import java.util.List;

/**
 * @author : jennie
 * @date: 2019/7/5
 * @Time: 21:32
 */
public interface AccountCaptchaService {

    String generateCaptchaKey() throws AccountCaptchaException;

    byte[] generateCaptChaImage(String captchaKey ) throws AccountCaptchaException;

    boolean validateCaptcha(String captchaKey,String captchaValue) throws AccountCaptchaException;

    List<String> getPreDefinedTexts();

    void setPreDefinedTexts(List<String> preDefinedTexts) ;
}
