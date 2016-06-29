package com.imooc.aop.api.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * User: jennie
 * Date: 2016/6/20
 * Time: 11:10
 */
public class LockMixin extends DelegatingIntroductionInterceptor implements Lockable{


    private static final long serialVersionUID = 8569672996977696474L;

    public void lock() {

    }

    public void unlock() {

    }

    public boolean locked() {
        return false;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (locked()&& invocation.getMethod().getName().indexOf("set")==0){
            throw new RuntimeException();
        }

        return super.invoke(invocation);
    }
}
