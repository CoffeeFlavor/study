package com.imooc.aop.schema.advisors.service;

import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;

/**
 * User: jennie
 * Date: 2016/6/17
 * Time: 11:39
 */
@Service
public class InvokeService {


    public void invoke() {
        System.out.println("InvokeService ......");
    }

    public void invokeException() {
        throw new PessimisticLockingFailureException("");
    }
}
