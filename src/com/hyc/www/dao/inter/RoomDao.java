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

package com.hyc.www.dao.inter;

import com.hyc.www.po.Room;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责对房间进行CRUD操作
 * @date 2019-04-11 23:43
 */
public interface RoomDao {

    /**
     * 添加一个房间到数据库
     *
     * @param room 要添加的房间
     * @return boolean
     * @name addRoom
     * @notice 无法添加房间编号为空的用户
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    boolean addRoom(Room room);

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
    Room getRoom(String roomNum);


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
    String getId(String roomNum);

    /**
     * 获取表中所有房间的信息，并以LinkedList的形式返回
     *
     * @return java.util.LinkedList
     * @name getAllRooms
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    LinkedList<Room> getAllRooms();


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
    boolean deleteById(String Id);


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
    boolean deleteByNumber(String roomNumber);

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
    boolean delete(Room room);


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
    boolean update(Room room);

}
