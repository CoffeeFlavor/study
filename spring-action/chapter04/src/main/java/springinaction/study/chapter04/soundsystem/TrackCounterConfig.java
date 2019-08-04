package springinaction.study.chapter04.soundsystem;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jennie
 * @date: 2019/7/28
 * @Time: 14:28
 */
@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers(){
        BlankDisc cd=new BlankDisc();
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The Beatles");

        List<String> tracks=new ArrayList<String>();
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        tracks.add("With a Little Help From My Friend");
        tracks.add("Luky in the sky with Diamonds ");
        tracks.add("Getting Better");
        tracks.add("Fixing a Hole");

        // ...other tracks omitted for brevity
        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }


}
