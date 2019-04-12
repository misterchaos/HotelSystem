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

package com.hyc.www.dao.impl;

import com.hyc.www.dao.inter.OrderRoomDao;
import com.hyc.www.po.OrderRoom;
import com.hyc.www.po.Room;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责房间订单的CRUD
 * @date 2019-04-12 01:52
 */
public class OrderRoomDaoImpl extends BaseDaoImpl implements OrderRoomDao {
    /**
     * 本类操作的数据库表名
     */
    String TABLE_NAME = " order_room ";

    /**
     * 表中所有字段对应的查询语句
     */
    String ALL_FIELD_NAME = " id,number,user_id,room_id,start_time,end_time,amount,remark,"
            + "status,gmt_create,gmt_modified ";


    /**
     * 添加一个订单到数据库
     *
     * @param order 要添加的订单
     * @return boolean
     * @name addOrderRoom
     * @notice 无法添加订单编号为空的订单
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/12
     */
    @Override
    public boolean addOrderRoom(OrderRoom order) {
        if (order == null || order.getNumber() == null) {
            return false;
        }
        return super.insert(TABLE_NAME, order)==1;
    }

    /**
     * 根据订单编号查询一个订单的所有信息
     *
     * @param orderNum
     * @return com.hyc.www.po.OrderRoom
     * @name getOrderRoom
     * @notice 如果订单为空或者没有该订单，则返回null;
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    @Override
    public OrderRoom getOrderRoom(String orderNum) {
        if (orderNum == null) {
            return null;
        }
        String sql = "select " + ALL_FIELD_NAME + " from " + TABLE_NAME + " where number  = ?";
        return (OrderRoom) super.queryObject(sql, new Object[]{orderNum}, OrderRoom.class);
    }


    /**
     * 返回该订单编号对应的id
     *
     * @param orderNum 订单编号
     * @return java.math.BigInteger
     * @name getId
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/12
     */
    @Override
    public BigInteger getId(String orderNum) {
        String sql = "select id from " + TABLE_NAME + " where number = ?";
        return (BigInteger) super.queryValue(sql, new Object[]{orderNum});
    }

    /**
     * 获取表中所有订单的信息，并以LinkedList的形式返回
     *
     * @return java.util.LinkedList
     * @name getAllOrderRooms
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/12
     */
    @Override
    public LinkedList<OrderRoom> getAllOrderRooms() {
        String sql = "select " + ALL_FIELD_NAME + " from " + TABLE_NAME;
        LinkedList<Object> list = super.queryList(sql, null, OrderRoom.class);
        LinkedList<OrderRoom> orders = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            OrderRoom order = (OrderRoom) list.get(i);
            orders.add(order);
        }
        return orders;
    }


    /**
     * 将该id对应的订单从数据库中删除
     *
     * @param Id 要删除订单的id
     * @return boolean
     * @name deleteById
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/12
     */
    @Override
    public boolean deleteById(BigInteger Id) {
        return super.delete(TABLE_NAME, Id) == 1;
    }


    /**
     * 将该订单编号对应的订单从数据库中删除
     *
     * @param orderNumber 要删除的订单的订单编号
     * @return boolean
     * @name deleteByNumber
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/12
     */
    @Override
    public boolean deleteByNumber(String orderNumber) {
        return deleteById(getId(orderNumber));
    }

    /**
     * 将一个订单对象对象从数据库中删除
     *
     * @param order 要删除的订单对象
     * @return boolean
     * @name delete
     * @notice 该订单对象必须至少包含订单的id
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/12
     */
    @Override
    public boolean delete(OrderRoom order) {
        return deleteById(order.getId());
    }


    /**
     * 更新一个订单的信息
     *
     * @param order 要更新的订单对象
     * @return boolean
     * @name update
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/12
     */
    @Override
    public boolean update(OrderRoom order) {
        if (order == null) {
            return false;
        }
        return super.update(TABLE_NAME, order) == 1;
    }
}
