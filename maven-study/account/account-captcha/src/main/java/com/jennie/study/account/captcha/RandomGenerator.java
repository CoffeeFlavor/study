package com.jennie.study.account.captcha;

import java.util.Random;

/**
 * @author : jennie
 * @date: 2019/7/6
 * @Time: 16:03
 */
public class RandomGenerator {

    private static String range="0123456789abcdefghijklmnopqrstxyz";

    public static synchronized String getRandomString(){
        Random random=new Random();
        StringBuffer result=new StringBuffer();
        for (int i = 0; i < 8; i++) {
            result.append(range.charAt(random.nextInt(range.length())));
        }
        return result.toString();
    }
}
