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
import com.hyc.www.exception.ServiceException;
import com.hyc.www.po.Room;
import com.hyc.www.service.constant.Status;
import com.hyc.www.service.inter.RoomService;
import com.hyc.www.util.BeanFactory;
import com.hyc.www.util.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.LinkedList;

import static com.hyc.www.service.constant.Status.*;
import static com.hyc.www.util.ServiceUtils.isValidRoom;
import static com.hyc.www.util.ServiceUtils.setData;
import static com.hyc.www.util.UUIDUtils.getUUID;
import static com.hyc.www.util.UploadUtils.upload;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责房间相关的服务
 * @date 2019-04-16 23:33
 */
@MultipartConfig(location = "C:/Users/Misterchaos/Documents/Java Develop Workplaces/IDEA workspace/HotelSystem/web/file/photo")
public class RoomServiceImpl implements RoomService {

    private RoomDao dao = (RoomDao) BeanFactory.getBean(BeanFactory.DaoType.RoomDao);

    @Override
    public Status add(HttpServletRequest req, HttpServletResponse resp) {
        Room room = (Room) BeanUtils.toObject(req.getParameterMap(), Room.class);
        if (dao.isExist(room.getNumber())) {
            return setData(room, ROOM_ALREADY_EXIST);
        }
        if (!isValidRoom(room)) {
            return setData(room, DATA_ILLEGAL);
        }
        room.setId(getUUID());

        uploadPhoto(req, room);
        //TODO 处理房间编号，计算编号
        if (dao.addRoom(room)) {
            return setData(room, SUCCESS);
        }
        return ERROR;

    }


    @Override
    public Status delete(HttpServletRequest req, HttpServletResponse resp) {
        Room room = (Room) BeanUtils.toObject(req.getParameterMap(), Room.class);
        if (!dao.isExist(room.getNumber())) {
            return ROOM_NOT_FOUND;
        }

        //TODO 处理房间已经有人预定的情况
        if (room.getId() == null) {
            room.setId(dao.getId(room.getNumber()));
        }
        if (dao.delete(room)) {
            return setData(room, SUCCESS);
        }
        return ERROR;
    }

    @Override
    public Status update(HttpServletRequest req, HttpServletResponse resp) {
        Room room = (Room) BeanUtils.toObject(req.getParameterMap(), Room.class);
        if (!isValidRoom(room)) {
            /**
             * 重新加载头像
             */
            room.setPhoto(dao.getRoom(room.getNumber()).getPhoto());
            return setData(room, DATA_ILLEGAL);
        }
        if (room.getId() == null) {
            room.setId(dao.getId(room.getNumber()));
        }


        uploadPhoto(req, room);
        if (dao.update(room)) {
            return setData(room, SUCCESS);
        }
        return ERROR;

    }


    @Override
    public Status find(HttpServletRequest req, HttpServletResponse resp) {
        Room room = (Room) BeanUtils.toObject(req.getParameterMap(), Room.class);

        room = dao.getRoom(room.getNumber());

        if (room != null) {
            return setData(room, SUCCESS);
        }
        return ERROR;

    }

    @Override
    public Status listAll(HttpServletRequest req, HttpServletResponse resp) {

        LinkedList<Room> rooms = dao.getAllRooms();
        if (rooms != null && rooms.size() > 0) {

            return setData(rooms, SUCCESS);
        }

        return ERROR;
    }


    /**
     * 用于上传照片
     *
     * @param
     * @return
     * @name
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/20
     */
    private void uploadPhoto(HttpServletRequest req, Room room) {
        try {
            Part part = req.getPart("photo");
            if (part.getSize() > 0) {
                room.setPhoto(upload(part));
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
            throw new ServiceException("无法上传照片" + e);
        }
    }

}
