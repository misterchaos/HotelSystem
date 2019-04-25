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

import com.hyc.www.dao.impl.UserDaoImpl;
import com.hyc.www.dao.inter.UserDao;
import com.hyc.www.po.User;

import java.math.BigDecimal;
import java.util.LinkedList;

import static com.hyc.www.util.Md5Utils.getDigest;
import static com.hyc.www.util.UUIDUtils.getUUID;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试UserDao的实现类
 * @date 2019-04-11 13:21
 */
public class TestUserDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        /**
         * 测试查询密码功能
         */
        System.out.println("测试查询密码功能");
        System.out.println(userDao.getPassword("test"));
        /**
         * 测试查询用户全部信息功能
         */
        System.out.println("测试查询用户全部信息功能");
        User user = userDao.getUser("test2");
        if (user != null) {
            System.out.println(user.getName());
            System.out.println(user.getId());
            System.out.println(user.getStatus());
            System.out.println(user.getPhoneNumber());
            System.out.println(user.getGmtModified());
            System.out.println(user.getType());
        } else {
            System.out.println(user);
        }

        /**
         * 测试获取所有用户信息的功能
         */
        System.out.println("测试获取所有用户信息的功能");
        LinkedList list = userDao.getAllUsers();
        System.out.println(list.size());
        /**
         * 测试通过用户id删除用户的功能
         */
        System.out.println("测试通过用户id删除用户的功能");
        System.out.println(userDao.deleteById(String.valueOf(10)));
        /**
         * 测试通过用户名删除用户的功能
         */
        System.out.println("测试通过用户名删除用户的功能");
        System.out.println(userDao.deleteByUserName("testdao"));
        /**
         * 测试更新用户信息的功能
         */
        System.out.println("测试更新用户信息的功能");
        user = new User();
        user = userDao.getUser("test2");
        System.out.println(userDao.updateAll(null));

        /**
         * 测试增加用户的功能
         */
        System.out.println("测试增加用户的功能");
        user = new User();
        user.setName("test2");
        user.setPhoto("test");
        user.setId(getUUID());
        System.out.println(user.getBalance());
        System.out.println(user.getNickName());
        System.out.println(user.getStatus());
        System.out.println(user.getGmtModified());
        System.out.println(userDao.addUser(user));

        /**
         * 批量删除与添加
         */

        for (int i = 1; i < 0; i++) {
            userDao.deleteById(String.valueOf(i));
        }

        for (int i = 0; i <0; i++) {
            user.setId(getUUID());
            user.setPassword(getDigest("1234"));
            user.setName("test"+i);
            user.setNickName("tom");
            user.setIdNumber("440823199912202118");
            user.setBalance(new BigDecimal("999"+i*10));
            user.setPhoto("默认头像.jpg");
            user.setPhoneNumber("15816019724");
            userDao.addUser(user);
        }


    }
}
