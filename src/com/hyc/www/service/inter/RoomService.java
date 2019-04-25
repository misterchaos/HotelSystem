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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责提供房间相关的服务
 * @date 2019-04-16 23:32
 */
public interface RoomService {
    Result add(HttpServletRequest req, HttpServletResponse resp);

    Result delete(HttpServletRequest req, HttpServletResponse resp);

    Result update(HttpServletRequest req, HttpServletResponse resp);

    Result find(HttpServletRequest req, HttpServletResponse resp);


    /**
     * 返回所有的房间
     *
     * @return com.hyc.www.service.constant.Status
     * @name listAll
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/21
     */
    Result listAll(HttpServletRequest req, HttpServletResponse resp);


    /**
     * 通过名称模糊查询相关的房间
     *
     * @return com.hyc.www.service.constant.Status
     * @name listByName
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/21
     */
    Result listByName(HttpServletRequest req, HttpServletResponse resp);
}
