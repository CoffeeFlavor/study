package cn.mode.spring.demo3;

/**
 * User: jennie
 * Date: 2016/6/1
 * Time: 10:19
 * 转账案列的Dao的接口
 */
public interface AccountDao {

    /**
     *
     * @param out   :转出账号
     * @param money  ：转出金额
     */
    void outMoney(String out, Double money);

    /**
     *
     * @param in  :转入账号
     * @param money ：转入金额
     */
    void inMoney(String in, Double money);
}
