package com.springinaction.knights.config;

import com.springinaction.knights.BraveKnight;
import com.springinaction.knights.Knight;
import com.springinaction.knights.Quest;
import com.springinaction.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : jennie
 * date: 2019/7/12
 * Time: 8:13
 */
@Configuration
public class KnightConfig {



    @Bean
    public Knight kight(){
        return new BraveKnight(quest());
    }


    @Bean
    public Quest quest(){
        return new SlayDragonQuest(System.out);
    }
}
