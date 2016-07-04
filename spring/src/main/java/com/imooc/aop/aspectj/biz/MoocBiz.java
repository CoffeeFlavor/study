package com.imooc.aop.aspectj.biz;

import com.imooc.aop.aspectj.MoocMethod;
import org.springframework.stereotype.Service;

/**
 * Created by CoffeeFlavor on 2016/7/1.
 */
@Service
public class MoocBiz {

    @MoocMethod("MoocBiz save MoocMethod")
    public String save(String arg){
        System.out.println("MoocBiz save: "+arg);
//        throw new RuntimeException();
        return "Save success";
    }
}
