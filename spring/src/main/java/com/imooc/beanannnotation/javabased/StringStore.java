package com.imooc.beanannnotation.javabased;

/**
 * User: jennie
 * Date: 2016/6/13
 * Time: 14:40
 */
public class StringStore implements Store<String> {

    public void init(){
        System.out.println("This is init");
    }

    public void destroy(){
        System.out.println("This is stop");
    }
}
