package springinaction.study.chapter04.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author : jennie
 * @date: 2019/7/28
 * @Time: 15:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ConcertConfig.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class PerformanceTest {

    @Autowired
    private EncoreableIntroducer encoreableIntroducer;

    @Autowired
    private Audience audiene;

    @Autowired
    private Performance performance;
    @Test
    public  void perform(){
        performance.perform();
        Encoreable encoreable=(Encoreable) performance;
        encoreable.performEncoreable();
    }
}
