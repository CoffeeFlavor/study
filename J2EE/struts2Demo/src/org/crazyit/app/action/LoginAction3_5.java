package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.Cookie;

/**
 * User: jennie
 * Date: 2016/10/9
 * Time: 14:55
 */
public class LoginAction3_5 extends ActionSupport {

    private String username;

    private String password;

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

    @Override
    public String execute() throws Exception {
        ActionContext context=ActionContext.getContext();
        //通过ActionContext访问application范围的属性值
        Integer counter=(Integer) context.getApplication().get("counter");
        if (counter==null) {
            counter=1;
        }else {
            counter=counter+1;
        }
        //通过ActionContext设置application范围的属性
        context.getApplication().put("counter",counter);
        //通过ActionContext设置session范围的属性
        context.getSession().put("user",getUsername());
        if (getUsername().equals("crazyit.org")&&getPassword().equals("leegang")){
            //通过ActionContext设置request范围的属性
            context.put("tip","服务器提示：你已经登录成功");
            return SUCCESS;
        }
        //通过ActionContext设置request范围的属性
        context.put("tip","服务器提示：登录失败");
        return ERROR;
    }
}
