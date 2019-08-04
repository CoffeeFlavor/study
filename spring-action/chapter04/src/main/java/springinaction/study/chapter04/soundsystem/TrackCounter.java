package springinaction.study.chapter04.soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : jennie
 * @date: 2019/7/28
 * @Time: 11:52
 */
@Aspect
public class TrackCounter {

    public Map<Integer,Integer> trackCounts=new HashMap<Integer, Integer>();

    @Pointcut(
            "execution(* springinaction.study.chapter04.soundsystem.CompactDisc.playTrack(int))&&args(trackNumber)"
    )
    public void trackPlayed(int trackNumber){
    }

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber){
        int currentCount=getPlayCount(trackNumber);
        trackCounts.put(trackNumber,currentCount+1);
    }

    public int getPlayCount(int trackNumber){
        return trackCounts.containsKey(trackNumber)
                ?trackCounts.get(trackNumber):0;
    }
}
