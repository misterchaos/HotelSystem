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

import com.hyc.www.controller.constant.Methods;
import com.hyc.www.controller.constant.Pages;
import com.hyc.www.service.constant.Status;
import com.hyc.www.service.inter.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static com.hyc.www.controller.constant.CacheConst.USER;
import static com.hyc.www.service.constant.Status.ACCOUNT_NOT_FOUNT;
import static com.hyc.www.service.constant.Status.SUCCESS;
import static com.hyc.www.util.ControllerUtils.*;


/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责接收与用户信息相关业务的请求
 * @date 2019-04-13 23:04
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Methods method = getMethod(req, resp);

        switch (method) {
            case REGIST_DO:
                regist(req, resp);
                return;
            case LOGIN_DO:
                login(req, resp);
                return;
            case FIND_DO:
                find(req, resp);
                return;
            case UPDATE_DO:
                update(req, resp);
                return;
            case LOGOUT_DO:
                return;

            default:
                resp.sendRedirect(Pages.INDEX_JSP.toString());
        }

    }


    private void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService serv = (UserService) getServletContext().getAttribute("userService");
        Status status = serv.regist(req, resp);
//TODO
        System.out.println(status.name());

        switch (status) {
            case ACCOUNT_ALREADY_EXIST:
                forward(req, resp, status.getData(), "此账户已经存在！", Pages.REGIST_JSP);
                return;
            case DATA_ILLEGAL:
                forward(req, resp, status.getData(), "输入不合法！(6-20位英文字母，数字或下划线)", Pages.REGIST_JSP);
                return;
            case SUCCESS:
                redirect(resp, Pages.LOGIN_JSP.toString());
            default:
        }

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService serv = (UserService) getServletContext().getAttribute("userService");
        Status status = serv.login(req, resp);
        //TODO debug
        System.out.println(status.name());
        switch (status) {
            case ACCOUNT_NOT_FOUNT:
                forward(req, resp, status.getData(), "找不到该用户！", Pages.LOGIN_JSP);
                return;
            case DATA_ILLEGAL:
                forward(req, resp, status.getData(), "输入不合法！(6-20位英文字母，数字或下划线)", Pages.LOGIN_JSP);

                return;
            case PASSWORD_INCORRECT:
                forward(req, resp, status.getData(), "密码不正确！", Pages.LOGIN_JSP);

                return;
            case SUCCESS:
                String userName = status.getData().getUsers().get(0).getName();
                if ("true".equalsIgnoreCase(req.getParameter("autoLogin"))) {

                    /**
                     * 设置自动登陆cookie
                     */
                    Cookie userCookie = new Cookie(USER.toString(), userName);
                    userCookie.setMaxAge(60 * 60 * 24 * 30);
                    resp.addCookie(userCookie);
                }
                /**
                 * 设置本次会话缓存
                 */
                HttpSession session = req.getSession();
                session.setAttribute(USER.toString(), userName);
                redirect(resp, Pages.INDEX_JSP.toString());
            default:
        }
    }


    private void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService serv = (UserService) getServletContext().getAttribute("userService");
        FindType type = FindType.valueOf(req.getParameter("find").toUpperCase());
        Status status = null;
        switch (type) {
            case THIS:
                status = serv.find(req, resp);
                if (status == SUCCESS) {
                    forward(req, resp, status.getData(), null, Pages.USER_JSP);

                } else if (status == ACCOUNT_NOT_FOUNT) {
                    forward(req, resp, status.getData(), "找不到该用户！", Pages.USER_JSP);
                }
                return;
            case ALL:
                status = serv.listAll(req, resp);
                if (status == SUCCESS) {
                    //TODO 要转发到管理员页面
                    forward(req, resp, status.getData(), null, Pages.INDEX_JSP);
                }
                return;
            default:
                redirect(resp, Pages.ERROR_JSP.toString());
        }
        //TODO debug
        System.out.println(status.name());

    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService serv = (UserService) getServletContext().getAttribute("userService");
        UpdateType type = UpdateType.valueOf(req.getParameter("update").toUpperCase());
        Status status = null;
        switch (type) {
            case INFO:
                status = serv.updateInfo(req, resp);
                break;
            case PWD:
                status = serv.updatePwd(req, resp);
                break;
            case PAY_PWD:
                status = serv.updatePayPwd(req, resp);
                break;
            default:
                break;
        }
        //TODO debug
        System.out.println(status.name());
        switch (status) {

            case DATA_ILLEGAL:
                forward(req, resp, status.getData(), "输入不合法!", Pages.USER_JSP);
                return;
            case SUCCESS:
                forward(req, resp, status.getData(), null, Pages.USER_JSP);
                return;
            default:
        }

    }


    enum UpdateType {
        /**
         * 更新个人信息，不包括密码
         */
        INFO,
        /**
         * 更新登陆密码
         */
        PWD,
        /**
         * 更新支付密码
         */
        PAY_PWD,

    }

    enum FindType {
        /**
         * 查找个人信息
         */
        THIS,
        /**
         * 查找所有用户
         */
        ALL,
        /**
         *
         */
    }

}
