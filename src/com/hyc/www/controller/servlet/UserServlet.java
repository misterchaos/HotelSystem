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

import com.hyc.www.controller.constant.CtrlConsts;
import com.hyc.www.service.constant.ServeConsts;
import com.hyc.www.service.inter.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hyc.www.controller.constant.CtrlConsts.Pages.INDEX_PAGE;
import static com.hyc.www.controller.constant.CtrlConsts.Pages.REGIST_PAGE;

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
        CtrlConsts.Method method = CtrlConsts.Method.getValue(req.getParameter("method"));
        UpdateType updateType = UpdateType.getValue(method.name());
        switch (method) {
            case REGIST_VIEW:
                req.getRequestDispatcher(REGIST_PAGE.name()).forward(req, resp);
                return;
            case REGIST_DO:
                regist(req, resp);
                return;
            case LOGIN_DO:
                login(req, resp);
                return;
            case MY_INFO_DO:
                myInfo(req, resp);
                return;
            case MY_INFO_VIEW:
                return;
            case UPDATE_INFO_DO:
                update(req, resp,updateType);
                return;
            case UPDATE_PWD_DO:
                update(req, resp,updateType);
                return;
            case UPDATE_PAY_PWD_DO:
                update(req, resp,updateType);
                return;
            case LOGOUT_DO:
                return;
            case INDEX_VIEW:
                return;
            default:
                resp.sendRedirect(INDEX_PAGE.name());
        }

    }


    private void regist(HttpServletRequest req, HttpServletResponse resp) {
        UserService serv = (UserService) getServletContext().getAttribute("userService");
        ServeConsts.Status status = serv.regist(req, resp);
//TODO
        System.out.println(status.name());

        switch (status) {
            case ACCOUNT_ALREADY_EXIST:
                return;
            case DATA_ILLEGAL:
                return;
            case REGIST_SUCCESS:
            default:
        }

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        UserService serv = (UserService) getServletContext().getAttribute("userService");
        ServeConsts.Status status = serv.login(req, resp);
        //TODO debug
        System.out.println(status.name());
        switch (status) {
            case ACCOUNT_ALREADY_EXIST:
                return;
            case PASSWORD_INCORRECT:
                return;
            case LOGIN_SUCCESS:

            default:
        }
    }

    private void myInfo(HttpServletRequest req, HttpServletResponse resp) {
        UserService serv = (UserService) getServletContext().getAttribute("userService");
        ServeConsts.Status status = serv.myInfo(req, resp);
        //TODO debug
        System.out.println(status.name());
        switch (status) {
            case ACCOUNT_NOT_FOUNT:
                return;

            default:
        }

    }

    private void update(HttpServletRequest req, HttpServletResponse resp, UpdateType type) {
        UserService serv = (UserService) getServletContext().getAttribute("userService");
        ServeConsts.Status status=null;
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
                return;
            case UPDATE_SUCCESS:
                return;
            case ERROR:
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
        /**
         * 默认
         */
        DEFAULT;
        /**
         * 返回该名称对应的方法
         *
         * @param name 方法名称
         * @return 枚举项
         * @name getValue
         * @notice none
         * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
         * @date 2019/4/17
         */
        public static UpdateType getValue(String name) {
            for (UpdateType mt : UpdateType.values()) {
                if (mt.name().replace("update_","").replace("_do","").equalsIgnoreCase(name)) {
                    return mt;
                }
            }
            return DEFAULT;
        }
    }

}
