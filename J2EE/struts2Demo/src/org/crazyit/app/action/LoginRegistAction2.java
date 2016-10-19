package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * User: jennie
 * Date: 2016/10/19
 * Time: 17:19
 */
public class LoginRegistAction2 extends ActionSupport {


    private String username;

    private String password;

    private String tip;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String login() throws Exception {
        if (getUsername().equals("jennie")&&getPassword().equals("jennie")){
            //通过ActionContext设置request范围的属性
            ActionContext.getContext().getSession().put("user",getUsername());
            setTip("欢迎，"+getUsername()+",你已经登录成功");
            return SUCCESS;
        }
        //通过ActionContext设置request范围的属性
        return ERROR;
    }

    public String regist(){
        ActionContext.getContext().getSession().put("user",getUsername());
        setTip("恭喜你，"+getUsername()+",你已经注册成功");
        return SUCCESS;
    }
}
