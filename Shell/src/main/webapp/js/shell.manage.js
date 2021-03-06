/**
 * Created by CoffeeFlavor on 2016/4/13.
 */
var websocket = null;

//判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
    websocket = new WebSocket("ws://192.168.199.66:8883/websocket");
} else {
    alert('Not support websocket')
}

//连接发生错误的回调方法
websocket.onerror = function () {
  alert("连接失败，请自行查看错误")
};

//连接成功建立的回调方法
websocket.onopen = function (event) {
   alert("连接成功")
}

//接收到消息的回调方法
websocket.onmessage = function () {
    $("#logAlert").append(event.data);
    $("#logAlert").scrollTop($("#logAlert")[0].scrollHeight);
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
function exec() {
    if (!($("#username").val().trim()&&$("#password").val().trim()&&$("#host").val().trim())) {
        alert("请输入相应的服务器身份信息");
        return;
    }
    if (!$("#command").val().trim()) {
        alert("command is empty");
        return;
    }

    var message = {
        "host": $("#host").val(),
        "username":$("#username").val(),
        "password":$("#password").val(),
        "command":$("#command").val()
    }
    websocket.send(JSON.stringify(message));
}
function clearLog(){
    $("#logAlert").empty();
}
