package springinaction.study.chapter03;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author : jennie
 * date: 2019/7/24
 * Time: 9:04
 */
public class MagicExistsCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env=context.getEnvironment();
        return env.containsProperty("magic");
    }
}
