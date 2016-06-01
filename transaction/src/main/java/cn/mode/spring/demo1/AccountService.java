package cn.mode.spring.demo1;

/**
 * User: jennie
 * Date: 2016/6/1
 * Time: 10:14
 */
public interface AccountService {

    /**
     *
     * @param out :转出账号
     * @param in  ：转入账号
     * @param money：转账金额
     */
    void transfer(String out, String in, Double money);
}
