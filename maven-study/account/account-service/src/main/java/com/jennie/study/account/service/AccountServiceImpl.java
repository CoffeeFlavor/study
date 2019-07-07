package com.jennie.study.account.service;

import com.jennie.study.account.captcha.AccountCaptchaException;
import com.jennie.study.account.captcha.AccountCaptchaService;
import com.jennie.study.account.captcha.RandomGenerator;
import com.jennie.study.account.email.AccountEmailService;
import com.jennie.study.account.email.exception.AccountEmailException;
import com.jennie.study.account.persist.Account;
import com.jennie.study.account.persist.AccountPersistException;
import com.jennie.study.account.persist.AccountPersistService;
import jdk.nashorn.internal.ir.IfNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : jennie
 * @date: 2019/7/7
 * @Time: 16:52
 */
public class AccountServiceImpl  implements AccountService{

    private AccountPersistService accountPersistService;

    private AccountEmailService accountEmailService;

    private AccountCaptchaService accountCaptchaService;


    public AccountPersistService getAccountPersistService() {
        return accountPersistService;
    }

    public void setAccountPersistService(AccountPersistService accountPersistService) {
        this.accountPersistService = accountPersistService;
    }

    public AccountEmailService getAccountEmailService() {
        return accountEmailService;
    }

    public void setAccountEmailService(AccountEmailService accountEmailService) {
        this.accountEmailService = accountEmailService;
    }

    public AccountCaptchaService getAccountCaptchaService() {
        return accountCaptchaService;
    }

    public void setAccountCaptchaService(AccountCaptchaService accountCaptchaService) {
        this.accountCaptchaService = accountCaptchaService;
    }

    private Map<String,String> activityMap=new HashMap<>();

    @Override
    public String generateCaptchaKey() throws AccountServiceException {

        try {
            return accountCaptchaService.generateCaptchaKey();
        } catch (AccountCaptchaException e) {
            throw new AccountServiceException("Unable to generate Captcha key.",e);
        }
    }

    @Override
    public byte[] generateCaptchaImage(String captchaKey) throws AccountServiceException {
        try {
            return accountCaptchaService.generateCaptChaImage(captchaKey);
        } catch (AccountCaptchaException e) {

            throw new  AccountServiceException("Unable to generate Captcha Image",e);
        }
    }



    @Override
    public void signUp(SignUpRequest signUpRequest) throws AccountServiceException {
        try {
            if (!signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword())) {

                throw  new  AccountServiceException("2 password do not match");
            }
            if (!accountCaptchaService.validateCaptcha(signUpRequest.getCaptchaKey(),signUpRequest.getCaptchaValue())){
                throw  new AccountServiceException(" Incorrect Captcha");
            }

            Account account=new Account();
            account.setId(signUpRequest.getId());
            account.setEmail(signUpRequest.getEmail());
            account.setName(signUpRequest.getName());
            account.setActivated(false);
            account.setPassword(signUpRequest.getPassword());

            accountPersistService.crateAccount(account);

            String activationId= RandomGenerator.getRandomString();
            activityMap.put(activationId,account.getId());

            String link=signUpRequest.getActivateServiceUrl().endsWith("/")?signUpRequest.getActivateServiceUrl()
                    +activationId:signUpRequest.getActivateServiceUrl()+"?key"+activationId;

            accountEmailService.sendEmail(account.getEmail(),"Please Activate You Account",link);
        }  catch (AccountCaptchaException e) {
            throw new AccountServiceException("Unable to validate captcha");
        } catch (AccountPersistException e) {
            throw new AccountServiceException("Unable to create account ");
        } catch (AccountEmailException e) {
            throw new AccountServiceException("Unable to send activation mail");
        }

    }

    @Override
    public void activate(String activationNumber) throws AccountServiceException {
        String accountId=activityMap.get(activationNumber);
        if (accountId==null){
            throw  new AccountServiceException("Invalid account activation ID.");
        }

        try {
            Account account=accountPersistService.readAccount(accountId);
            account.setActivated(true);
            accountPersistService.updateAccount(account);
        } catch (AccountPersistException e) {
            throw  new AccountServiceException("Unable to activate account");
        }

    }

    @Override
    public void login(String id, String password) throws AccountServiceException {

        try {
            Account account=accountPersistService.readAccount(id);
            if (account==null){
                throw  new AccountServiceException("Account does not exist");
            }

            if (!account.getActivated()){
                throw new AccountServiceException("Account is disabled.");
            }
            if (!account.getPassword().equals(password)) {

                throw new AccountServiceException("Incorrect password");
            }
        } catch (AccountPersistException e) {
            throw new AccountServiceException("Unable to log inl",e);
        }
    }
}
