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

package com.hyc.www.controller.filter;

import com.hyc.www.controller.constant.Methods;
import com.hyc.www.controller.constant.Pages;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.hyc.www.controller.constant.CacheConst.USER;
import static com.hyc.www.util.ControllerUtils.redirect;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责过滤需要登陆的页面的请求
 * @date 2019-04-20 15:41
 */
@WebFilter(
        filterName = "LoginFilter",
        urlPatterns = {"/*"}, servletNames = {"/*"},
        initParams = {
                @WebInitParam(name = "ENCODING", value = "UTF-8")
        })
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String method= req.getParameter("method");
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = uri.substring(contextPath.length());

        if (!(("/"+Pages.LOGIN_JSP.toString()).equalsIgnoreCase(path)
                || ("/"+Pages.REGIST_JSP.toString()).equalsIgnoreCase(path)
                || (Methods.LOGIN_DO.toString()).equalsIgnoreCase(method)
                || (Methods.REGIST_DO.toString()).equalsIgnoreCase(method))) {
            /**
             * 如果session不存在则检查cookie
             */
            HttpSession sess = req.getSession(false);
            if (sess == null) {
                /**
                 * 如果有记住登陆状态的cookie,则给session添加'user'属性
                 */
                Cookie[] cookies = req.getCookies();
                if(cookies!=null){
                    for (Cookie cookie : cookies) {
                        String name = cookie.getName();
                        if (USER.toString().equalsIgnoreCase(name)) {
                            sess = req.getSession(true);
                            sess.setAttribute(USER.toString(), cookie.getValue());
                        }
                    }
                }
            }
            /**
             * 检查session是否有'user',没有则重定向到登陆界面
             */
            if (sess == null || sess.getAttribute(USER.toString()) == null) {
                redirect(resp, Pages.LOGIN_JSP.toString());
                return;
            }
        }
        filterChain.doFilter(req, resp);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
