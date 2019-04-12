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

package com.hyc.www.test;

import com.hyc.www.dao.impl.RoomDaoImpl;
import com.hyc.www.dao.inter.RoomDao;
import com.hyc.www.po.Room;
import com.hyc.www.po.User;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试RoomDao
 * @date 2019-04-12 00:16
 */
public class TestRoomDao {
    public static void main(String[] args) {
        RoomDao roomDao = new RoomDaoImpl();

        /**
         * 测试查询房间全部信息功能
         */
        System.out.println("测试查询房间全部信息功能");
        Room room=roomDao.getRoom("1010");
        if(room!=null){
            System.out.println(room.getNumber());
            System.out.println(room.getId());
            System.out.println(room.getStatus());
            System.out.println(room.getArea());
            System.out.println(room.getGmtModified());
        }else {
            System.out.println(room);
        }

        /**
         * 测试获取所有房间信息的功能
         */
        System.out.println("测试获取所有房间信息的功能");
        LinkedList list = roomDao.getAllRooms();
        System.out.println(list.size());
        /**
         * 测试通过房间id删除房间的功能
         */
        System.out.println("测试通过房间id删除房间的功能");
        System.out.println(roomDao.deleteById(null));
        /**
         * 测试通过房间名删除房间的功能
         */
        System.out.println("测试通过房间名删除房间的功能");
        System.out.println(roomDao.deleteByNumber(null));
        /**
         * 测试更新房间信息的功能
         */
        System.out.println("测试更新房间信息的功能");
        room=roomDao.getRoom("0000");
        room.setBedWidth(BigDecimal.valueOf(2.0));
        room.setArea(BigDecimal.valueOf(1000.90));
        System.out.println(roomDao.update(room));

        /**
         * 测试增加房间的功能
         */
        System.out.println("测试增加房间的功能");
        room= new Room();
        room.setNumber("1020");
        room.setPrice(BigDecimal.valueOf(99.99));
        room.setPhoto("test2");
        System.out.println(roomDao.addRoom(room));
    }
}
