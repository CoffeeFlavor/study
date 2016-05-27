package org.seckill.web;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: jennie
 * Date: 2016/5/27
 * Time: 15:54
 */
@Controller
@RequestMapping("/seckill")//url:/模块/资源/{id}/细分 /seckill/list
public class SeckillController {

    private final Logger logger= LoggerFactory.getLogger(SeckillController.class);

    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        //获取列表页
        List<Seckill> list=seckillService.getSeckillList();
        model.addAttribute("list",list);
        //list.jsp+model=ModelAndView
        return "list";
    }
    @RequestMapping(value = "/{seckillId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId,Model model){
        if (seckillId==null) {
            return "redirect:/seckill/list";
        }
        Seckill seckill=seckillService.getById(seckillId);
        if (seckill==null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill",seckill);
        return "detail";
    }

    @RequestMapping(value = "/{seckillId}/exposer",method = RequestMethod.POST)
    @ResponseBody
    public SeckillResult<Exposer> exposer(Long seckillId){
        SeckillResult<Exposer> result;
        try {
            Exposer exposer=seckillService.exportSeckillUrl(seckillId);
            result=new SeckillResult<Exposer>(true,exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            result =new SeckillResult<Exposer>(false,e.getMessage());
        }
        return result;
    }

}
