package com.springinaction.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : jennie
 * date: 2019/7/12
 * Time: 8:18
 */
public class KnightMain {

    public static void main(String[] args) throws Exception{

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("knights.xml");
        Knight knight=context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();

    }
}
