package com.imooc.beanannnotation.multibean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * User: jennie
 * Date: 2016/6/12
 * Time: 17:07
 */
@Component
public class BeanInvoker {

    @Autowired
    public List<BeanInterface> list;

    @Autowired
    public Map<String,BeanInterface> map;

    @Autowired
    @Qualifier("beanImplTwo")
    private BeanInterface beanInterface;

    public void say(){
        if (null!=list){
            Iterator iterator= list.iterator();
            while (iterator.hasNext()){
                System.out.println(((BeanInterface)iterator.next()).getClass().getName());
            }
            for (BeanInterface bean : list) {
                System.out.println(bean.getClass().getName());
            }
        }else {
            System.out.println("List<BeanInterface> list is null !!!!!!");
        }
        if (null!=map && map.size()>0){

            System.out.println("map...........");

            for (Map.Entry<String, BeanInterface> entry : map.entrySet()) {
                System.out.println(entry.getKey()+"    "+entry.getValue().getClass().getName());
            }
        }else {
            System.out.println("Map<String,BeanInterface> map is null !!!!!");
        }
        System.out.println();
        if (null!=beanInterface){
            System.out.println(beanInterface.getClass().getName());
        }else {
            System.out.println("beanInterface is null...");
        }
    }
}
