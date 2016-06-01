package cn.mode.spring.demo2;


/**
 * User: jennie
 * Date: 2016/6/1
 * Time: 10:17
 */
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
