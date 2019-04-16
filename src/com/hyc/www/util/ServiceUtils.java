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

import com.hyc.www.po.User;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于service的工具类，主要是数据检测功能
 * @date 2019-04-16 00:47
 */
public class ServiceUtils {
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
}
