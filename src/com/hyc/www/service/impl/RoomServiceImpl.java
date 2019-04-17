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

import com.hyc.www.dao.inter.RoomDao;
import com.hyc.www.po.Room;
import com.hyc.www.service.constant.ServeConsts;
import com.hyc.www.service.inter.RoomService;
import com.hyc.www.util.BeanFactory;
import com.hyc.www.util.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.hyc.www.service.constant.ServeConsts.Status.*;
import static com.hyc.www.util.ServiceUtils.isValidRoom;
import static com.hyc.www.util.UUIDUtils.getUUID;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责房间相关的服务
 * @date 2019-04-16 23:33
 */
public class RoomServiceImpl implements RoomService {

    private RoomDao dao = (RoomDao) BeanFactory.getBean(BeanFactory.DaoType.RoomDao);

    @Override
    public ServeConsts.Status add(HttpServletRequest req, HttpServletResponse resp) {
        Room room = (Room) BeanUtils.toObject(req.getParameterMap(), Room.class);
        if (dao.isExist(room.getNumber())) {
            return ROOM_ALREADY_EXIST;
        }
        if (!isValidRoom(room)) {
            return DATA_ILLEGAL;
        }
        room.setId(getUUID());
        //TODO 处理房间编号，计算编号
        if (dao.addRoom(room)) {
            return SUCCESS;
        }
        return ERROR;

    }

    @Override
    public ServeConsts.Status delete(HttpServletRequest req, HttpServletResponse resp) {
        Room room = (Room) BeanUtils.toObject(req.getParameterMap(), Room.class);
        if (!dao.isExist(room.getNumber())) {
            return ROOM_NOT_FOUND;
        }

        //TODO 处理房间已经有人预定的情况
        if (room.getId() == null) {
            room.setId(dao.getId(room.getNumber()));
        }
        if (dao.delete(room)) {
            return SUCCESS;
        }
        return ERROR;
    }

    @Override
    public ServeConsts.Status update(HttpServletRequest req, HttpServletResponse resp) {
        Room room = (Room) BeanUtils.toObject(req.getParameterMap(), Room.class);
        if (!isValidRoom(room)) {
            return DATA_ILLEGAL;
        }
        if (room.getId() == null) {
            room.setId(dao.getId(room.getNumber()));
        }
        if (dao.update(room)) {
            return SUCCESS;
        }
        return ERROR;

    }

    @Override
    public ServeConsts.Status find(HttpServletRequest req, HttpServletResponse resp) {
        return ERROR;

    }


}
