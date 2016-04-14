<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。
    pageContext.setAttribute("basePath", basePath);
%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Shell</title>
    <!-- Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">


    <style>
        .set {
            margin-top: 25px;
            margin-left: 25px;
            display: inline-block;
        }

        .log {
            color: rgb(66, 195, 149);
            font-size: 14px;
            overflow-y: auto;
            height: 600px;
            margin-left: 30px;
        }

        .log-div {
            background-color: rgba(23, 20, 7, 0.8);
        }
        .log span{
            color: rgb(171, 140, 21);
        }
        span.command_info {
            color: rgba(193, 182, 33, 0.94);
            font-size: 20px;
        }
    </style>
</head>
<body>
<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/shell.manage.js"></script>
<div class="panel panel-primary" style="width: 80%;margin: 20px auto">
    <div class="panel-heading">Shell</div>
    <div class="panel-body">
        <form class="">
            <div class="col-lg-12">
                <div class="form-group col-lg-3">
                    <label for="host">Host</label>
                    <input type="text" id="host" class="form-control" value="192.168.199.36"/>

                </div>
                <div class="form-group col-lg-3">
                    <label for="username">用户名</label>
                    <input type="text" id="username" class="form-control" value="root"/>

                </div>
                <div class="form-group col-lg-3">
                    <label for="password">密码</label>
                    <input type="password" id="password" class="form-control" value="huama"/>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="form-group col-lg-6">
                    <label for="command">Linux Command</label>
                    <input id="command" class="form-control"/>
                </div>
                <div class="form-group col-lg-2">
                    <button type="button" class="btn btn-primary set" onclick="exec()">
                        &nbsp;exec
                    </button>
                </div>

            </div>

        </form>
    </div>
    <div style="padding: 8px;color: white;background-color: rgba(20, 51, 58, 0.74);text-align: center;font-weight: 800;font-size: 20px" >console
    <button type="button" style="float: right;vertical-align: middle;background-color: rgba(20, 51, 58, 0.74);border: 1px solid rgba(20, 51, 58, 0.74)" onclick="clearLog()">clear</button>
    </div>
    <div class="log-div">
        <div class="log" id="logAlert">
        </div>
    </div>
</div>


</body>
</html>