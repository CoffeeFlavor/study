package com.example.demo.weixin;

import com.example.demo.util.SignUtil;
import com.sun.deploy.util.URLUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by jennie on 2017/7/7.
 */

@Controller
public class WxBaseController  {

    @Value("${weixin.appid}")
    private String appId;

    @Value("${weixin.appsecret}")
    private String appSecret;

//    @Autowired
//    private RedisTemplate redisTemplate;

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

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

    @RequestMapping("/get/weixin/token")
    @ResponseBody
    public Object getWeiXinToken(){
        String url=String.format(WeiXinConstant.WEIXIN_GET_TOKEN,appId,appSecret);
        RestTemplate restTemplate= new RestTemplate();
        System.out.println(url);
        ReWXToken wxToken= restTemplate.getForEntity(url,ReWXToken.class).getBody();

        if (wxToken!=null&&wxToken.getAccess_token()!=null){
//            stringRedisTemplate
        }
        return wxToken;
    }

    @RequestMapping("/test")
    public String test(){
        String redirectUrl=String.format(WeiXinConstant.WEIXIN_WEB_AUTHORIZE,appId, URLEncoder.encode("http://jennie.51vip.biz/redirectTest"),"snsapi_userinfo");
        System.out.println(redirectUrl);
        return redirectUrl;
    }

    @RequestMapping("/redirectTest")
    public String redirectTest( String code, String state) {
        System.out.println(code);
        System.out.println(state);
        return "test";
    }
}
