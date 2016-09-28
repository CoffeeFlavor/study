package lee;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: jennie
 * Date: 2016/9/28
 * Time: 10:20
 */
@ServerEndpoint(value = "/websocket/chat")
public class ChatEndpoint {

    private static final String GUEST_PREFIX="访客";

    private static final AtomicInteger connectionIds=new AtomicInteger(0);
    //定义一个集合，用于保存所有接入的WebSocket
    private static final Set<ChatEndpoint> clientSet=new CopyOnWriteArraySet<>();
    //定义一个成员变量，记录与webSocket之间的会话
    private final String nickname;

    //定义一个成员变量，记录与webSocket之间的会话
    private Session session;

    public ChatEndpoint() {
        nickname=GUEST_PREFIX+connectionIds.getAndIncrement();
    }

    //当客户端连接进来时自动激发该方法
    @OnOpen
    public void start(Session session){
        this.session=session;
        //将WebSocket客户端会话添加到集合中
        clientSet.add(this);
        String message=String.format("【%s %s】",nickname,"加入聊天室！");
        //发送消息
        broadcast(message);
    }

    //当客户端断开连接时自动激发该方法
    @OnClose
    public void end(){
        clientSet.remove(this);
        String message=String.format("【%s %s】",nickname,"离开聊天室！");
        //发送消息
        broadcast(message);
    }

    @OnMessage
    public void incoming(String message){
        String filteredMessage=String.format("%s：%s",nickname,filter(message));
        //发送消息
        broadcast(filteredMessage);
    }
    @OnError
    public void onError(Throwable t)throws Throwable{
        System.out.println("WebSocket服务端错误"+t);
    }


    //实现广播消息的工具方法
    private static void broadcast(String msg){
        //遍历服务器相关的所有客户端
        for (ChatEndpoint client : clientSet) {
            try {
                synchronized (client){
                    //发送消息
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                System.out.println("聊天错误，向客户端"+client+"发送消息出现错误");
                clientSet.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                }
                String message=String.format("【%s %s】",client.nickname,"已经被断开连接");
                broadcast(message);
            }
        }
    }

    public static String filter(String message){
        if (message== null){
            return null;
        }
        char content[]=new char[message.length()];
        message.getChars(0,message.length(),content,0);
        StringBuilder result=new StringBuilder(content.length+50);
        for (int i = 0; i < content.length; i++) {
            //控制对尖括号等特殊符号进行转义
            switch (content[i]){
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                case '&':
                    result.append("&amp;");
                    break;
                case '"':
                    result.append("&quot;");
                    break;
                default:
                    result.append(content[i]);
            }
        }
        return (result.toString());
    }
}
