package com.example.demo.weixin;

import com.example.demo.util.SignUtil;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jennie on 2017/7/7.
 */

@Controller
public class WxBaseController  {

    @RequestMapping("/check")
    @ResponseBody
    public String checkSign(HttpServletRequest request, HttpServletResponse response){

        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");


        WxMpInMemoryConfigStorage configStorage=new WxMpInMemoryConfigStorage();
        configStorage.setToken("1EACqMJ3fEwnoVDLD");
        WxMpService wxMpService=new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(configStorage);
        Boolean checkResult=wxMpService.checkSignature(timestamp,nonce,signature);
//        System.out.println(checkResult);
//
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//            if (checkResult) {
//                out.print(echostr);
//            }
//            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
////            if () {
////                out.print(echostr);
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            out.close();
//        }
        return echostr;
    }



}
