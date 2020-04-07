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
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hyc.www.controller.constant.Methods" %>
<%@ page import="com.hyc.www.controller.constant.Pages" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>订单</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=1920,initial-scale=1.0,maximum-scale=1.0,user-scalable=yes">
    <link rel="stylesheet"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>



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
            <a class="navbar-brand" href="/${Pages.INDEX_JSP.toString()}">X-HOTEL</a>
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


<!-- 查看订单信息 -->
<c:if test="${param.view=='order'}">
    <c:if test="${data==null}">
        <c:redirect
                url="/order_room?method=${Methods.FIND_DO.name()}&view=${param.view}&find=user&user=${param.user}"/>
    </c:if>
    <c:if test="${data.orderRooms.size()==0}">
        <div class="alert alert-warning alert-dismissable" style="margin-bottom: 0">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
            提示：您目前没有订单！
        </div>
    </c:if>
    <c:if test="${data.orderRooms.size()>0}">

    <c:forEach begin="0" end="${data.orderRooms.size()-1}" var="i">

        <%-- 网页主体摘要--%>
        <div class="maxPage-summary" style="height: 0px;width:1920px">
            <div class="info-panel" style="height: 0px;margin-top: 0px;padding-top:100px">
                    <%-- 主图和名称--%>
                <div class="photo-name">
                    <a href="${pageContext.request.contextPath}/room.jsp?view=room&number=${data.rooms[i].number}">
                    <img class="main_info" src="/file/${data.rooms[i].photo}" width="300" height="300">
                        <h3>${data.rooms[i].name}</h3></a>
                </div>
                <!-- 基本信息 -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">订单详情</h3>
                    </div>
                    <table class="table">
                        <tr>
                            <td>订单编号：</td>
                            <td>${data.orderRooms[i].number}</td>
                        </tr>
                        <tr>
                            <td>用户账号：</td>
                            <td>${data.users[i].name}</td>
                        </tr>
                        <tr>
                            <td>用户昵称：</td>
                            <td>${data.users[i].nickName}</td>
                        </tr>
                        <tr>
                            <td>房间编号：</td>
                            <td>${data.rooms[i].number}</td>
                        </tr>
                        <tr>
                            <td>房间名：</td>
                            <td>${data.rooms[i].name}</td>
                        </tr>
                        <tr>
                            <td>入住时间：</td>
                            <td>${data.orderRooms[i].startTime}</td>
                        </tr>
                        <tr>
                            <td>离开时间：</td>
                            <td>${data.orderRooms[i].endTime}</td>
                        </tr>
                        <tr>
                            <td>订单金额：</td>
                            <td>$${data.orderRooms[i].amount}</td>
                        </tr>
                        <tr>
                            <td>备注信息：</td>
                            <td>${data.orderRooms[i].remark}</td>
                        </tr>
                        <tr>
                            <td>创建时间：</td>
                            <td>${data.orderRooms[i].gmtCreate}</td>
                        </tr>
                    </table>
                    <div class="panel-body">
                    </div>
                </div>
            </div>
        </div>
        <!-- 购买链接-->
        <div class="color-input-field" style="    margin-bottom: 50px;width: 100%">
            <form action="${pageContext.request.contextPath}/order_room?method=${Methods.DELETE_DO}&number=${data.orderRooms[i].number}"
                  method="post" onsubmit="return delete_order()">
                <input type="submit" class="form-control" value="取消订单" style="background-color: orangered;
        width: 270px;height: 50px;float:right;margin-right: 230px;margin-bottom:50px;color:#FFFFFF;z-index: 999" >
            </form>
        </div>
        <script>
            function delete_order() {
                if (confirm("此操作将会永久删除此订单，是否继续？")) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </c:forEach>
    </c:if>
</c:if>


<%--添加订单 --%>
<c:if test="${param.view=='add'}">

    <%-- 网页主体摘要--%>
    <div class="maxPage-summary" style="height: 500px;width:1920px">
        <div class="info-panel">
            <form class="input-info"
                  action="${pageContext.request.contextPath}/order_room?method=${Methods.ADD_DO}&view=add&roomId=${param.roomId}&userId=${param.userId}&user=${USER}&room=${param.room}&hotel=1234&price=${param.price}"
                  method="post">
                <!-- 基本信息 -->
                <div class="panel panel-default" style="margin-left: 30px ;width: 510px;margin-top: 100px">
                    <div class="panel-heading">
                        <h3 class="panel-title">订单详情</h3>
                    </div>
                    <div class="color-input-field" style="float: left;width: 500px;height: 520px">

                        <table class="table">
                            <tr>
                                <td>订单编号：</td>
                                <td><input type="text" readonly="readonly" required="required" class="form-control"
                                           name="number"
                                           value="${Math.random()}" align="center">
                                </td>
                            </tr>
                            <tr>

                                <input type="text" readonly="readonly" hidden="hidden" value="${param.userId}"
                                       name="userId">

                            </tr>
                            <tr>
                                <td>房间编号：</td>
                                <td><input type="text" readonly="readonly" required="required" class="form-control"
                                           name="roomNumber"
                                           value="${param.room}" align="center"></td>
                                <input type="text" readonly="readonly" hidden="hidden" value="${param.roomId}"
                                       name="roomId">

                            </tr>
                            <tr>
                                <td>用户账号：</td>
                                <td><input type="text" readonly="readonly" required="required" class="form-control"
                                           name="user"
                                           value="${param.user}" align="center"></td>
                            </tr>
                            <tr>
                                <td>入住时间：</td>
                                <td><input type="date" required="required" class="form-control" name="startTime"
                                           placeholder="请选择入住时间" align="center"></td>
                            </tr>
                            <tr>
                                <td>离开时间：</td>
                                <td><input type="date" required="required" class="form-control" name="endTime"
                                           placeholder="请选择离开时间" align="center"></td>
                            </tr>
                            <tr>
                                <td>订单金额：</td>
                                <td><input type="text" readonly="readonly" required="required" class="form-control"
                                           name="amount"
                                           value="${param.price}" align="center"></td>
                            </tr>
                            <tr>
                                <td>备注信息：</td>
                                <td><input type="text" class="form-control" name="remark"
                                           placeholder="请输入备注信息" align="center"></td>
                            </tr>
                            <tr>
                                <td>执行操作：</td>
                                <td><input type="submit" class="form-control" value="提交订单" style="background-color: orangered;
                        width: 270px;height: 50px;float:right;margin-right: 10px;color:#FFFFFF;"></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </form>
        </div>
    </div>


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
    .navbar-default {
        width: 100%;
        position: fixed;
        z-index: 999;
        margin-top: 0;
    }

    .alert-warning {
        margin-bottom: 0;
        z-index: 998;
        position: fixed;
        margin-top: 65px;
        width: 100%;
    }
</style>


</html>
