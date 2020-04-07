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
  Date: 2019/4/20
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hyc.www.controller.constant.Methods" %>
<%@ page import="com.hyc.www.controller.constant.Pages" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>个人中心</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=1920,initial-scale=1.0,maximum-scale=1.0,user-scalable=yes">
    <link rel="stylesheet"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="background"  >
</div>

<%-- 网页头部 --%>
<nav class="navbar navbar-default" role="navigation" style="margin-bottom: 0px">
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
                            <li><a href="/hotel.html">查看酒店信息</a></li>
                            <li><a href="${Pages.ROOM_JSP.toString()}?view=add">添加房间</a></li>
                            <li><a href="${Pages.USER_JSP.toString()}?view=add">添加用户</a></li>
                            <li><a href="/user?method=${Methods.LOGOUT_DO.toString()}">退出登陆</a></li>

                        </ul>
                    </li>
                </c:if>

                <li><a href="${Pages.REGIST_JSP.toString()}">注册</a></li>
                <li><a href="${Pages.REMARK_JSP.toString()}">留言板</a></li>
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
<div class="background"  style="        background-image: linear-gradient(45deg,#40B028,#1B6EC6);
        position: fixed;
        height: 100%;
        width: 100%;">
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


<!-- 查看个人信息 -->
<c:if test="${param.view=='user'}">
    <c:if test="${data==null}">
        <c:redirect
                url="/user?method=${Methods.FIND_DO.toString()}&view=${param.view}&find=this&name=${param.name}"/>
    </c:if>
    <%-- 网页主体摘要--%>
    <div class="maxPage-summary" style="height: 500px;width:1920px">
        <div class="info-panel" style="margin-top: 30px">
                <%-- 主图和名称--%>
            <div class="photo-name">
                <img class="main_info" src="/file/${data.users[0].photo}" width="300" height="300">
                <h3>${data.users[0].name}</h3>
            </div>
            <!-- 基本信息 -->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">我的个人信息</h3>
                </div>
                <table class="table">
                    <tr>
                        <td>用户名：</td>
                        <td>${data.users[0].name}</td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td>*******</td>
                    </tr>
                    <tr>
                        <td>电话号码：</td>
                        <td>${data.users[0].phoneNumber}</td>
                    </tr>
                    <tr>
                        <td>身份证号：</td>
                        <td>${data.users[0].idNumber}</td>
                    </tr>
                    <tr>
                        <td>用户类型：</td>
                        <td>${data.users[0].type}</td>
                    </tr>

                    <tr>
                        <td>昵称：</td>
                        <td>${data.users[0].nickName}</td>
                    </tr>
                    <tr>
                        <td>账户余额：</td>
                        <td>${data.users[0].balance}</td>
                    </tr>
                    <tr>
                        <td>支付密码：</td>
                        <td>******</td>
                    </tr>
                </table>
                <div class="panel-body">
                </div>
            </div>
        </div>
    </div>
    <div class="color-input-field">
    <!-- 链接-->
        <form action="${pageContext.request.contextPath}/${Pages.USER_JSP.toString()}?view=update&update=info&name=${data.users[0].name}"
              method="post">
            <input type="submit" class="form-control" value="修改信息" style="background-color: orangered;
        width: 270px;height: 50px;float:right;margin-right: 230px;color:#FFFFFF;">
        </form>
    </div>
    <%-- 网页主体细节--%>
    <div class="maxPage-detail">
    </div>
</c:if>

