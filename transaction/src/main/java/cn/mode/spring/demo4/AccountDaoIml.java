package cn.mode.spring.demo4;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * User: jennie
 * Date: 2016/6/1
 * Time: 10:37
 */
public class AccountDaoIml extends JdbcDaoSupport implements AccountDao {

    /**
     *
     * @param out   :转出账号
     * @param money  ：转出金额
     */
    public void outMoney(String out, Double money) {
        String sql="update account set money=money-? where name=?";
        this.getJdbcTemplate().update(sql,money,out);


    }

    /**
     *
     * @param in  :转入账号
     * @param money ：转入金额
     */
    public void inMoney(String in, Double money) {
        String sql="update account set money=money+? where name=?";
        this.getJdbcTemplate().update(sql,money,in);
    }
}
