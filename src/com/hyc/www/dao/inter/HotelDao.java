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

import com.hyc.www.po.Hotel;

import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责酒店的CRUD
 * @date 2019-04-18 01:57
 */
public interface HotelDao {
    /**
     * 通过酒店编号检查一个酒店是否已经存在
     *
     * @param hotelNumber 酒店编号
     * @return boolean
     * @name isExist
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/16
     */
    boolean isExist(String hotelNumber);

    /**
     * 添加一个酒店到数据库
     *
     * @param hotel 要添加的酒店
     * @return boolean
     * @name addHotel
     * @notice 无法添加酒店编号为空的用户
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    boolean addHotel(Hotel hotel);

    /**
     * 根据酒店编号查询一个酒店的所有信息
     *
     * @param hotelNum
     * @return com.hyc.www.po.Hotel
     * @name getHotel
     * @notice 如果酒店为空或者没有该酒店，则返回null;
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    Hotel getHotel(String hotelNum);


    /**
     * 返回该酒店编号对应的id
     *
     * @param hotelNum 酒店编号
     * @return java.math.String
     * @name getId
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    String getId(String hotelNum);

    /**
     * 获取表中所有酒店的信息，并以LinkedList的形式返回
     *
     * @return java.util.LinkedList
     * @name getAllHotels
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    LinkedList<Hotel> getAllHotels();


    /**
     * 将该id对应的酒店从数据库中删除
     *
     * @param Id 要删除酒店的id
     * @return boolean
     * @name deleteById
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    boolean deleteById(String Id);


    /**
     * 将该酒店编号对应的酒店从数据库中删除
     *
     * @param hotelNumber 要删除的酒店的酒店编号
     * @return boolean
     * @name deleteByNumber
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    boolean deleteByNumber(String hotelNumber);

    /**
     * 将一个酒店对象对象从数据库中删除
     *
     * @param hotel 要删除的酒店对象
     * @return boolean
     * @name delete
     * @notice 该酒店对象必须至少包含酒店的id
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    boolean delete(Hotel hotel);


    /**
     * 更新一个酒店的信息
     *
     * @param hotel 要更新的酒店对象
     * @return boolean
     * @name update
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    boolean update(Hotel hotel);

    /**
     * 通过酒店名进行模糊查询
     *
     * @param name 酒店名
     * @name findByName
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/18
     */
    LinkedList<Hotel> findByName(String name);

}
