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
  Date: 2019/4/7
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>
<c:if test="${data==null}">
    <c:redirect url="${pageContext.request.contextPath}/room?method=${Methods.FIND_DO.name()}&find=all"/>
</c:if>


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
            <a class="navbar-brand" href="/${Pages.INDEX_JSP.toString()}">X-HOTEL</a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                <c:if test="${data.users==null}">
                <li class="active"><a href="${Pages.LOGIN_JSP.toString()}">登陆</a></li>
                </c:if>
                <c:if test="${data.users!=null}">
                    <li class="active"><a href="${Pages.USER_JSP.toString()}">个人中心</a></li>
                </c:if>
                <li><a href="${Pages.REGIST_JSP.toString()}">注册</a></li>
                <li><label style="float: right;margin-right: 10px"></label></li>
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


<c:if test="${data.rooms.size()>0}">
    <c:forEach var="i" begin="0" end="${data.rooms.size()-1}">
        <div class="info-panel">
                <%-- 主图和名称--%>
            <div class="photo-name">
                <img class="main_info" src="/file/${data.rooms[i].photo}" width="150" height="150">
                <a href="${pageContext.request.contextPath}/room.jsp?view=room&number=${data.rooms[i].number}">
                    <h4>${data.rooms[i].name}</h4>
                </a>

            </div>
            <div class="room-info">
                <p>
                    房间名称： ${data.rooms[i].name}
                </p>
                <p>

                    房间编号：${data.rooms[i].number}

                </p>
                <p>
                    房间类型：${data.rooms[i].type}

                </p>
                <p>
                    房间面积：${data.rooms[i].area}

                </p>
                <p>
                    床宽：${data.rooms[i].bedWidth}|
                    预订状态：${data.rooms[i].bookStatus}|
                    房间等级：${data.rooms[i].level}|
                    房间评分：${data.rooms[i].score}|
                    评价数量：${data.rooms[i].remarkNum}
                </p>
                <strong>
                    <h4>
                        价格：${data.rooms[i].price}
                    </h4>
                </strong>


            </div>
            <div class="panel-body">
            </div>

        </div>
        <div class="color-input-field" style="
    height: 40px;">
            <form name="delete" onsubmit="return deleteRoom()"
                  action="${pageContext.request.contextPath}/room?method=${Methods.DELETE_DO}&number=${data.rooms[i].number}"
                  method="post">
                <input type="submit" class="form-control" value="删除房间" style="
        background-color: orangered;
        width: 200px;
        height: 40px;
        float:right;
        margin-right: 230px;
        color:#FFFFFF;">
            </form>
            <form name="update"
                  action="${pageContext.request.contextPath}/${Pages.ROOM_JSP.toString()}?view=update&number=${data.rooms[i].number}"
                  method="post">
                <input type="submit" class="form-control" value="修改房间" style="
        background-color: seagreen;
        width: 200px;
        height: 40px;
        float:right;
        margin-right: 10px;
        color:#FFFFFF;">
            </form>
        </div>
        <script>
            function

            deleteRoom() {
                if (confirm("此操作将会永久删除此房间，是否继续？")) {
                    return true;
                } else {
                    return false;
                }
            }

        </script>
    </c:forEach>
</c:if>
<style>
    .info-panel {
        width: 80%;
        position: relative;
        left: 10%;
        margin-top: 30px;
    }

    .photo-name {
        height: 180px;
        width: 20%;
        float: left;
        margin-right: 30px;

    }

    .room-info {
        height: 180px;
        width: 600px;
        position: relative;
        float: left;
    }

</style>

</body>
</html>
