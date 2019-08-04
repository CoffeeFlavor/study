package springinaction.study.chapter04.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author : jennie
 * @date: 2019/7/28
 * @Time: 11:40
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ConcertConfig {

    @Bean
    public Audience audience(){
        return new Audience();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer(){
        return new EncoreableIntroducer();
    }

    @Bean
    public Performance performance(){
        return new Singer();
    }
}
