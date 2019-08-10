package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunMisc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.data.SpittleRespository;

/**
 * @author : jennie
 * @date: 2019/8/4
 * @Time: 16:11
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRespository spittleRespository;

    @Autowired
    public SpittleController(SpittleRespository spittleRespository){
        this.spittleRespository=spittleRespository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute("spittleMessage",spittleRespository.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }
}
