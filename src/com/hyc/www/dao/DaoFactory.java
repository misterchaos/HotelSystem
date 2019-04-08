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

package com.hyc.www.dao;

import com.hyc.www.dao.inter.UserDao;
import com.hyc.www.exception.DaoException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责生产Dao实现类
 * @date 2019-04-08 23:33
 */
public class DaoFactory {
    /**
     * 配置文件路径
     */
    private static String propPath = "./src/dao_config.properties";
    private static String userDao;
    private static DaoFactory instance = new DaoFactory();

    static {
        try {
            /**
             * 加载配置文件
             */
            Properties prop = new Properties();
            prop.load(new FileReader(new File(propPath)));
            userDao = prop.getProperty("UserDao");
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }


    /**
     * 用于提供UserDao的实现类实例
     * @name getUserDao
     * @return com.hyc.www.dao.inter.UserDao
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/9
     */
    public UserDao getUserDao() {

        try {
            UserDao instance = (UserDao) Class.forName(userDao).newInstance();
            return instance;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DaoException("无法加载类 : " + userDao, e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new DaoException("无法实例化类 : " + userDao, e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new DaoException("无法初始化实例 ：" + userDao, e);
        }
    }
}
