package com.jennie.study;

/**
 * @author : jennie
 * @date: 2019/6/30
 * @Time: 15:11
 */
public class HelloWorld {

    public String sayHello(){
        return "Hello World";
    }

    public static void main(String[] args) {
        System.out.println( new HelloWorld().sayHello());
    }
}
