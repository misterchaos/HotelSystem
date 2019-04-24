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

package com.hyc.www.util;

import com.hyc.www.po.OrderRoom;
import com.hyc.www.po.Room;
import com.hyc.www.po.User;
import com.hyc.www.service.Result;
import com.hyc.www.service.constant.Status;
import com.hyc.www.vo.PagesVo;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于service的工具类，主要是数据检测功能
 * @date 2019-04-16 00:47
 */
public class ServiceUtils {


    /*
     **************************************************************
     *               返回数据
     **************************************************************
     */


    /**
     * 负责给Service层返回数据和状态
     *
     * @param rooms   房间数据
     * @param status 状态量
     * @name setResult
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/20
     */
    public static Result setResult(LinkedList<Room> rooms, Status status) {
        /**
         * 把数据装入vo
         */
        PagesVo vo = new PagesVo();
        vo.setRooms(rooms);
        /**
         * 把vo和枚举类装入Result对象
         */
        return new Result(status, vo);
    }


    /**
     * 负责给Service层返回数据和状态
     *
     * @param room   房间数据
     * @param status 状态量
     * @return com.hyc.www.service.constant.Status
     * @name setResult
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/20
     */
    public static Result setResult(Room room, Status status) {
        PagesVo vo = new PagesVo();
        LinkedList<Room> list = new LinkedList();
        list.add(room);
        vo.setRooms(list);
        return new Result(status,vo);
    }


    /**
     * 负责给Service层返回数据和状态
     *
     * @param user   用户数据
     * @param status 状态量
     * @return com.hyc.www.service.constant.Status
     * @name setResult
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/20
     */
    public static Result setResult(User user, Status status) {
        PagesVo vo = new PagesVo();
        LinkedList<User> list = new LinkedList<>();
        list.add(user);
        vo.setUsers(list);
        return new Result(status,vo);
    }

    /**
     * 负责给Service层返回数据和状态
     *
     * @param users  用户数据集合
     * @param status 状态量
     * @return com.hyc.www.service.constant.Status
     * @name setResult
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/20
     */
    public static Result setUserResult(LinkedList<User> users, Status status) {
        PagesVo vo = new PagesVo();
        vo.setUsers(users);
        return new Result(status,vo);
    }

    /**
     * 负责给Service层返回数据和状态
     *
     * @param orderRooms 订单数据集合
     * @param status     状态量
     * @return com.hyc.www.service.constant.Status
     * @name setResult
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/20
     */
    public static Result setOrderRoomResult(LinkedList<OrderRoom> orderRooms, Status status) {
        PagesVo vo = new PagesVo();
        vo.setOrderRooms(orderRooms);
        return new Result(status,vo);
    }

    /**
     * 负责给Service层返回数据和状态
     *
     * @param orderRoom 订单数据
     * @param status    状态量
     * @return com.hyc.www.service.constant.Status
     * @name setResult
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/20
     */
    public static Result setResult(OrderRoom orderRoom, Status status) {
        PagesVo vo = new PagesVo();
        LinkedList<OrderRoom> list = new LinkedList<>();
        list.add(orderRoom);
        vo.setOrderRooms(list);
        return new Result(status,vo);
    }


    /**
     * 负责给Service层返回状态
     *
     * @param status    状态量
     * @return com.hyc.www.service.constant.Status
     * @name setResult
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/20
     */
    public static Result setResult(Status status){
        return new Result(status,null);
    }


    /*
     **************************************************************
     *               检查用户信息
     **************************************************************
     */


    public static boolean isValidRegist(User user) {
        return user != null && (isValidUserName(user.getName()) && isValidPwd(user.getPassword()));
    }

    public static boolean isValidUserInfo(User user) {

        return user != null && isValidIdNumber(user.getIdNumber()) && isValidNickName(user.getNickName()) && isValidPhoneNum(user.getPhoneNumber());
    }

    public static boolean isValidUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            return false;
        }
        String regex = "[\\w_]{6,20}$";
        return userName.matches(regex);
    }

    public static boolean isValidPwd(String pwd) {
        if (pwd == null || pwd.trim().isEmpty()) {
            return false;
        }
        String regex = "[\\w_]{6,20}$";
        return pwd.matches(regex);
    }

    public static boolean isValidPhoneNum(String number) {
        if (number == null || number.trim().isEmpty()) {
            return false;
        }
        String regex = "0?(13|14|15|17|18|19)[0-9]{9}";
        return number.matches(regex);
    }

    public static boolean isValidIdNumber(String number) {
        if (number == null || number.trim().isEmpty()) {
            return false;
        }
        String regex = "\\d{17}[\\d|x]|\\d{15}";
        return number.matches(regex);
    }

    public static boolean isValidNickName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 20) {
            return false;
        }
        return true;
    }

    /*
     **************************************************************
     *               检查房间信息
     **************************************************************
     */

    public static boolean isValidRoom(Room room) {
        return isValidName(room) && isValidArea(room) && isValidBedWidth(room) && isValidPrice(room);
    }

    /**
     * 合理长度100
     */
    private static boolean isValidName(Room room) {
        return room != null && room.getName().length() < 100;
    }

    /**
     * 房间面积合理范围10-300
     *
     * @param room
     */
    private static boolean isValidArea(Room room) {
        return room != null && room.getArea() != null && room.getArea().compareTo(new BigDecimal(10)) > 0 && room.getArea().compareTo(new BigDecimal(300)) < 0;
    }

    /**
     * 床宽合理范围1-10
     *
     * @param room
     */
    private static boolean isValidBedWidth(Room room) {
        return room != null && room.getBedWidth() != null && room.getBedWidth().compareTo(new BigDecimal(1)) > 0 && room.getBedWidth().compareTo(new BigDecimal(5)) < 0;
    }

    /**
     * 价格合理范围0-100000
     *
     * @param room
     */
    private static boolean isValidPrice(Room room) {
        return room != null && room.getPrice() != null && room.getPrice().compareTo(new BigDecimal(0)) > 0 && room.getPrice().compareTo(new BigDecimal(100000)) < 0;
    }

    /*
     **************************************************************
     *               检查订单信息
     **************************************************************
     */

    /**
     * 检查订单
     */
    public static boolean isValidRoomOrder(OrderRoom order) {
        //TODO 需要检查重复性
        return true;
    }

}
