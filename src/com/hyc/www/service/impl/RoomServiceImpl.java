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
import com.hyc.www.service.Result;
import com.hyc.www.service.inter.RoomService;
import com.hyc.www.util.BeanFactory;
import com.hyc.www.util.BeanUtils;
import com.hyc.www.util.ServiceUtils;
import com.hyc.www.vo.PagesVo;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;

import static com.hyc.www.service.constant.Status.*;
import static com.hyc.www.util.ServiceUtils.isValidRoom;
import static com.hyc.www.util.ServiceUtils.setResult;
import static com.hyc.www.util.UUIDUtils.getUUID;
import static com.hyc.www.util.UploadUtils.uploadPhoto;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责房间相关的服务
 * @date 2019-04-16 23:33
 */
public class RoomServiceImpl implements RoomService {

    private RoomDao dao = (RoomDao) BeanFactory.getBean(BeanFactory.DaoType.RoomDao);

    @Override
    public Result add(HttpServletRequest req, HttpServletResponse resp) {
        Room room = (Room) BeanUtils.toObject(req.getParameterMap(), Room.class);
        if (dao.isExist(room.getNumber())) {
            return ServiceUtils.setResult(room, ROOM_ALREADY_EXIST);
        }
        if (!isValidRoom(room)) {
            return ServiceUtils.setResult(room, DATA_ILLEGAL);
        }
        room.setId(getUUID());

        uploadPhoto(req, room);
        //TODO 处理房间编号，计算编号
        if (dao.addRoom(room)) {
            return ServiceUtils.setResult(room, SUCCESS);
        }
        return setResult(ERROR);

    }


    @Override
    public Result delete(HttpServletRequest req, HttpServletResponse resp) {
        Room room = (Room) BeanUtils.toObject(req.getParameterMap(), Room.class);
        if (!dao.isExist(room.getNumber())) {
            return setResult(NOT_FOUNT);
        }

        //TODO 处理房间已经有人预定的情况
        if (room.getId() == null) {
            room.setId(dao.getId(room.getNumber()));
        }
        if (dao.delete(room)) {
            return ServiceUtils.setResult(room, SUCCESS);
        }
        return setResult(ERROR);
    }

    @Override
    public Result update(HttpServletRequest req, HttpServletResponse resp) {
        Room room = (Room) BeanUtils.toObject(req.getParameterMap(), Room.class);
        if (!isValidRoom(room)) {
            /**
             * 重新加载头像
             */
            room.setPhoto(dao.getRoom(room.getNumber()).getPhoto());
            return ServiceUtils.setResult(room, DATA_ILLEGAL);
        }
        if (room.getId() == null) {
            room.setId(dao.getId(room.getNumber()));
        }
        uploadPhoto(req, room);
        if (dao.update(room)) {
            return ServiceUtils.setResult(room, SUCCESS);
        }
        return setResult(ERROR);

    }


    @Override
    public Result find(HttpServletRequest req, HttpServletResponse resp) {
        Room room = (Room) BeanUtils.toObject(req.getParameterMap(), Room.class);
        room = dao.getRoom(room.getNumber());
        if (room != null) {
            return ServiceUtils.setResult(room, SUCCESS);
        }
        return setResult(ERROR);

    }

    /**
     * 返回所有的房间
     *
     * @return com.hyc.www.service.constant.Status
     * @name listAll
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/21
     */
    @Override
    public Result listAll(HttpServletRequest req, HttpServletResponse resp) {
        int page = Integer.parseInt(req.getParameter("page"));
        LinkedList<Room> rooms = dao.findByName(null, page);
        if (rooms != null && rooms.size() > 0) {
            return setResult(rooms, SUCCESS);
        }
        return setResult(ERROR);
    }


    /**
     * 通过名称模糊查询相关的房间
     *
     * @return com.hyc.www.service.constant.Status
     * @name listByName
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/21
     */
    @Override
    public Result listByName(HttpServletRequest req, HttpServletResponse resp) {
        int page = Integer.parseInt(req.getParameter("page"));
        String name = req.getParameter("name");
        LinkedList<Room> rooms = dao.findByName(name, page);
        if (rooms != null && rooms.size() > 0) {
            PagesVo vo = new PagesVo();
            vo.setRooms(rooms);
            vo.setMaxPage(dao.getMaxPageByName(name));
            return new Result(SUCCESS,vo);
        }
        return setResult(rooms, NO_RESULT);
    }




}
