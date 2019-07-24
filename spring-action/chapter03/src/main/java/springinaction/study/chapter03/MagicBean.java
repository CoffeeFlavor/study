package springinaction.study.chapter03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @author : jennie
 * date: 2019/7/24
 * Time: 9:03
 */
public class MagicBean {

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean(){
        return new MagicBean();
    }
}