<%--添加用户--%>
<c:if test="${param.view=='add'}">
    <%-- 网页主体摘要--%>
    <div class="maxPage-summary" style="height: 500px;width:1920px">
        <div class="info-panel" style="margin-top: 30px">
            <form class="input-info"
                  action="${pageContext.request.contextPath}/user?method=${Methods.ADD_DO}&view=${param.view}"
                  method="post" enctype="multipart/form-data">
                    <%-- 主图和名称--%>
                <div class="photo-name">
                    <img class="main_info" src="/file/${data.users[0].photo}" width="300" height="300" alt="用户图片">
                    <h3>${data.users[0].name}</h3>
                    <input type="file" class="file" name="photo">
                </div>
                <!-- 基本信息 -->

                <div class="panel panel-default" style="margin-left: 30px ;width: 510px">
                    <div class="panel-heading">
                        <h3 class="panel-title">添加新用户</h3>
                    </div>
                    <div class="color-input-field" style="float: left;width: 500px;height:fit-content">
                        <table class="table">
                            <tr>
                                <td>用户名：</td>
                                <td><input type="text" required="required" class="form-control"
                                           placeholder="请输入用户名(6-20位英文字母，数字或下划线)" align="center" name="name">
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td><input type="password" required="required" class="form-control" name="password"
                                           placeholder="请输入登陆密码(6-20位英文字母，数字或下划线)" align="center"></td>
                            </tr>
                            <tr>
                                <td>电话号码：</td>
                                <td><input type="text" required="required" class="form-control" name="phoneNumber"
                                           placeholder="请输入电话号码(国内号码)" value="${data.users[0].phoneNumber}"
                                           align="center"></td>
                            </tr>
                            <tr>
                                <td>用户类型：</td>
                                <td><input type="text" class="form-control" name="type"
                                           value="USER" readonly="readonly"
                                           align="center"></td>
                            </tr>
                            <tr>
                                <td>身份证号：</td>
                                <td><input type="text" required="required" class="form-control" name="idNumber"
                                           placeholder="请输入身份证号" value="${data.users[0].idNumber}" align="center">
                                </td>
                            </tr>
                            <tr>
                                <td>昵称：</td>
                                <td><input type="text" required="required" class="form-control" name="nickName"
                                           placeholder="请输入昵称(长度小于20字符)" value="${data.users[0].nickName}"
                                           align="center">
                                </td>
                            </tr>

                            <tr>
                                <td>执行操作：</td>
                                <td><input type="submit" class="form-control" value="提交" style="background-color: orangered;
                        width: 270px;height: 50px;float:right;margin-right: 10px;color:#FFFFFF;"></td>
                            </tr>

                        </table>
                    </div>
                </div>
            </form>
        </div>
    </div>
</c:if>


