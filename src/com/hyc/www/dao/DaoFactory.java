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

package com.hyc.www.dao;

import com.hyc.www.dao.inter.OrderRoomDao;
import com.hyc.www.dao.inter.RoomDao;
import com.hyc.www.dao.inter.UserDao;
import com.hyc.www.exception.DaoException;
import com.hyc.www.util.JdbcUtils;


/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责生产Dao实现类
 * @date 2019-04-08 23:33
 */
public class DaoFactory {

    private static DaoFactory instance = new DaoFactory();
    
    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }
    
    /**
     * 用于提供UserDao的实现类实例
     *
     * @return com.hyc.www.dao.inter.UserDao
     * @name getUserDao
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/9
     */
    public UserDao getUserDao() {
        String userDao = JdbcUtils.getConfig("UserDao");
        try {
            UserDao instance = (UserDao) Class.forName(userDao).newInstance();
            return instance;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DaoException("无法加载类 : " + userDao, e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new DaoException("无法实例化类 : " + userDao, e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new DaoException("无法初始化实例 ：" + userDao, e);
        }
    }



    /**
     * 用于提供RoomDao的实现类实例
     *
     * @return com.hyc.www.dao.inter.RoomDao
     * @name getRoomDao
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    public RoomDao getRoomDao() {
        String roomDao = JdbcUtils.getConfig("RoomDao");
        try {
            RoomDao instance = (RoomDao) Class.forName(roomDao).newInstance();
            return instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DaoException("无法加载类 : " + roomDao, e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new DaoException("无法实例化类 : " + roomDao, e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new DaoException("无法初始化实例 ：" + roomDao, e);
        }
    }

    /**
     * 用于提供OrderRoomDao的实现类实例
     *
     * @return com.hyc.www.dao.inter.OrderRoomDao
     * @name getOrderRoomDao
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    public OrderRoomDao getOrderRoomDao() {
        String orderRoomDao = JdbcUtils.getConfig("OrderRoomDao");
        try {
            OrderRoomDao instance = (OrderRoomDao) Class.forName(orderRoomDao).newInstance();
            return instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DaoException("无法加载类 : " + orderRoomDao, e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new DaoException("无法实例化类 : " + orderRoomDao, e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new DaoException("无法初始化实例 ：" + orderRoomDao, e);
        }
    }
}
