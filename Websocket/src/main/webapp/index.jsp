<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>My WebSocket</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<style>
    .message_content {
        border: 1px solid #ddd;
        border-top-left-radius: 4px;
        width: 67%;
        height: 580px;
        margin: 50px 5px 20px 30px;
        display: inline-block;
        overflow: auto;
    }

    .member_side {
        border: 1px solid #ddd;
        border-top-left-radius: 4px;
        width: 20%;
        height: 580px;
        display: inline-block;
        /*background-color: white;*/
        position: relative;
        margin: 50px 30px 0px;
        float: right;
    }

    .member_side li {
        list-style-type: none;
    }

    .send {
        background-color: coral;
        width: 100px;
        height: 70px;
        border: 1px solid coral;
        border-radius: 8px;
        color: white;
        font-size: 25px;
        font-weight: 700;
        display: inline-block;
        float: right;
        margin-right: 70px;
        margin-top: 5px;
    }

    .message_input {
        height: 85px;
        width: 67%;
        margin-left: 20px;
        margin-bottom: 35px;
        border: 1px solid white;
        margin-right: 20px;
        resize: none;
        border-radius: 4px;
        display: inline-block;
    }

    a {
        cursor: pointer;
    }

    .chatMember {
        color: lightcoral;
        font-size: 25px;
        font-weight: 600;
        margin: 20px auto 40px 30px;
        position: absolute;
    }

    ::-webkit-scrollbar {
        width: 10px;
    }

    .chat-thread {
        height: 580px;
    }

    .chat-thread li {
        position: relative;
        clear: both;
        display: inline-block;
        padding: 16px 40px 16px 20px;
        margin: 0 0 20px 0;
        font: 16px/20px 'Noto Sans', sans-serif;
        border-radius: 10px;
        background-color: rgba(25, 147, 147, 0.2);
    }

    .chat-thread li:before {
        position: absolute;
        top: 0;
        width: 50px;
        height: 50px;
        border-radius: 50px;
        content: '';
    }

    .chat-thread li.self {
        animation: show-chat-odd 0.15s 1 ease-in;
        -moz-animation: show-chat-odd 0.15s 1 ease-in;
        -webkit-animation: show-chat-odd 0.15s 1 ease-in;
        float: right;
        margin-right: 80px;
        color: #0AD5C1;
    }

    .chat-thread li.self:before {
        right: -80px;
        background-image: url(logo.jpg);
    }

    .chat-thread li.self:after {
        border-right: 15px solid transparent;
        right: -15px;
    }

    .chat-thread li.friend:after {
        border-left: 15px solid transparent;
        left: -15px;
    }

    .chat-thread li.friend {
        animation: show-chat-even 0.15s 1 ease-in;
        -moz-animation: show-chat-even 0.15s 1 ease-in;
        -webkit-animation: show-chat-even 0.15s 1 ease-in;
        float: left;
        margin-left: 80px;
        color: #0EC879;
    }

    .chat-thread li.friend:before {
        left: -80px;
        background-image: url(logo.jpg);
    }

    .chat-thread li:after {
        position: absolute;
        top: 15px;
        content: '';
        width: 0;
        height: 0;
        border-top: 15px solid rgba(25, 147, 147, 0.2);
    }

    li span {
        color: red;
    }
    .myself{
        color:lawngreen;
        font-weight: 600;
    }
</style>

<div id="chat" class=""
     style="width:50%;margin-left: 20%;margin-top: 100px;background-color: rgba(173, 137, 58, 0.12);">
    <div id="chatMember" class="chatMember"></div>
    <div>
        <div id="content" class="message_content">
            <ul class="chat-thread" id="content_list">
            </ul>
        </div>
        <div id="site" class="member_side">
            <ul><li id="myself" class="myself"></li></ul>
            <ul id="friendList">
            </ul>
        </div>
    </div>
    <div>
        <textarea id="text" class="message_input"></textarea>
        <button class="send" onclick="send()">发送</button>
        <input type="hidden" id="toMember">
    </div>
</div>
<div id="login">
    请输入你的用户名
    <input type="text" id="member">
    <button onclick="login()">Send</button>
</div>
<div id="message">
</div>
</body>
<script type="text/javascript">
    window.onload = function () {
        document.getElementById("login").style.display = "block";
        document.getElementById("chat").style.display = "none";
    }
    var websocket = null;

    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://192.168.199.66:8082/websocket");
    }
    else {
        alert('Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("error");
    };

    //连接成功建立的回调方法
    websocket.onopen = function (event) {
        setMessageInnerHTML("open");
    }

    //接收到消息的回调方法
    websocket.onmessage = function () {
        var json = JSON.parse(event.data);
        if (json.status == "frendList") {
            if (json.friends.length > 0) {
                var appendhtml = "";
                for (i = 0; i < json.friends.length; i++) {
                    if (json.friends[i]!=document.getElementById('member').value){
                        appendhtml += " <li> <a onclick=\"toMember(this)\">" + json.friends[i] + "</a> </li>"
                    }
                }
                document.getElementById("friendList").innerHTML = appendhtml;
            }
        } else if (json.status == "frendAdd") {
            var oldHtml = document.getElementById("friendList").innerHTML;
            document.getElementById("friendList").innerHTML = oldHtml + " <li> <a onclick=\"toMember(this)\">" + json.friend + "</a> </li>";
        } else if (json.status == "message") {
            if (json.message.length > 0) {
                var oldHtml = document.getElementById("content_list").innerHTML;
                document.getElementById("content_list").innerHTML = oldHtml + " <li class=\"friend\"><span>" + json.from + "&nbsp;:&nbsp;</span>" + json.message + "</li>";
            }
        }
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("close");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        websocket.close();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }


    //关闭连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    function send() {
        if (document.getElementById('toMember').value.trim().length <= 0) {
            alert("请选择要发送的用户");
            return;
        }
        if (document.getElementById('text').value.trim().length <= 0) {
            alert("请输入要发送的内容");
            return;
        }
        var message = {
            "message": document.getElementById('text').value,
            "toMember": document.getElementById('toMember').value,
            "user": document.getElementById('member').value,
            "isLogin": false
        }

        var oldHtml = document.getElementById("content_list").innerHTML;
        document.getElementById("content_list").innerHTML = oldHtml + " <li class=\"self\"><span> @" + document.getElementById('toMember').value + "&nbsp;:&nbsp;</span>" + document.getElementById('text').value + "</li>";
        websocket.send(JSON.stringify(message));
    }
    function login() {
        var message = {
            "member": document.getElementById('member').value,
            "isLogin": true
        }
        websocket.send(JSON.stringify(message));
        document.getElementById("login").style.display = "none";
        document.getElementById("chat").style.display = "block";
        document.getElementById("myself").innerHTML="I am : "+document.getElementById('member').value;
    }
    function toMember(obj) {
        document.getElementById("chatMember").innerHTML = "正在与" + obj.innerHTML + "聊天...";
        document.getElementById("toMember").value = obj.innerHTML;
    }
</script>
</html>