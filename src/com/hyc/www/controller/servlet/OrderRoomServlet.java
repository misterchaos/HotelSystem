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
import com.hyc.www.service.inter.OrderRoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hyc.www.controller.constant.CtrlConsts.Method.getValue;
import static com.hyc.www.controller.constant.CtrlConsts.Pages.INDEX_PAGE;
import static com.hyc.www.service.constant.ServeConsts.Status.SUCCESS;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责房间订单的请求转发
 * @date 2019-04-17 01:31
 */
@WebServlet("/order/room")
public class OrderRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CtrlConsts.Method method = getValue(req.getParameter("method"));
        //TODO
        System.out.println(method.name());
        switch (method) {
            case ADD_ORDER_ROOM:
                add(req, resp);
                return;
            case DELETE_ORDER_ROOM:
                delete(req, resp);
                return;
            case INDEX_VIEW:
                return;
            default:
                resp.sendRedirect(INDEX_PAGE.name());
        }

    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderRoomService serv = (OrderRoomService) getServletContext().getAttribute("orderRoomService");
        ServeConsts.Status status = serv.add(req, resp);
        //TODO debug
        System.out.println(status.name());
        if (status == SUCCESS) {
            req.setAttribute("message", status);
            req.getRequestDispatcher(INDEX_PAGE.name()).forward(req, resp);
        } else {

        }

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        OrderRoomService serv = (OrderRoomService) getServletContext().getAttribute("orderRoomService");
        ServeConsts.Status status = serv.delete(req, resp);
        //TODO debug
        System.out.println(status.name());

    }

}
