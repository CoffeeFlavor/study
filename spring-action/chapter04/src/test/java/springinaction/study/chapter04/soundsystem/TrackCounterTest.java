package springinaction.study.chapter04.soundsystem;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author : jennie
 * @date: 2019/7/28
 * @Time: 14:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TrackCounterConfig.class)
@ContextConfiguration(locations = "classpath:spring-config2.xml")
public class TrackCounterTest {

    public final StandardOutputStreamLog log=new StandardOutputStreamLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private TrackCounter counter;

    @Test
    public void  testTrackCount(){

        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(7);
        cd.playTrack(7);
        System.out.println(new Gson().toJson(counter.trackCounts));
        assertEquals(1,counter.getPlayCount(1));
        assertEquals(1,counter.getPlayCount(2));
        assertEquals(4,counter.getPlayCount(3));
        assertEquals(0,counter.getPlayCount(4));
        assertEquals(0,counter.getPlayCount(5));
        assertEquals(0,counter.getPlayCount(6));
        assertEquals(2,counter.getPlayCount(7));
    }



}
