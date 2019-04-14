/*
 * Copyright (c) 2019.  黄钰朝
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hyc.www.controller.servlet;

import com.hyc.www.controller.constant.ControlConsts.Methods;
import com.hyc.www.service.inter.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hyc.www.controller.constant.ControlConsts.Pages.INDEX_PAGE;
import static com.hyc.www.controller.constant.ControlConsts.Pages.REGIST_PAGE;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责接收与用户信息相关业务的请求
 * @date 2019-04-13 23:04
 */
@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO
        System.out.println(req.getParameter("method"));
        Methods method = Methods.valueOf(req.getParameter("method"));
        /**
         * 将请求传入service层
         */
        //TODO debug
        System.out.println("method = "+method.name());
        switch (method) {
            case REGIST_VIEW:
                req.getRequestDispatcher(REGIST_PAGE.name()).forward(req,resp);
                return;
            case REGIST_DO:
                regist(req, resp);
                return;
            case LOGIN_DO:
                return;
            case LOGOUT_DO:
                return;
            default:
                resp.sendRedirect(INDEX_PAGE.name());
        }

    }

    private void regist(HttpServletRequest req, HttpServletResponse resp){
        UserService serv = (UserService) getServletContext().getAttribute("userService");
        serv.regist(req,resp);
        try {
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
