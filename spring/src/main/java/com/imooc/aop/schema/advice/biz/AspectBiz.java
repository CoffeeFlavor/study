package com.imooc.aop.schema.advice.biz;

/**
 * User: jennie
 * Date: 2016/6/15
 * Time: 10:46
 */
public class AspectBiz {

    public void biz(){
        System.out.println(" AspectBiz biz");
//        throw new RuntimeException();
    }

    public void init(String bizName,Integer times){
        System.out.println("AspectBiz init:"+bizName+" " +times);
    }
}
