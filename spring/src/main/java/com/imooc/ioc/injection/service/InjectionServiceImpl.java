package com.imooc.ioc.injection.service;

import com.imooc.ioc.injection.dao.InjectionDao;

/**
 * User: jennie
 * Date: 2016/6/7
 * Time: 16:48
 */
public class InjectionServiceImpl implements InjectionService {

    private InjectionDao injectionDao;

    //设值注入
    public void setInjectionDao(InjectionDao injectionDao) {
        this.injectionDao = injectionDao;
    }

    //构造注入
    public InjectionServiceImpl(InjectionDao injectionDao) {
        this.injectionDao = injectionDao;
    }

    public void save(String arg) {
        //模拟业务操作
        System.out.println("Service接收参数："+arg);
        arg=arg+":"+this.hashCode();
        injectionDao.save(arg);
    }
}
