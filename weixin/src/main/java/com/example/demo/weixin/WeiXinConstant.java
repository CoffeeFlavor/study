package com.example.demo.weixin;

/**
 * Created by jennie on 2017/7/7.
 */
public class WeiXinConstant {

    public static String WEIXIN_GET_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    public static String WEIXIN_WEB_AUTHORIZE="https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=STATE#wechat_redirect";
}
