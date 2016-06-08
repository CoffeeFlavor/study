package com.imooc.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * User: jennie
 * Date: 2016/6/8
 * Time: 16:01
 */
public class MoocApplicationContext implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MoocApplicationContext :"+applicationContext.getBean("moocApplicationContext").hashCode());
    }
}
