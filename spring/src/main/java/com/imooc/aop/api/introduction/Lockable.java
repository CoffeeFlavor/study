package com.imooc.aop.api.introduction;

/**
 * User: jennie
 * Date: 2016/6/20
 * Time: 11:09
 */
public interface Lockable {

    void lock();

    void unlock();

    boolean locked();

}
