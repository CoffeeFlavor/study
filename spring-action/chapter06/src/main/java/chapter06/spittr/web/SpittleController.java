package chapter06.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import chapter06.spittr.Spittle;
import chapter06.spittr.data.SpittleRespository;

import javax.validation.Valid;

/**
 * @author : jennie
 * @date: 2019/8/4
 * @Time: 16:11
 */
@Controller
public class SpittleController {

    private final static String MAX_LONG_STRING=Long.toString(Long.MAX_VALUE);

    private SpittleRespository spittleRespository;

    @Autowired
    public SpittleController(SpittleRespository spittleRespository){
        this.spittleRespository=spittleRespository;
    }

    @RequestMapping(value = "spittles",method = RequestMethod.GET)
    public String spittles(Model model, @RequestParam(value = "max",defaultValue = "2000") long max,@RequestParam(value = "count",defaultValue ="20") int count){
        model.addAttribute("spittleMessage",spittleRespository.findSpittles(max,count));
        return "spittles";
    }

//    @RequestMapping(value = "spittle/{spittleId}",method = RequestMethod.GET)
//    public String spittle(Model model, @PathVariable long spittleId){
//        model.addAttribute("spittle",spittleRespository.getSpittle(spittleId));
//        return "spittle";
//    }

    @RequestMapping(value = "spittle/{username}",method = RequestMethod.GET)
    public String profile(Model model, @PathVariable String username){
        model.addAttribute("spittle",spittleRespository.getProfile(username));
        return "profile";
    }



    @RequestMapping(value = "spittle/register",method = RequestMethod.GET)
    public String showRegister(){
        return "registerForm";
    }

    @RequestMapping(value = "spittle/register",method = RequestMethod.POST)
    public String processRegisterAction(@Valid Spittle spittle, Errors errors){
        if (errors.hasErrors()) {
            return "registerForm";
        }
        System.out.println(errors.toString());
        spittleRespository.save(spittle);
        return "redirect:/spittle/"+spittle.getUsername();
    }
}
