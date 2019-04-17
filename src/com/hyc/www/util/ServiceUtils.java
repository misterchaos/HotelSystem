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

import com.hyc.www.po.Room;
import com.hyc.www.po.User;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于service的工具类，主要是数据检测功能
 * @date 2019-04-16 00:47
 */
public class ServiceUtils {


    /*
     **************************************************************
     *               检查用户信息
     **************************************************************
     */


    public static boolean isValidRegist(User user) {
        return user != null && (isValidUserName(user.getUserName()) && isValidPwd(user.getPassword()));
    }
    public static boolean isValidUserInfo(User user){

        return user!=null&&isValidIdNumber(user.getIdNumber())&&isValidNickName(user.getNickName())&&isValidPhoneNum(user.getPhoneNumber());
    }
    public static boolean isValidUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            return false;
        }
        String regex = "[A-Za-z]+[0-9]+";
        return userName.matches(regex);
    }
    public static boolean isValidPwd(String pwd) {
        if (pwd == null || pwd.trim().isEmpty()) {
            return false;
        }
        String regex = "[A-Za-z]+[0-9]+";
        return pwd.matches(regex);
    }
    public static boolean isValidPhoneNum(String number){
        if (number == null || number.trim().isEmpty()) {
            return false;
        }
        String regex = "0?(13|14|15|17|18|19)[0-9]{9}";
        return number.matches(regex);
    }
    public static boolean isValidIdNumber(String number){
        if (number == null || number.trim().isEmpty()) {
            return false;
        }
        String regex = "\\d{17}[\\d|x]|\\d{15}";
        return number.matches(regex);
    }
    public static boolean isValidNickName(String name){
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        String regex = "[A-Za-z]+[0-9]+";
        return name.matches(regex);
    }

    /*
     **************************************************************
     *               检查房间信息
     **************************************************************
     */

    public static boolean isValidRoom(Room room){
        return isValidArea(room) && isValidBedWidth(room) && isValidPrice(room);
    }

    /**
     * 房间面积合理范围10-300
     * @param room
     */
    private static boolean isValidArea(Room room){
        return room!=null&&room.getArea()!=null&&room.getArea().compareTo(new BigDecimal(10))>0&&room.getArea().compareTo(new BigDecimal(300))<0;
    }

    /**
     * 床宽合理范围1-5
     * @param room
     */
    private static boolean isValidBedWidth(Room room){
        return room!=null&&room.getBedWidth()!=null&&room.getBedWidth().compareTo(new BigDecimal(1))>0&&room.getBedWidth().compareTo(new BigDecimal(5))<0;
    }

    /**
     * 价格合理范围0-100000
     * @param room
     */
    private static boolean isValidPrice(Room room){
        return room!=null&&room.getPrice()!=null&&room.getPrice().compareTo(new BigDecimal(0))>0&&room.getPrice().compareTo(new BigDecimal(100000))<0;
    }



}
