import com.springinaction.study.chapter02.CDPlayer;
import com.springinaction.study.chapter02.CompactDisc;
import com.springinaction.study.chapter02.MediaPlayer;
import com.springinaction.study.chapter02.config.CDPlayerConfig;
import com.springinaction.study.chapter02.javaconfigauto.SgtPeppers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : jennie
 * date: 2019/7/17
 * Time: 6:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {CDPlayerConfig.class})
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class CDPlayerTest {

    @Rule
    public final StandardOutputStreamLog log=new StandardOutputStreamLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;

//    @Autowired
//    private SgtPeppers sgtPeppers;

    @Test
    public void cdShouldNotBeNull(){
        Assert.assertNotNull(cd);
    }

    @Test
    public void play(){
        player.play();;
        org.springframework.util.Assert.hasText("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n",log.getLog());
//        Assert.assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n",log.getLog());
    }
}
