package cn.mode.spring.demo4;


import org.springframework.transaction.annotation.Transactional;

/**
 * User: jennie
 * Date: 2016/6/1
 * Time: 10:17
 * @Transactional注解种的属性
 * propagation :事务传播行为
 * isolation: 事务的隔离级别
 * readOnly ：只读
 * rollbackfor：发生哪些异常回滚
 * noRollbackFor:发现哪些异常不回滚
 */
@Transactional
public class AccountServiceImpl implements AccountService {

    //注入转账的Dao的类型
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    /**
     * @param out        :转出账号
     * @param in         ：转入账号
     * @param money：转账金额
     */
    public void transfer(final String out, final String in, final Double money) {
        accountDao.outMoney(out, money);
        int i=1/0;
        accountDao.inMoney(in, money);
    }
}
