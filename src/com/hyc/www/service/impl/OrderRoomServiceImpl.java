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
import com.hyc.www.dao.inter.RoomDao;
import com.hyc.www.dao.inter.UserDao;
import com.hyc.www.po.OrderRoom;
import com.hyc.www.po.Room;
import com.hyc.www.po.User;
import com.hyc.www.service.Result;
import com.hyc.www.service.inter.OrderRoomService;
import com.hyc.www.util.BeanFactory;
import com.hyc.www.util.BeanUtils;
import com.hyc.www.vo.PagesVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;

import static com.hyc.www.service.constant.Status.*;
import static com.hyc.www.util.ServiceUtils.*;
import static com.hyc.www.util.UUIDUtils.getUUID;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责房间订单相关的服务
 * @date 2019-04-17 01:12
 */
public class OrderRoomServiceImpl implements OrderRoomService {

    private OrderRoomDao dao = (OrderRoomDao) BeanFactory.getBean(BeanFactory.DaoType.OrderRoomDao);
    private RoomDao roomDao = (RoomDao) BeanFactory.getBean(BeanFactory.DaoType.RoomDao);
    private UserDao userDao = (UserDao) BeanFactory.getBean(BeanFactory.DaoType.UserDao);

    @Override
    public Result add(HttpServletRequest req, HttpServletResponse resp) {
        OrderRoom order = (OrderRoom) BeanUtils.toObject(req.getParameterMap(), OrderRoom.class);
        String userName = req.getParameter("user");
        if (!isValidRoomOrder(order)) {
            return setResult(order, ALREADY_BOOKED);
        }
        order.setId(getUUID());
        order.setUserId(userDao.getId(userName));
        if (dao.addOrderRoom(order)) {
            return setResult(order, SUCCESS);
        }
        return setResult(ERROR);
    }

    @Override
    public Result delete(HttpServletRequest req, HttpServletResponse resp) {
        OrderRoom order = (OrderRoom) BeanUtils.toObject(req.getParameterMap(), OrderRoom.class);

        //TODO 处理房间已经有人预定的情况
        if (order.getId() == null) {
            order.setId(dao.getId(order.getNumber()));
        }

        if (dao.delete(order)) {
            return setResult(SUCCESS);
        }

        return setResult(ERROR);
    }


    @Override
    public Result find(HttpServletRequest req, HttpServletResponse resp) {
        OrderRoom order = (OrderRoom) BeanUtils.toObject(req.getParameterMap(), OrderRoom.class);
        order = dao.getOrderRoom(order.getNumber());
        if (order == null) {
            return setResult(NOT_FOUNT);
        }
        PagesVo vo = new PagesVo();
        LinkedList<OrderRoom> orders = new LinkedList<>();
        orders.add(order);
        Room room = roomDao.getRoomById(order.getRoomId());
        User user = userDao.getUserById(order.getUserId());
        LinkedList<User> users = new LinkedList<>();
        LinkedList<Room> rooms = new LinkedList<>();
        rooms.add(room);
        users.add(user);
        setVoData(vo, orders, users, rooms);
        return new Result(SUCCESS, vo);
    }

    private void setVoData(PagesVo vo, LinkedList<OrderRoom> orders, LinkedList<User> users, LinkedList<Room> rooms) {
        vo.setOrderRooms(orders);
        vo.setRooms(rooms);
        vo.setUsers(users);
    }


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
    @Override
    public Result listByUserName(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("user");
        String userId = userDao.getId(userName);
        LinkedList<OrderRoom> orders = dao.listByUserId(userId);
        LinkedList<User> users = new LinkedList<>();
        LinkedList<Room> rooms = new LinkedList<>();
        if (orders != null) {
            for (OrderRoom order:orders) {
                rooms.add( roomDao.getRoomById(order.getRoomId()));
                users.add(userDao.getUserById(order.getUserId()));
            }
            PagesVo vo = new PagesVo();
            setVoData(vo,orders,users,rooms);
            return new Result(SUCCESS,vo);
        }
        return setOrderRoomResult(orders, NO_RESULT);
    }


}
