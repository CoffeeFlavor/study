package com.imooc.beanannnotation.multibean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User: jennie
 * Date: 2016/6/12
 * Time: 16:48
 */
@Order(value = 1)
@Component
public class BeanImplTwo implements BeanInterface {
}
