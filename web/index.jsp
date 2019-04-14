<%@ page import="java.util.Map" %><%--
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
<html>
<head>
  <title>week3</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet"
        href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<div class="container">
  <div class="jumbotron">
    <h1 align="center">QG weekcamp</h1>
    <p>请填写信息</p>
    <%
      Map<String, String> msg = (Map<String, String>) request.getAttribute("message");
      if (msg != null) {
        out.print("<hr><p>提示信息：您的输入不合法，请重新填写注册信息</p><p>\n");
        for (String key : msg.keySet()) {
          out.print(msg.get(key) + "<br/>");
        }
        out.print("</p>");
      }
    %>
  </div>
  <div class="jumbotron" style="width:auto">
    <div class="color-input-field" style="width: auto">
      <form action="/User" method="post">
        <input type="text" class="form-control" name="userName" placeholder="请输入用户名"/> <br/>
        <input type="text" class="form-control" name="password" placeholder="请输入密码"/><br/>
        <input type="text" class="form-control" name="nickName" placeholder="请输入昵称"/><br/>
        性别:
        <input type="radio" name="gender" checked="checked" value="男"/>男
        <input type="radio" name="gender" value="女"/>女<br/><br/>
        </br>
        <a href="/User?method=注册">
          <button name="method" class="btn btn-primary" value="注册">注册</button>
        </a>

      </form>
      <a href="/login.jsp">
        <button name="method" class="btn btn-primary" value="登陆">前往登陆</button>
      </a>

    </div>
  </div>
</div>
</body>
</html>
