package com.imooc.beanannnotation;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * User: jennie
 * Date: 2016/6/12
 * Time: 10:06
 */
//@Component("bean")
@Component
@Scope
public class BeanAnnotation {


    public void  say(String arg){
        System.out.println("BeanAnnotation:"+arg);
    }

    public void myHashCode(){
        System.out.println("BeanAnnotation:"+this.hashCode());
    }
}
