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

package com.hyc.www.util;

import com.hyc.www.controller.constant.Methods;
import com.hyc.www.controller.constant.Pages;
import com.hyc.www.vo.PagesVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 控制层工具类
 * @date 2019-04-18 17:35
 */
public class ControllerUtils {


    /**
     * 解析请求的参数，返回对应的枚举项
     *
     * @param req  请求
     * @param resp 响应
     * @return com.hyc.www.controller.constant.Methods
     * @name getMethod
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/20
     * @see com.hyc.www.controller.constant.Methods
     */
    public static Methods getMethod(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String m = req.getParameter("method");
        Methods method = null;

        try {
            method = Methods.valueOf(m);
        } catch (NullPointerException | IllegalArgumentException e) {
            /**
             * 这里是非法的请求导致异常，一律重定向到首页
             */
            System.out.println("非法请求：重定向到首页");
            return Methods.INDEX_VIEW;
        }
        return method;
    }


    /**
     * 封装控制层的转发，设置参数等行为
     *
     * @param req     请求
     * @param resp    响应
     * @param data    返回的数据
     * @param message 返回的消息
     * @param pages   转发的目标页面
     * @return void
     * @name forward
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/20
     */
    public static void forward(HttpServletRequest req, HttpServletResponse resp, PagesVo data, String message, Pages pages) throws ServletException, IOException {
        req.setAttribute("data", data);
        req.setAttribute("message", message);
        //TODO
        System.out.println("转发到 " + pages.toString() + "method=" + req.getParameter("method") + "view=" + req.getParameter("view"));

        req.getRequestDispatcher(pages.toString()).forward(req, resp);
    }


    public static void redirect(HttpServletResponse resp, String path) throws ServletException, IOException {
        resp.sendRedirect(path);
    }

}
