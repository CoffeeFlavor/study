package com.jennie.study.account.service;

/**
 * @author : jennie
 * date: 2019/7/7
 * Time: 16:49
 */
public class SignUpRequest {

    private String id;

    private String name;

    private String email;

    private String password;

    private String confirmPassword;

    private String captchaKey;

    private String captchaValue;

    private String activateServiceUrl;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getCaptchaKey() {
        return captchaKey;
    }

    public void setCaptchaKey(String captchaKey) {
        this.captchaKey = captchaKey;
    }

    public String getCaptchaValue() {
        return captchaValue;
    }

    public void setCaptchaValue(String captchaValue) {
        this.captchaValue = captchaValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivateServiceUrl() {
        return activateServiceUrl;
    }

    public void setActivateServiceUrl(String activateServiceUrl) {
        this.activateServiceUrl = activateServiceUrl;
    }
}
