package com.imooc.beanannnotation.multibean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User: jennie
 * Date: 2016/6/12
 * Time: 16:48
 */
@Order(value = 3)
@Component
public class BeanImplOne implements BeanInterface {
}
