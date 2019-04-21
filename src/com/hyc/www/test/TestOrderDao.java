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

import com.hyc.www.dao.impl.OrderRoomDaoImpl;
import com.hyc.www.dao.inter.OrderRoomDao;
import com.hyc.www.po.OrderRoom;
import com.hyc.www.po.abs.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;

import static com.hyc.www.util.UUIDUtils.getUUID;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试OrderOrderRoomDao的实现类
 * @date 2019-04-12 02:10
 */
public class TestOrderDao {
    public static void main(String[] args) {
        OrderRoomDao orderDao = new OrderRoomDaoImpl();

        Date date = new Date();
        OrderRoom orderRoom = new OrderRoom();
        orderRoom.setStartTime(String.valueOf(date));

        /**
         * 测试查询订单全部信息功能
         */
        System.out.println("测试查询订单全部信息功能");
        OrderRoom order=orderDao.getOrderRoom("1010");
        if(order!=null){
            BaseEntity baseEntity = order;
            System.out.println(order.getNumber());
            System.out.println(baseEntity.getId());
            System.out.println(baseEntity.getStatus());
            System.out.println(baseEntity.getGmtModified());
            System.out.println(order.getAmount());
        }else {
            System.out.println(order);
        }

        /**
         * 测试获取所有订单信息的功能
         */
        System.out.println("测试获取所有订单信息的功能");
        LinkedList list = orderDao.getAllOrderRooms();
        System.out.println(list.size());
        /**
         * 测试通过订单id删除订单的功能
         */
        System.out.println("测试通过订单id删除订单的功能");
        System.out.println(orderDao.deleteById("8"));
        /**
         * 测试通过订单名删除订单的功能
         */
        System.out.println("测试通过订单名删除订单的功能");
        System.out.println(orderDao.deleteByNumber(null));
        /**
         * 测试更新订单信息的功能
         */
        System.out.println("测试更新订单信息的功能");
        order=orderDao.getOrderRoom("0000");
        System.out.println(orderDao.update(order));

        /**
         * 测试增加订单的功能
         */
        System.out.println("测试增加订单的功能");
        order= new OrderRoom();
        order.setAmount(BigDecimal.valueOf(99.99));
        order.setId(getUUID());
        order.setNumber("1020");
        System.out.println(orderDao.addOrderRoom(order));
    }
   
}
