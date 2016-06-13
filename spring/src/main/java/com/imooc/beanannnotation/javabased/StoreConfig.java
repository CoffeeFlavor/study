package com.imooc.beanannnotation.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.net.URLEncoder;
import java.util.List;


/**
 * User: jennie
 * Date: 2016/6/13
 * Time: 14:41
 */
@Configuration
//@ImportResource("classpath:/spring/config.xml")
public class StoreConfig {

//    @Value("${url}")
//    private String url;
//
//    @Value("${jdbc.username}")
//    private String username;
//
//    @Value("${password}")
//    private String password;
//
//    public  static String myName;
//
//    @Value("${my.name}")
//    public void setPrivateName(String privateName) {
//        System.out.println("---------");
//        StoreConfig.myName = privateName;
//    }

//    }

    //    @Bean
//    public MyDriverManager myDriverManager(){
//        return new MyDriverManager(url, username,password);
//    }
//    @Bean(name = "stringStore",initMethod = "init",destroyMethod = "destroy")
//    @Scope(value = "prototype",proxyMode =ScopedProxyMode.TARGET_CLASS )
//    public Store stringStore(){
//        return new StringStore();

    @Autowired
    private List<Store<String>> s1;
//
    @Autowired
    private Store<Integer> s2;

    @Bean
    public StringStore stringStore(){
        return new StringStore();
    }

    @Bean
    public IntegerStore integerStore(){
        return new IntegerStore();
    }

    @Bean(name = "stringStoreTest")
    public DoubleStore stringStoreTest(){
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2.getClass().getName());
        return new DoubleStore();
    }

}