<%--更新用户信息--%>
<c:if test="${param.view=='update'}">
    <c:if test="${data==null}">
        <c:redirect
                url="/user?method=${Methods.FIND_DO}&find=this&update=${param.update}&view=${param.view}&name=${param.name}"/>
    </c:if>

    <%--更新基本信息--%>
    <c:if test="${param.update=='info'}">
        <%-- 网页主体摘要--%>
        <div class="maxPage-summary" style="height: 500px;width:1920px">
            <div class="info-panel">
                    <%-- 主图和名称--%>
                <form class="input-info"
                      action="${pageContext.request.contextPath}/user?method=${Methods.UPDATE_DO}&update=info&info=info&view=${param.view}"
                      method="post" enctype="multipart/form-data">
                    <div class="photo-name">
                        <img class="main_info" src="/file/${data.users[0].photo}" width="300" height="300" alt="用户图片">
                        <h3>${data.users[0].name}</h3>
                        <input type="file"  class="file" name="photo">
                    </div>
                    <!-- 基本信息 -->
                    <div class="panel panel-default" style="margin-left: 30px ;width: 510px">
                        <div class="panel-heading">
                            <h3 class="panel-title">更新用户信息</h3>
                        </div>
                        <div class="color-input-field" style="float: left;width: 500px;height:fit-content">
                            <table class="table">
                                <tr>
                                    <td>用户名：</td>
                                    <td><input type="text" readonly="readonly" required="required" class="form-control"

                                               placeholder="${data.users[0].name}(不可修改)" align="center">
                                        <input type="text" hidden="hidden" value="${data.users[0].name}" name="name">
                                    </td>
                                </tr>

                                <tr>
                                    <td>电话号码：</td>
                                    <td><input type="text" required="required" class="form-control" name="phoneNumber"
                                               placeholder="请输入电话号码(国内号码)" value="${data.users[0].phoneNumber}"
                                               align="center"></td>
                                </tr>
                                <tr>
                                    <td>身份证号：</td>
                                    <td><input type="text" required="required" class="form-control" name="idNumber"
                                               placeholder="请输入身份证号" value="${data.users[0].idNumber}" align="center">
                                    </td>
                                </tr>
                                <tr>
                                    <td>昵称：</td>
                                    <td><input type="text" required="required" class="form-control" name="nickName"
                                               placeholder="请输入昵称(长度小于20字符)" value="${data.users[0].nickName}"
                                               align="center">
                                    </td>
                                </tr>

                                <tr>
                                    <td>执行操作：</td>
                                    <td><input type="submit" class="form-control" value="提交" style="background-color: orangered;
                        width: 270px;height: 50px;float:right;margin-right: 10px;color:#FFFFFF;"></td>
                                </tr>

                            </table>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </c:if>

    <%--更新登陆密码--%>
    <c:if test="${param.update=='pwd'}">
        <%-- 网页主体摘要--%>
        <div class="maxPage-summary" style="height: 500px;width:1920px">
            <div class="info-panel">
                <form class="input-info"
                      action="${pageContext.request.contextPath}/user?method=${Methods.UPDATE_DO}&update=pwd&view=${param.view}"
                      method="post">
                    <!-- 基本信息 -->
                    <div class="panel panel-default" style="margin-left: 30px ;width: 510px">
                        <div class="panel-heading">
                            <h3 class="panel-title">修改登陆密码</h3>
                        </div>
                        <div class="color-input-field" style="float: left;width: 500px;height:fit-content">
                            <table class="table">
                                <tr>
                                    <td>用户名：</td>
                                    <td><input type="text" readonly="readonly" required="required" class="form-control"

                                               placeholder="${data.users[0].name}(不可修改)" align="center">
                                        <input type="text" hidden="hidden" value="${data.users[0].name}" name="name">
                                    </td>
                                </tr>
                                <tr>
                                    <td>旧密码：</td>
                                    <td><input type="password" required="required" class="form-control" name="password"
                                               placeholder="请输入旧密码(6-20位英文字母，数字或下划线)" align="center"></td>
                                </tr>
                                <tr>
                                    <td>新密码：</td>
                                    <td><input type="password" required="required" class="form-control" name="newPwd"
                                               placeholder="请输入新密码(6-20位英文字母，数字或下划线)" align="center">
                                    </td>
                                </tr>
                                <tr>
                                    <td>执行操作：</td>
                                    <td><input type="submit" class="form-control" value="提交" style="background-color: orangered;
                        width: 270px;height: 50px;float:right;margin-right: 10px;color:#FFFFFF;"></td>
                                </tr>

                            </table>
                        </div>
                    </div>
                </form>
            </div>
        </div>


    </c:if>

    <%--更新支付密码--%>
    <c:if test="${param.update=='pay_pwd'}">
        <%-- 网页主体摘要--%>
        <div class="maxPage-summary" style="height: 500px;width:1920px">
            <div class="info-panel">
                <form class="input-info"
                      action="${pageContext.request.contextPath}/user?method=${Methods.UPDATE_DO}&update=pay_pwd&view=${param.view}"
                      method="post">
                    <!-- 基本信息 -->
                    <div class="panel panel-default" style="margin-left: 30px ;width: 510px">
                        <div class="panel-heading">
                            <h3 class="panel-title">修改支付密码</h3>
                        </div>
                        <div class="color-input-field" style="float: left;width: 500px;height:fit-content">
                            <table class="table">
                                <tr>
                                    <td>用户名：</td>
                                    <td><input type="text" readonly="readonly" required="required" class="form-control"

                                               placeholder="${data.users[0].name}(不可修改)" align="center">
                                        <input type="text" hidden="hidden" value="${data.users[0].name}" name="name">
                                    </td>
                                </tr>
                                <tr>
                                    <td>旧密码：</td>
                                    <td><input type="password" required="required" class="form-control" name="payPwd"
                                               placeholder="请输入旧密码(默认初始密码为123456)" align="center"></td>
                                </tr>
                                <tr>
                                    <td>新密码：</td>
                                    <td><input type="password" required="required" class="form-control" name="newPwd"
                                               placeholder="请输入新密码(6-20位英文字母，数字或下划线)" align="center">
                                    </td>
                                </tr>
                                <tr>
                                    <td>执行操作：</td>
                                    <td><input type="submit" class="form-control" value="提交" style="background-color: orangered;
                        width: 270px;height: 50px;float:right;margin-right: 10px;color:#FFFFFF;"></td>
                                </tr>

                            </table>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </c:if>

</c:if>


<!-- 扩展信息 -->

<div class="maxPage-extension">

</div>

</body>

<style>
    <%-- 信息摘要仪表盘 --%>
    .info-panel {
        height: 600px;
        width: 90%;
        position: relative;
        left: 5%;
    }

    .photo-name {
        height: 400px;
        width: 20%;
        float: left;

    }

    .panel-default {
        border-color: #ddd;
        width: 50%;
        float: left;
    }

    .color-input-field {
        height: 20px;
        width: 150px;
        position: relative;
        float: right;
    }

    .alert-warning {
        margin-bottom: 0;
        z-index: 998;
        position: fixed;
        margin-top: 0px;
        width: 100%;
    }
</style>
</html>
