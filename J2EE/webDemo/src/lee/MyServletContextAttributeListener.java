package lee;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * User: jennie
 * Date: 2016/9/6
 * Time: 21:09
 */
//@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener{

    @Override
    public void attributeAdded(ServletContextAttributeEvent scab) {
        ServletContext apllication=scab.getServletContext();
        String name=scab.getName();
        Object value=scab.getValue();
        System.out.println(apllication+"范围内添加了名为"+name+",值为"+value+"的属性");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scab) {
        ServletContext application = scab.getServletContext();
        // 获取被删除的属性名和属性值
        String name = scab.getName();
        Object value = scab.getValue();
        System.out.println(application + "范围内名为"
                + name + "，值为" + value + "的属性被删除了!");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scab) {
        ServletContext application = scab.getServletContext();
        // 获取被替换的属性名和属性值
        String name = scab.getName();
        Object value = scab.getValue();
        System.out.println(application + "范围内名为"
                + name + "，值为" + value + "的属性被替换了!");
    }
}
