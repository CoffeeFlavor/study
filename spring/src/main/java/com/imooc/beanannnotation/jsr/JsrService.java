package com.imooc.beanannnotation.jsr;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * User: jennie
 * Date: 2016/6/14
 * Time: 17:35
 */
//@Service
@Named
public class JsrService {

//    @Resource
//    @Inject
    private JsrDAO jsrDAO;

    @Inject
    public void setJsrDAO(@Named("jsrDAO") JsrDAO jsrDAO) {
        this.jsrDAO = jsrDAO;
    }

    public void save(){
        jsrDAO.save();
    }



    @PostConstruct
    public void init(){
        System.out.println("JsrService init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("JsrService destroy");
    }
}
