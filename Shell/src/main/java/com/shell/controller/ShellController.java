package com.shell.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * User: jennie
 * Date: 2016/4/12
 * Time: 14:19
 */
@Controller
@RequestMapping("/shell")
public class ShellController {

    @RequestMapping("/manage")
    public String manage(Map<String,Object> viewObject){
        viewObject.put("name","lin");
        return "shell.manage";
    }


}
