package com.imooc.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * User: jennie
 * Date: 2016/6/8
 * Time: 14:35
 */
public class BeanLifeCycle /*implements InitializingBean,DisposableBean*/{

    public void destroy() throws Exception {
        System.out.println("Bean destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean afterPropertiesSet");
    }

    public void start(){
        System.out.println("Bean start");
    }

    public void stop(){
        System.out.println("Bean stop");
    }

    public void defaultInit(){
        System.out.println("Bean DefaultInit");
    }

    public void defaultDestroy(){
        System.out.println("Bean DefaultDestroy");
    }
}
