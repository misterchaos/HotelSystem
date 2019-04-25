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

import com.hyc.www.po.OrderRoom;
import com.hyc.www.service.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;

import static com.hyc.www.service.constant.Status.NO_RESULT;
import static com.hyc.www.service.constant.Status.SUCCESS;
import static com.hyc.www.util.ServiceUtils.setOrderRoomResult;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责房间预约订单的服务
 * @date 2019-04-17 01:11
 */
public interface OrderRoomService {
    Result add(HttpServletRequest req, HttpServletResponse resp);

    Result delete(HttpServletRequest req, HttpServletResponse resp);


    Result find(HttpServletRequest req, HttpServletResponse resp);

    /**
     * 返回该用户用户名对应的订单
     *
     * @param req  请求
     * @param resp 响应
     * @return 该用户名对应的所有订单
     * @name listByUserName
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/22
     */
    Result listByUserName(HttpServletRequest req, HttpServletResponse resp);


}
