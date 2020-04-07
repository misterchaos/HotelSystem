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
  Date: 2019/4/21
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.hyc.www.controller.constant.Methods" %>
<%@page import="com.hyc.www.controller.constant.Pages" %>

<html>
<head>
    <title>Xhotel</title>
    <meta charset="utf-8">
    <meta content="width=1920,initial-scale=1.0,maximum-scale=1.0,user-scalable=no"
          id="viewport" name="viewport">
    <link rel="stylesheet"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body >
<c:if test="${data==null}">
    <c:redirect url="/room?method=${Methods.FIND_DO.name()}&find=all&name=&page=1"/>
</c:if>

<div class="background"  >
</div>

<%-- 网页头部 --%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/${Pages.INDEX_JSP.toString()}">X-HOTEL</a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">

                <c:if test="${USER==null}">
                    <li class="active"><a href="${Pages.LOGIN_JSP.toString()}">登陆</a></li>
                </c:if>
                <c:if test="${USER!=null}">
                    <li class="active"></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">个人中心<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="${Pages.USER_JSP.toString()}?view=user&name=${USER}">查看个人信息</a></li>
                            <li><a href="${Pages.USER_JSP.toString()}?view=update&update=info&name=${USER}">编辑个人信息</a>
                            </li>
                            <li><a href="${Pages.USER_JSP.toString()}?view=update&update=pwd&name=${USER}">修改登陆密码</a>
                            </li>
                            <li>
                                <a href="${Pages.USER_JSP.toString()}?view=update&update=pay_pwd&name=${USER}">修改支付密码</a>
                            </li>
                            <li>
                                <a href="${Pages.ORDER_JSP.toString()}?view=order&user=${USER}">查看个人订单</a>
                            </li>
                            <li><a href="/user?method=${Methods.LOGOUT_DO.toString()}">退出登陆</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${ADMIN!=null}">
                    <li class="active"></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">管理员中心<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="${Pages.USER_JSP.toString()}?view=user&name=${USER}">查看酒店信息</a></li>
                            <li><a href="${Pages.USER_JSP.toString()}?view=update&update=info&name=${USER}">编辑酒店信息</a>
                            </li>
                            <li><a href="${Pages.ROOM_JSP.toString()}?view=add">添加房间</a></li>
                            <li><a href="${Pages.USER_JSP.toString()}?view=add">添加用户</a></li>
                            <li><a href="${Pages.USER_JSP.toString()}?view=update&update=pay_pwd&name=${USER}">添加服务</a>
                            </li>
                            <li><a href="/user?method=${Methods.LOGOUT_DO.toString()}">退出登陆</a></li>

                        </ul>
                    </li>
                </c:if>

                <li><a href="${Pages.REGIST_JSP.toString()}">注册</a></li>
                <li>
                    <form id="search" class="bs-example bs-example-form" role="form"
                          action="room?method=${Methods.FIND_DO}&find=name&page=1"
                          method="post">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="input-group"
                                     style="width: 400px; position: relative; left: 20%;margin-top: 15px">
                                    <input type="text" required="required" class="form-control" name="name"
                                           placeholder="请输入关键词" value="${param.name}">
                                    <span class="input-group-btn"><input type="submit" value="搜索"
                                                                         class="btn btn-default"></span>

                                </div>
                            </div>
                        </div>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>

<c:if test="${message!=null}">
<div class="alert alert-warning alert-dismissable">
    <button type="button" class="close" data-dismiss="alert"
            aria-hidden="true">
        &times;
    </button>
    提示：${message}
</div>
</c:if>

