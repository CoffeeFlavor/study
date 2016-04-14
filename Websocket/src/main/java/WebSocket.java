
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
 * Date: 2016/4/14
 * Time: 14:08
 */
//该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。类似Servlet的注解mapping。无需在web.xml中配置。
@ServerEndpoint("/websocket")
public class WebSocket {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识

    //    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
    private static Map<String, WebSocket> webSocketMap = new HashMap<String, WebSocket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        // subOnlineCount();           //在线数减1
        String deleteKey="";
        for (Map.Entry<String, WebSocket> entry : webSocketMap.entrySet()) {
            if (entry.getValue().equals(this)){
                deleteKey=entry.getKey();
                break;
            }
        }
        webSocketMap.remove(deleteKey);
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
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
        if (json.getBoolean("isLogin")){
            webSocketMap.put(json.getString("member"),this);
            JSONObject sendJson=new JSONObject();
            JSONObject jsonSelf=new JSONObject();
            jsonSelf.put("status","frendList");
            jsonSelf.put("friends",webSocketMap.keySet());
            try {
                session.getBasicRemote().sendText(jsonSelf.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            sendJson.put("status","frendAdd");
            sendJson.put("friend",json.getString("member"));
            for (Map.Entry<String,WebSocket> item: webSocketMap.entrySet()) {
                if (!session.equals(item.getValue().session)){
                    try {
                        item.getValue().sendMessage(sendJson.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                        continue;
                    }
                }
            }
        }else {
            WebSocket myWebSocket=webSocketMap.get(json.getString("toMember"));
            try {
                JSONObject sendJson=new JSONObject();
                sendJson.put("status","message");
                sendJson.put("from",json.getString("user"));
                sendJson.put("message",json.getString("message"));
                myWebSocket.session.getBasicRemote().sendText(sendJson.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }
}
