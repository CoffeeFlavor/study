package springinaction.study.chapter04.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : jennie
 * @date: 2019/7/28
 * @Time: 15:37
 */
@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "springinaction.study.chapter04.concert.Performance+",defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
