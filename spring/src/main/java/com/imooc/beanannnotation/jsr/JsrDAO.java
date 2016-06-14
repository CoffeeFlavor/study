package com.imooc.beanannnotation.jsr;

import org.springframework.stereotype.Repository;

/**
 * User: jennie
 * Date: 2016/6/14
 * Time: 17:36
 */
@Repository
public class JsrDAO {

    public void save(){
        System.out.println("JsrDAO invoked");
    }
}
