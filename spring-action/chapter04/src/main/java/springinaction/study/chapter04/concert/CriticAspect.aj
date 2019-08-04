package springinaction.study.chapter04.concert;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.weaver.patterns.Pointcut;

/**
 * @author : jennie
 * @date: 2019/7/28
 * @Time: 17:39
 */
public aspect CriticAspect {
    public CriticAspect() {
    }

    pointcut performance() : execution(* perform(..));

    afterReturning() :performance(){
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
