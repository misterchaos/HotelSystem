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
import com.hyc.www.service.Result;
import com.hyc.www.service.constant.Status;
import com.hyc.www.service.inter.OrderRoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hyc.www.util.ControllerUtils.forward;
import static com.hyc.www.util.ControllerUtils.getMethod;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责房间订单的请求转发
 * @date 2019-04-17 01:31
 */
@WebServlet("/order_room")
public class OrderRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Methods method = getMethod(req, resp);

        switch (method) {
            case ADD_DO:
                add(req, resp);
                return;
            case DELETE_DO:
                delete(req, resp);
                return;
            case FIND_DO:
                find(req, resp);
                return;
            default:
                resp.sendRedirect(Pages.INDEX_JSP.toString());
        }

    }

    private void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderRoomService serv = (OrderRoomService) getServletContext().getAttribute("orderRoomService");
        FindType type = FindType.valueOf(req.getParameter("find").toUpperCase());
        Result result = null;


        switch (type) {
            case NUMBER:
                result = serv.find(req, resp);
                break;
            case USER:
                result = serv.listByUserName(req, resp);
                break;
            default:
        }

        Status status = result.getStatus();

        switch (status) {
            case NOT_FOUNT:
                forward(req, resp, result.getData(), "没有相关订单！", Pages.ORDER_JSP);
                return;
            case SUCCESS:
                forward(req, resp, result.getData(), "您的订单如下！", Pages.ORDER_JSP);
                return;
            default:
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderRoomService serv = (OrderRoomService) getServletContext().getAttribute("orderRoomService");
        Result result = serv.add(req, resp);
        Status status = result.getStatus();

        switch (status) {
            case ALREADY_BOOKED:
                forward(req, resp, result.getData(), "房间已被预订！", Pages.ORDER_JSP);
                return;
            case SUCCESS:
                forward(req, resp, result.getData(), "订单添加成功！请手动返回主页", Pages.SUCCESS_JSP);
                return;
            default:
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderRoomService serv = (OrderRoomService) getServletContext().getAttribute("orderRoomService");
        Result result = serv.delete(req, resp);
        Status status = result.getStatus();

        switch (status) {
            case SUCCESS:
                forward(req, resp, result.getData(), "订单取消成功！", Pages.SUCCESS_JSP);
                return;
            default:
        }
    }

    enum FindType {
        /**
         * 通过订单编号
         */
        NUMBER,
        /**
         * 通过用户id
         */
        USER,
    }

}
