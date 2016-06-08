package com.imooc.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * User: jennie
 * Date: 2016/6/8
 * Time: 16:01
 */
public class MoocBeanName implements BeanNameAware,ApplicationContextAware{

    private String beanName;

    public void setBeanName(String s) {
        this.beanName=s;
        System.out.println("MoocBeanName:"+s);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext:"+applicationContext.getBean(beanName).hashCode());
    }
}
