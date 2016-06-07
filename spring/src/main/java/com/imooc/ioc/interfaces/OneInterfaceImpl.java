package com.imooc.ioc.interfaces;

/**
 * User: jennie
 * Date: 2016/6/7
 * Time: 15:37
 */
public class OneInterfaceImpl implements OneInterface {

    public String hello(String word) {
        return "Word form interface \"OneInterface\":"+word;
    }
}
