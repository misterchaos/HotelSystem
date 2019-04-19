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

import com.hyc.www.dao.inter.OrderRoomDao;
import com.hyc.www.po.OrderRoom;
import com.hyc.www.service.constant.Status;
import com.hyc.www.service.inter.OrderRoomService;
import com.hyc.www.util.BeanFactory;
import com.hyc.www.util.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.hyc.www.service.constant.Status.ERROR;
import static com.hyc.www.service.constant.Status.SUCCESS;
import static com.hyc.www.util.UUIDUtils.getUUID;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责房间订单相关的服务
 * @date 2019-04-17 01:12
 */
public class OrderRoomServiceImpl implements OrderRoomService {

    private OrderRoomDao dao = (OrderRoomDao) BeanFactory.getBean(BeanFactory.DaoType.OrderRoomDao);

    @Override
    public Status add(HttpServletRequest req, HttpServletResponse resp) {
        OrderRoom order = (OrderRoom) BeanUtils.toObject(req.getParameterMap(), OrderRoom.class);

        //TODO： 处理预定不可重复的问题


        order.setId(getUUID());
        if (dao.addOrderRoom(order)) {
            return SUCCESS;
        }
        return ERROR;

    }

    @Override
    public Status delete(HttpServletRequest req, HttpServletResponse resp) {
        OrderRoom order = (OrderRoom) BeanUtils.toObject(req.getParameterMap(), OrderRoom.class);

        //TODO 处理房间已经有人预定的情况
        if (order.getId() == null) {
            order.setId(dao.getId(order.getNumber()));
        }

        if (dao.delete(order)) {
            return SUCCESS;
        }

        return ERROR;
    }


    @Override
    public Status find(HttpServletRequest req, HttpServletResponse resp) {


        return ERROR;

    }


}
