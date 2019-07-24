package com.springinaction.study.chapter02.config;

import com.springinaction.study.chapter02.CDPlayer;
import com.springinaction.study.chapter02.CompactDisc;
import org.springframework.context.annotation.*;

/**
 * @author : jennie
 * date: 2019/7/17
 * Time: 6:28
 */
//@ComponentScan(value = "com.springinaction.study.chapter02.javaconfigauto")
@Configuration
//@Import(CDConfig.class)
@ImportResource("classpath:spring-config.xml")
public class CDPlayerConfig {

//    @Bean
//    public CompactDisc sgtPeppers(){
//        return new SgtPeppers();
//    }

/*    @Bean
    public CDPlayer cdPlayer(){
       return new CDPlayer(sgtPeppers());
    }*/

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
