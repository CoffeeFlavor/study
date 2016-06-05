package com.imooc.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: jennie
 * Date: 2016/6/5
 * Time: 12:17
 */
@Controller
@RequestMapping("/hello")
public class HelloMvcController {

    @RequestMapping("/mvc")
    public String helloMvc(){
        return "home";
    }
}
