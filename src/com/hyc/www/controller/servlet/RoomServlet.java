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
import com.hyc.www.exception.ServiceException;
import com.hyc.www.service.constant.Status;
import com.hyc.www.service.inter.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hyc.www.service.constant.Status.SUCCESS;
import static com.hyc.www.util.ControllerUtils.*;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责房间相关服务和显示请求的转发
 * @date 2019-04-17 00:09
 */
@MultipartConfig(location = "C:/Users/Misterchaos/Documents/Java Develop Workplaces/IDEA workspace/HotelSystem/web/file/photo")
@WebServlet(value = "/room")
public class RoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Methods method = getMethod(req, resp);
        //TODO
        System.out.println(method.name());
        switch (method) {
            case ADD_DO:
                add(req, resp);
                return;
            case DELETE_DO:
                delete(req, resp);
                return;
            case UPDATE_DO:
                update(req, resp);
                return;
            case FIND_DO:
                find(req, resp);
                return;
            default:
                redirect(resp, Pages.INDEX_JSP.toString());
        }

    }


    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomService serv = (RoomService) getServletContext().getAttribute("roomService");
        Status status = serv.add(req, resp);
        //TODO debug
        System.out.println(status.name());
        switch (status) {
            case SUCCESS:


                return;
            default:
        }


    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomService serv = (RoomService) getServletContext().getAttribute("roomService");
        Status status = serv.delete(req, resp);
        //TODO debug
        System.out.println(status.name());
        switch (status) {
            case SUCCESS:
                redirect(resp, Pages.INDEX_JSP.toString());
                return;
            case ERROR:
                redirect(resp, Pages.ERROR_JSP.toString());
                return;
            default:

        }
    }


    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomService serv = (RoomService) getServletContext().getAttribute("roomService");
        String message = null;
        Status status = null;
        try {
            status = serv.update(req, resp);
        } catch (ServiceException e) {
            message = "上传图片不成功";
        }
        //TODO debug
        System.out.println(status.name());
        System.out.println("用户名: " + req.getParameter("name"));


        switch (status) {
            case DATA_ILLEGAL:
                forward(req, resp, status.getData(), "数据不合法！", Pages.ROOM_JSP);
                return;
            case SUCCESS:
                redirect(resp, Pages.ROOM_JSP.toString() + "?view=update&message=" + message + "&number=" + req.getParameter("number"));
                return;
            case ERROR:
                redirect(resp, Pages.ERROR_JSP.toString());
                return;
            default:
        }

    }

    /**
     * 需要条件指令，如果没有默认查询为所有房间
     *
     * @param req
     * @param resp
     */
    private void find(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RoomService serv = (RoomService) getServletContext().getAttribute("roomService");
        Status status = null;
        findType type = findType.valueOf(req.getParameter("find").toUpperCase());
        switch (type) {
            case NAME:
                return;
            case ALL:
                status = serv.listAll(req, resp);
                if (status == SUCCESS && status.getData() != null) {
                    req.setAttribute("data", status.getData());
                    req.getRequestDispatcher(Pages.INDEX_JSP.toString()).forward(req, resp);
                }
                return;
            case THIS:
                status = serv.find(req, resp);
                if (status == SUCCESS && status.getData() != null) {
                    req.setAttribute("data", status.getData());
                    //TODO
                    System.out.println("rediect back to room.jsp");
                    req.getRequestDispatcher(Pages.ROOM_JSP.toString()).forward(req, resp);
                    return;
                } else {
                    break;
                }
            default:
        }
        resp.sendRedirect(Pages.ERROR_JSP.toString());
    }

    enum findType {
        /**
         * 通过名称模糊查找
         */
        NAME,
        /**
         * 查找全部
         */
        ALL,
        /**
         * 查找这一个房间
         */
        THIS,
    }


}
