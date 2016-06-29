package com.imooc.aop.api;

/**
 * User: jennie
 * Date: 2016/6/20
 * Time: 10:15
 */
public class BizLogicImpl implements BizLogic {
    public String save() {
        System.out.println("BizLogicImpl : Logic save");
        return "BizLogicImpl save";
//        throw new RuntimeException();
    }

}
