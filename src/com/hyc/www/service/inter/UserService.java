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

package com.hyc.www.service.inter;

import com.hyc.www.service.Result;
import com.hyc.www.service.constant.Status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责用户相关的业务逻辑，包括用户注册登陆的功能
 * @date 2019-04-13 17:01
 */
public interface UserService {

    /**
     * 用于添加一个用户
     * @param req 请求
     * @param resp 响应
     * @name add
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/21
     */
    Result add(HttpServletRequest req, HttpServletResponse resp);


    /**
     * 负责用户的注册功能
     * @param req 请求
     * @param resp 响应
     * @name regist
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    Result regist(HttpServletRequest req, HttpServletResponse resp);

    /**
     * 负责用户的登陆功能
     * @param req 请求
     * @param resp 响应
     * @name login
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    Result login(HttpServletRequest req, HttpServletResponse resp);


    /**
     * 负责更新用户信息的功能
     * @param req 请求
     * @param resp 响应
     * @name updateInfo
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    Result updateInfo(HttpServletRequest req, HttpServletResponse resp);

    /**
     * 负责用户更新登陆密码的功能
     * @param req 请求
     * @param resp 响应
     * @name updatePwd
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    Result updatePwd(HttpServletRequest req, HttpServletResponse resp);

    /**
     * 负责用户更新支付密码的功能
     * @param req 请求
     * @param resp 响应
     * @name updatePayPwd
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    Result updatePayPwd(HttpServletRequest req, HttpServletResponse resp);


    /**
     * 负责返回用户的个人信息
     * @param req 请求
     * @param resp 响应
     * @name myInfo
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/16
     */
    Result find(HttpServletRequest req, HttpServletResponse resp);


    /**
     * 负责查找用户
     * @param req 请求
     * @param resp 响应
     * @return com.hyc.www.service.constant.Status
     * @name listAll
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/20
     */
    Result listAll(HttpServletRequest req, HttpServletResponse resp);

}
