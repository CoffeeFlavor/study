package com.shell.service;


import com.shell.domain.ShellMessage;
import net.sf.json.JSONObject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User: jennie
 * Date: 2016/4/13
 * Time: 9:57
 */
@ServerEndpoint("/websocket")
public class WebsocketForShell {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private static Map<Session,ShellUtils> sshSessionMap=new HashMap<Session, ShellUtils>();

    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println("有新连接加入！");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        // subOnlineCount();           //在线数减1
        String deleteKey="";
        System.out.println("有一连接关闭！" );
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss.SSS");
        System.out.println(sdf.format(new Date()) + "  来自客户端的消息:" + message);
        JSONObject json = JSONObject.fromObject(message);
        ShellMessage shellMessage=(ShellMessage) JSONObject.toBean(json,ShellMessage.class);
        SSHUtils sshUtils=new SSHUtils();
        try {
            session.getBasicRemote().sendText(sshUtils.execCommand(shellMessage));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }
}
