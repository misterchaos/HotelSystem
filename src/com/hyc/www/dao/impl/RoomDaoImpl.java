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

import com.hyc.www.dao.inter.RoomDao;
import com.hyc.www.po.Room;
import com.hyc.www.po.User;
import com.hyc.www.util.JdbcUtils;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.jar.JarEntry;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责对房间的CRUD
 * @date 2019-04-11 23:45
 */
public class RoomDaoImpl extends BaseDaoImpl implements RoomDao {
    /**
     * 本类操作的数据库表名
     */
    String TABLE_NAME = " "+ JdbcUtils.getTableName(Room.class)+" ";

    /**
     * 表中所有字段对应的查询语句
     */
    String ALL_FIELD_NAME = " id,number,photo,type,area,bed_width,price,book_status,level,"
            + "score,remark_num,hotel_id,creator_id,editor_id,status,gmt_create,gmt_modified ";


    /**
     * 添加一个房间到数据库
     *
     * @param room 要添加的房间
     * @return boolean
     * @name addRoom
     * @notice 无法添加房间编号为空的房间
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean addRoom(Room room) {
        if (room == null || room.getNumber() == null) {
            return false;
        }
        return super.insert(room)==1;
    }

    /**
     * 根据房间编号查询一个房间的所有信息
     *
     * @param roomNum
     * @return com.hyc.www.po.Room
     * @name getRoom
     * @notice 如果房间为空或者没有该房间，则返回null;
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    @Override
    public Room getRoom(String roomNum) {
        if (roomNum == null) {
            return null;
        }
        String sql = "select " + ALL_FIELD_NAME + " from " + TABLE_NAME + " where number  = ?";
        return (Room) super.queryObject(sql, new Object[]{roomNum}, Room.class);
    }


    /**
     * 返回该房间编号对应的id
     *
     * @param roomNum 房间编号
     * @return java.math.BigInteger
     * @name getId
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public BigInteger getId(String roomNum) {
        String sql = "select id from " + TABLE_NAME + " where number = ?";
        return (BigInteger) super.queryValue(sql, new Object[]{roomNum});
    }

    /**
     * 获取表中所有房间的信息，并以LinkedList的形式返回
     *
     * @return java.util.LinkedList
     * @name getAllRooms
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public LinkedList<Room> getAllRooms() {
        String sql = "select " + ALL_FIELD_NAME + " from " + TABLE_NAME;
        LinkedList<Object> list = super.queryList(sql, null, Room.class);
        LinkedList<Room> rooms = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            Room room = (Room) list.get(i);
            rooms.add(room);
        }
        return rooms;
    }


    /**
     * 将该id对应的房间从数据库中删除
     *
     * @param Id 要删除房间的id
     * @return boolean
     * @name deleteById
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean deleteById(BigInteger Id) {
        if(Id==null){
            return false;
        }
        Room room = new Room();
        room.setId(Id);
        System.out.println("id = "+room.getId());
        return super.delete(room) == 1;
    }


    /**
     * 将该房间编号对应的房间从数据库中删除
     *
     * @param roomNumber 要删除的房间的房间编号
     * @return boolean
     * @name deleteByNumber
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean deleteByNumber(String roomNumber) {
        return roomNumber==null?false:deleteById(getId(roomNumber));
    }

    /**
     * 将一个房间对象对象从数据库中删除
     *
     * @param room 要删除的房间对象
     * @return boolean
     * @name delete
     * @notice 该房间对象必须至少包含房间的id
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean delete(Room room) {
        return deleteById(room.getId());
    }


    /**
     * 更新一个房间的信息
     *
     * @param room 要更新的房间对象
     * @return boolean
     * @name update
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean update(Room room) {
        return room == null?false:super.update(room) == 1;
    }

}
