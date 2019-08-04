package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : jennie
 * @date: 2019/8/4
 * @Time: 15:23
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/","homePage"},method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
