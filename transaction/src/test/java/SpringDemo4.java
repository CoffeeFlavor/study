import cn.mode.spring.demo4.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * User: jennie
 * Date: 2016/6/1
 * Time: 16:43
 * spring 的声明式事务管理的方式二：基于Aspectj的xml方式配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ApplicationContext4.xml")
public class SpringDemo4 {

    /**
     * 注入代理类：因为代理类进行增强操作
     */

    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void demo1(){
        accountService.transfer("aaa","bbb",200d);
    }
}
