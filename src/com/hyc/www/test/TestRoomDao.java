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

import com.hyc.www.dao.inter.RoomDao;
import com.hyc.www.po.Room;
import com.hyc.www.util.BeanFactory;

import java.math.BigDecimal;
import java.util.LinkedList;

import static com.hyc.www.util.UUIDUtils.getUUID;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试RoomDao
 * @date 2019-04-12 00:16
 */
public class TestRoomDao {
    public static void main(String[] args) {
        RoomDao roomDao = (RoomDao) BeanFactory.getBean(BeanFactory.DaoType.RoomDao);

        /**
         * 测试查询房间全部信息功能
         */
        System.out.println("测试查询房间全部信息功能");
        Room room = roomDao.getRoom("1020");
        if (room != null) {
            System.out.println(room.getNumber());
            System.out.println(room.getId());
            System.out.println(room.getStatus());
            System.out.println(room.getArea());
            System.out.println(room.getGmtModified());
        } else {
            System.out.println(room);
        }

        /**
         * 测试获取所有房间信息的功能
         */
        System.out.println("测试获取所有房间信息的功能");
        LinkedList list = roomDao.getAllRooms();
        System.out.println(list.size());
        for (int i = 0; i <0 ; i++) {
        room = (Room) list.get(i);
        System.out.println(room.getGmtModified());
        System.out.println(room.getNumber());
        System.out.println(room.getName());

        }
        /**
         * 测试通过房间id删除房间的功能
         */
        System.out.println("测试通过房间id删除房间的功能");
        System.out.println(roomDao.deleteById("5"));
        /**
         * 测试通过编号删除房间的功能
         */
        System.out.println("测试通过房间编号删除房间的功能");
        System.out.println(roomDao.deleteByNumber("0"));
        /**
         * 测试更新房间信息的功能
         */
        System.out.println("测试更新房间信息的功能");
        room = roomDao.getRoom("0000");
        if (room != null) {
            room.setBedWidth(BigDecimal.valueOf(2.0));
            room.setArea(BigDecimal.valueOf(1000.90));
            System.out.println(roomDao.update(room));
        }


        /**
         * 测试增加房间的功能
         */
        System.out.println("测试增加房间的功能");
        room = new Room();
        room.setNumber("1020");
        room.setPrice(BigDecimal.valueOf(99.99));
        room.setPhoto("test2");
        System.out.println(roomDao.addRoom(null));

        /**
         * 测试模糊查询
         */
        System.out.println(roomDao.findByName("test").size());
        System.out.println(roomDao.findByName(null,1).size());
        /**
         * 批量增加房间
         */
        for (int i = 0; i < 0; i++) {
            room=new Room();
            room.setId(getUUID());
            room.setNumber("01020"+i);
            room.setName("广州精品酒店第"+i+"号房间");
            room.setArea(new BigDecimal(i+110));
            room.setBedWidth(new BigDecimal(3));
            room.setPrice(new BigDecimal(599+i*100));
            System.out.println("add room");
            roomDao.addRoom(room);
        }


    }
}
