package com.imooc.aop.api.introduction;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * User: jennie
 * Date: 2016/6/20
 * Time: 11:31
 */
public class LockMixinAdvisor extends DefaultIntroductionAdvisor {


    private static final long serialVersionUID = -171332350782163120L;

    public LockMixinAdvisor() {
        super(new LockMixin(),Lockable.class);
    }
}
