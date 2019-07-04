package com.jennie.study.account.persist;

import javafx.geometry.VPos;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author : jennie
 * @date: 2019/7/4
 * @Time: 7:22
 */
public class AccountPersistServiceTest {

    private AccountPersistService service;

    @Before
    public void prepare() throws Exception{
        File persistDateFile=new File("target/test-classes/persist-data.xnl");
        if (persistDateFile.exists()){
            persistDateFile.delete();
        }

        ApplicationContext ctx=new ClassPathXmlApplicationContext("account-persist.xml");
        service=(AccountPersistService)ctx.getBean("accountPersistService");

        Account account=new Account();
        account.setId("jennie");
        account.setName("seven");
        account.setEmail("seven@qq.com");
        account.setPassword("this_should_be_encrypted");
        account.setActivated(true);
        service.crateAccount(account);
    }

    @Test
    public void testReadAccount(){
        Account account=service.readAccount("jennie");
        assertEquals("jennie",account.getId());
        assertEquals("seven",account.getName());
        assertEquals("seven@qq.com",account.getEmail());
        assertEquals("this_should_be_encrypted",account.getPassword());
        assertTrue(account.getActivated());
    }

}