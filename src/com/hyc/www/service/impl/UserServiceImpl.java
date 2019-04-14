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

package com.hyc.www.service.impl;

import com.hyc.www.util.BeanFactory;
import com.hyc.www.dao.inter.UserDao;
import com.hyc.www.exception.ServiceException;
import com.hyc.www.po.User;
import com.hyc.www.service.inter.UserService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责用户相关的业务逻辑，包括用户注册登陆的功能
 * @date 2019-04-13 18:24
 */
public class UserServiceImpl implements UserService {

    /**
     * 负责用户的注册功能
     *
     * @name regist
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    @Override
    public boolean regist(HttpServletRequest req, HttpServletResponse resp) {
        UserDao dao = (UserDao) BeanFactory.getBean(BeanFactory.DaoType.UserDao);
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("password");
        if (dao.isExist(userName)) {
            try {
                //TODO dubug
                PrintWriter writer = resp.getWriter();
                writer.print("<h1>用户已经存在！</h1>");
                writer.flush();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                throw new ServiceException("无法向界面输出内容", e);
            }
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(pwd);
        return dao.addUser(user);
    }

    /**
     * 负责用户的登陆功能
     *
     * @name login
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    @Override
    public boolean login() {

        return false;
    }

    /**
     * 负责更新用户信息的功能
     *
     * @name updateInfo
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    @Override
    public boolean updateInfo() {

        return false;
    }

    /**
     * 负责用户更新登陆密码的功能
     *
     * @name updatePwd
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    @Override
    public boolean updatePwd() {

        return false;
    }


}
