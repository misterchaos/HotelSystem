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
  Date: 2019/4/19
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.hyc.www.controller.constant.Methods" %>
<%@page import="com.hyc.www.controller.constant.Pages" %>

<html>
<head>
    <title>图片</title>
    <meta charset="utf-8">
    <meta content="width=1920,initial-scale=1.0,maximum-scale=1.0,user-scalable=no"
          id="viewport" name="viewport">
    <link rel="stylesheet"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<c:if test="${data==null}">
    <c:redirect url="${Pages.INDEX_JSP.toString()}"/>
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
                <li class="active"><a href="${Pages.LOGIN_JSP.toString()}">登陆</a></li>
                <li><a href="${Pages.REGIST_JSP.toString()}">注册</a></li>
            </ul>
        </div>
    </div>
</nav>
<c:if test="${message!=null}">
    <div class="alert alert-warning" style="margin-bottom: 0">
        <a id="message" href="#" class="close" data-dismiss="alert" >
            &times;
        </a>
        <strong>警告！</strong>${message}
    </div>

</c:if>




<c:if test="${data.pictrues.size()>0}">
    <c:forEach var="i" begin="0" end="${data.pictrues.size()-1}">
        <img src="/file/${date.pictrues[i]}" style="width: 500px ;float: left">
    </c:forEach>
</c:if>


</body>
</html>
