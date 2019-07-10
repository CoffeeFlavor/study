package com.jennie.study.account.persist;

/**
 * @author : jennie
 * date: 2019/7/3
 * Time: 21:46
 */
public interface AccountPersistService {

    Account crateAccount(Account account) throws AccountPersistException;

    Account readAccount(String id) throws AccountPersistException;

    Account updateAccount(Account account) throws AccountPersistException;

    void  deleteAccount(String id) throws AccountPersistException;
}
