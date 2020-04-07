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
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hyc.www.controller.constant.Methods" %>
<%@ page import="com.hyc.www.controller.constant.Pages" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>酒店</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<!-- 网页头部 -->
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
            <a class="navbar-brand" href="/${Pages.INDEX_JSP.toString()}">X-HOTEL</a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${Pages.LOGIN_JSP.toString()}">登陆</a></li>
                <li><a href="${Pages.REGIST_JSP.toString()}">注册</a></li>
                <c:if test="${login!=null}">
                    <li><a href="${pageContext.request.contextPath}/room?method=${Methods.ADD_DO}">添加酒店</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<c:if test="${message!=null}">
    <div class="alert alert-warning alert-dismissable" style="margin-bottom: 0">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
        提示：${message}
    </div>
</c:if>


<!-- 查看酒店信息 -->
<c:if test="${param.view=='room'}">
    <c:if test="${data==null}">
        <c:redirect
                url="/room?method=${Methods.FIND_DO.name()}&view=${param.view}&find=this&number=${param.number}"/>
    </c:if>
    <%-- 网页主体摘要--%>
    <div class="maxPage-summary" style="height: 500px;width:1920px">
        <div class="info-panel">
                <%-- 主图和名称--%>
            <div class="photo-name">
                <img class="main_info" src="/file/${data.hotels[0].photo}" width="300" height="300">
                <h3>${data.rooms[0].name}</h3>
            </div>
            <!-- 基本信息 -->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">酒店详情</h3>
                </div>
                <table class="table">
                    <tr>
                        <td>酒店名称：</td>
                        <td>${data.rooms[0].name}</td>
                    </tr>
                    <tr>
                        <td>酒店编号：</td>
                        <td>${data.rooms[0].number}</td>
                    </tr>
                    <tr>
                        <td>所属酒店：</td>
                        <td>${data.rooms[0].number}</td>
                    </tr>
                    <tr>
                        <td>酒店类型：</td>
                        <td>${data.rooms[0].type}</td>
                    </tr>
                    <tr>
                        <td>酒店级别：</td>
                        <td>${data.rooms[0].level}</td>
                    </tr>
                    <tr>
                        <td>酒店面积：</td>
                        <td>${data.rooms[0].area}</td>
                    </tr>
                    <tr>
                        <td>床宽：</td>
                        <td>${data.rooms[0].bedWidth}</td>
                    </tr>
                    <tr>
                        <td>酒店评分：</td>
                        <td>${data.rooms[0].score}</td>
                    </tr>
                    <tr>
                        <td>酒店价格：</td>
                        <td><strong><p style="color: red">$${data.rooms[0].price}</p></strong></td>
                    </tr>
                    <tr>
                        <td>备注信息：</td>
                    </tr>
                </table>
                <div class="panel-body">
                </div>
            </div>
        </div>
    </div>
    <!-- 购买链接-->
    <div class="color-input-field">
        <form action="${pageContext.request.contextPath}/${Pages.ORDER_JSP.toString()}?view=add&roomId=${data.rooms[0].id}&userId=${data.users[0].id}&user=${data.users[0].name}&room=${data.rooms[0].number}&hotel=1234&price=${data.rooms[0].price}" method="post">
            <input type="submit" class="form-control" value="立即预定" style="background-color: orangered;
        width: 270px;height: 50px;float:right;margin-right: 230px;color:#FFFFFF;">
        </form>
    </div>
    <%-- 网页主体细节--%>
    <div class="maxPage-detail">
    </div>
</c:if>


<%--修改/添加酒店 --%>
<c:if test="${param.view=='update'||param.view=='add'}">
    <c:if test="${param.view=='update'&&data==null}">
        <c:redirect
                url="/room?method=${Methods.FIND_DO}&view=${param.view}&find=this&number=${param.number}"/>
    </c:if>
    <%-- 网页主体摘要--%>
    <div class="maxPage-summary" style="height: 500px;width:1920px">
        <div class="info-panel">
            <c:if test="${param.view=='update'}">
            <form class="input-info"
                  action="${pageContext.request.contextPath}/room?method=${Methods.UPDATE_DO}&view=${param.view}"
                  method="post" enctype="multipart/form-data"></c:if>
                <c:if test="${param.view=='add'}">
                <form class="input-info"
                      action="${pageContext.request.contextPath}/room?method=${Methods.ADD_DO}&view=${param.view}"
                      method="post" enctype="multipart/form-data"></c:if>
                        <%-- 主图和名称--%>
                    <div class="photo-name">
                        <img class="main_info" src="/file/${data.rooms[0].photo}" width="300" height="300" alt="酒店图片">
                        <h3>${data.rooms[0].name}</h3>
                        <input type="file" class="file" name="photo" multiple>
                    </div>

                    <!-- 基本信息 -->
                    <div class="panel panel-default" style="margin-left: 30px ;width: 510px">
                        <div class="panel-heading">
                            <h3 class="panel-title">酒店详情</h3>
                        </div>
                        <div class="color-input-field" style="float: left;width: 500px;height: 520px">

                            <table class="table">
                                <tr>
                                    <td>酒店名称：</td>
                                    <td><input type="text" required="required" class="form-control" name="name"
                                               placeholder="请输入酒店名称" value="${data.rooms[0].name}" align="center"></td>
                                </tr>
                                <tr>
                                    <td>酒店编号：</td>
                                    <td><input type="text" required="required" class="form-control" name="number"
                                               placeholder="请输入酒店编号(唯一标识)" value="${data.rooms[0].number}"
                                               align="center">
                                    </td>
                                </tr>
                                <tr>
                                    <td>所属酒店：</td>
                                    <td>${data.hotels[0].name}</td>
                                </tr>
                                <tr>
                                    <td>酒店类型：</td>
                                    <td><input type="text" required="required" class="form-control" name="type"
                                               placeholder="请输入酒店类型" value="${data.rooms[0].type}" align="center"></td>
                                </tr>
                                <tr>
                                    <td>酒店级别：</td>
                                    <td><input type="text" required="required" class="form-control" name="level"
                                               placeholder="请输入酒店级别" value="${data.rooms[0].level}" align="center"></td>
                                </tr>
                                <tr>
                                    <td>酒店面积：</td>
                                    <td><input type="text" required="required" class="form-control" name="area"
                                               placeholder="请输入酒店面积(10-300)" value="${data.rooms[0].area}"
                                               align="center"></td>
                                </tr>
                                <tr>
                                    <td>床宽：</td>
                                    <td>
                                        <input type="text" required="required" class="form-control" name="bedWidth"
                                               placeholder="请输入酒店床宽(1-5)" value="${data.rooms[0].bedWidth}"
                                               align="center">
                                    </td>
                                </tr>
                                <tr>
                                    <td>酒店价格：</td>
                                    <td><input type="text" required="required" class="form-control" name="price"
                                               placeholder="请输入酒店价格(0-100000)" value="${data.rooms[0].price}"
                                               align="center"></td>
                                </tr>
                                <tr>
                                    <td>备注信息：</td>
                                    <td><input type="text" class="form-control" name="remark"
                                               placeholder="请输入备注信息(选填)" align="center"></td>
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
    <%-- 网页主体细节--%>
    <div class="maxPage-detail">

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
</style>
</html>

