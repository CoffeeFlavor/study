package com.imooc.beanannnotation.injection.dao;

import org.springframework.stereotype.Repository;

/**
 * User: jennie
 * Date: 2016/6/7
 * Time: 16:50
 */
@Repository
public class InjectionDaoImpl implements InjectionDao {

    private InjectionDao injectionDao;

    public void save(String arg) {
        //模拟数据库保存操作
        System.out.println("保存数据："+arg);
    }
}
