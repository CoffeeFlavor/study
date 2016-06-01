import cn.mode.spring.demo2.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * User: jennie
 * Date: 2016/6/1
 * Time: 15:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ApplicationContext.xml")
public class SpringDemo1 {

    //测试业务层类

    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void  demo1(){
        accountService.transfer("aaa","bbb",200d);
    }
}
