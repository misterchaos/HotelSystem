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
import com.hyc.www.util.JdbcUtils;

import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责对房间的CRUD
 * @date 2019-04-11 23:45
 */
public class RoomDaoImpl extends BaseDaoImpl implements RoomDao {

    /**
     *
     */
    private final int limit = 10;

    /**
     * 本类操作的数据库表名
     */
    private final String TABLE_NAME = " " + JdbcUtils.getTableName(Room.class) + " ";

    /**
     * 表中所有字段对应的查询语句
     */
    private final String ALL_FIELD_NAME = " id,name,number,photo,type,area,bed_width,price,book_status,level,"
            + "score,remark,remark_num,hotel_id,status,gmt_create,gmt_modified ";

    private final String[] ALL_FIELD_ARRAY = new String[]{"id", "name", "number", "photo", "type", "area", "bed_width",
            "price", "book_status", "score", "remark","remark_num", "hotel_id", "status", "gmt_create", "gmt_modified"};


    /**
     * 通过房间编号检查一个房间是否已经存在
     *
     * @param roomNumber 房间编号
     * @return boolean
     * @name isExist
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/16
     */
    @Override
    public boolean isExist(String roomNumber) {
        return getRoom(roomNumber) != null;
    }

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
        return super.insert(room) == 1;
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
     * 根据房间id查询一个房间的所有信息
     *
     * @param id
     * @return com.hyc.www.po.Room
     * @name getRoom
     * @notice 如果id为空或者没有该房间，则返回null;
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    @Override
    public Room getRoomById(String id) {
        if (id == null) {
            return null;
        }
        String sql = "select " + ALL_FIELD_NAME + " from " + TABLE_NAME + " where id  = ?";
        return (Room) super.queryObject(sql, new Object[]{id}, Room.class);
    }

    /**
     * 返回该房间编号对应的id
     *
     * @param roomNum 房间编号
     * @return java.math.String
     * @name getId
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public String getId(String roomNum) {
        String sql = "select id from " + TABLE_NAME + " where number = ?";
        return (String) super.queryValue(sql, new Object[]{roomNum});
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
        return toRoomList(list);
    }

    private LinkedList<Room> toRoomList(LinkedList<Object> list) {
        LinkedList<Room> rooms = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            Room room = (Room) list.get(i);
            rooms.add(room);
        }
        return rooms;
    }


    /**
     * 通过房间名进行模糊查询
     *
     * @param name 房间名
     * @name findByName
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/18
     */
    @Override
    public LinkedList<Room> findByName(String name) {
        Room room = new Room();
        room.setName("%" + name + "%");
        LinkedList<Object> list = super.queryWhereLikeAnd(ALL_FIELD_ARRAY, room);
        return toRoomList(list);
    }

    /**
     * 通过房间名进行模糊查询
     * 当name为null值时将查询所有记录
     *
     * @param name 房间名
     * @param page 页数
     * @name findByName
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/18
     */
    @Override
    public LinkedList<Room> findByName(String name, int page) {

        /**
         * 不允许page小于1
         */
        page = page < 1 ? 1 : page;
        int offset = (page - 1) * limit;
        int maxOffset = getCountByName(name);
        /**
         * 不允许offset大于maxOffset
         */
        offset = offset > maxOffset ? maxOffset : offset;
        LinkedList list = null;
        if (name != null) {
            String sql = "select " + ALL_FIELD_NAME + " from " + TABLE_NAME +
                    " where name like ? limit " + limit + " offset " + offset;
            list = super.queryList(sql, new String[]{"%" + name + "%"}, Room.class);
        } else {
            String sql = "select " + ALL_FIELD_NAME + " from " + TABLE_NAME +
                    " limit " + limit + " offset " + offset;
            list = super.queryList(sql, new String[0], Room.class);
        }
        return toRoomList(list);
    }

    /**
     * 统计通过名称模糊查询的记录数
     *
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/21
     */
    @Override
    public int getCountByName(String name) {
        String sql = "select count(*) from " + TABLE_NAME + " where name like ? ";
        return Math.toIntExact((long) super.queryValue(sql, new String[]{"%" + name + "%"}));
    }

    /**
     * 统计通过名称模糊查询的记录页数
     *
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/21
     */
    @Override
    public int getMaxPageByName(String name) {
        return getCountByName(name)/limit+1;
    }

    /**
     * 将该id对应的房间从数据库中删除
     *
     * @param id 要删除房间的id
     * @return boolean
     * @name deleteById
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean deleteById(String id) {
        if (id == null) {
            return false;
        }
        Room room = new Room();
        room.setId(id);
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
        return roomNumber != null && deleteById(getId(roomNumber));
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
        return room != null && super.update(room) == 1;
    }

}
