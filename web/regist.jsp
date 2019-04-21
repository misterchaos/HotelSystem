<%--
  ~ Copyright (c) 2019.  黄钰朝
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~      http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Misterchaos
  Date: 2019/4/17
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hyc.www.controller.constant.Methods" %>
<%@ page import="com.hyc.www.controller.constant.Pages" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>${param.title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<%-- 页面头部--%>
<div class="login-head" style="height: 100px">
    <div class="jumbotron" style="padding-bottom: 20px;padding-top:20px;margin:0px">
        <a href="/${Pages.INDEX_JSP.toString()}"><h2 style="text-align: left">Xhotel酒店管理系统</h2></a>
    </div>
</div>

<c:if test="${message!=null}">
    <div class="alert alert-warning alert-dismissable" style="margin-bottom: 0">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
        提示：${message}
    </div>
</c:if>


<div class="login-body" style="overflow: hidden;position: absolute">
    <img src="${pageContext.request.contextPath}/login.jpg" width="1920" height="674">
</div>


<div class="login-body">
    <div class="login-layout">
        <div class="login-box">
            <div class="panel panel-default" style="padding: 55px;font-style: inherit">
                <strong>
                    <h2 class="panel-title" style="text-align: center">注册账号</h2>
                </strong>
                <div class="panel-body">
                    <div class="color-input-field">
                        <form name="login" action="${pageContext.request.contextPath}/user?method=${Methods.REGIST_DO}"
                              method="post">
                            <input type="text" required="required" class="form-control" name="name"
                                   placeholder="请输入用户名(6-20位英文字母，数字或下划线)" align="center">
                            <br>
                            <input type="password" required="required" class="form-control" name="password"
                                   placeholder="请输入密码(6-20位英文字母，数字或下划线)"
                                   align="center"><br>
                            <input type="submit" class="form-control" value="注册"
                                   style="background-color: darkorchid;color: #FFFFFF">
                        </form>
                        <br>
                        已有账号？<a href="${Pages.LOGIN_JSP.toString()}">请登陆</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<style type="text/css">

    .form-control {
        padding: 10px;
        height: 42px
    }


    .login-body {
        width: 100%;
        height: 800px;
    }

    .login-layout {
        position: relative;
        float: right;
        width: 500px;
        min-height: 540px;
        margin-right: 72px;
        margin-top: 40px;
    }

    .login-box {
        position: relative;
        left: 0;
        right: 0;
        top: 50%;
        background: #fff;
        padding: 20px 20px 20px, 20px;
        min-height: 370px;
        border-radius: 4px;
        -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, .1);
        box-shadow: 0 1px 6px rgba(0, 0, 0, .1);

    }


</style>
</html>
