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
import com.hyc.www.service.inter.RemarkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hyc.www.util.ControllerUtils.*;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责评论的请求转发
 * @date 2019-04-23 01:39
 */
@WebServlet("/remark")
public class RemarkServlet extends HttpServlet {
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
            case FIND_DO:
                find(req, resp);
                return;
            default:
                redirect(resp, Pages.INDEX_JSP.toString());
        }

    }


    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RemarkService serv = (RemarkService) getServletContext().getAttribute("remarkService");
        Result result = serv.add(req, resp);
        Status status = result.getStatus();

        switch (status) {
            case DATA_TOO_MUCH:
                forward(req, resp, result.getData(), "您的留言次数已达上限！如果您是测试所需，请联系作者", Pages.REMARK_JSP);
                return;
            case DATA_ILLEGAL:
                forward(req, resp, result.getData(), "数据不合法！（不可为空）", Pages.REMARK_JSP);
                return;
            case SUCCESS:
                redirect(resp,Pages.REMARK_JSP.toString());
                return;
            case ERROR:
                forward(req, resp, result.getData(), "添加留言失败！", Pages.REMARK_JSP);
                return;
            default:
        }
    }

    private void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RemarkService serv = (RemarkService) getServletContext().getAttribute("remarkService");
        Result result = serv.listAll(req, resp);
        Status status = result.getStatus();

        switch (status) {
            case SUCCESS:
                forward(req, resp, result.getData(), null, Pages.REMARK_JSP);
                return;
            case ERROR:
                forward(req, resp, result.getData(), "查找留言失败！", Pages.REMARK_JSP);
                return;
            default:
        }
    }
}
