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

import com.hyc.www.exception.DaoException;

import java.io.IOException;
import java.util.Properties;


/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责生产实现类
 * @date 2019-04-08 23:33
 */
public class BeanFactory {

    /**
     * 配置文件
     */
    private static final String PROPERTIES = "factory.properties";

    private BeanFactory() {

    }

    public enum DaoType {
        /**
         * Dao实现类
         */
        UserDao("UserDao"), RoomDao("RoomDao"), OrderRoomDao("OrderRoomDao"),
        HotelDao("HotelDao"),RemarkDao("RemarkDao");

        private String name;
        DaoType(String name) {
            this.name=name;
        }
    }
    public enum ServiceType{
        /**
         * Service实现类
         */
        UserService("UserService"),RoomService("RoomService"),OrderRoomService("OrderRoomService"),RemarkService("RemarkService");
        private String name;
        ServiceType(String name) {
            this.name=name;
        }
    }

    public static Object getBean(Enum beanType) {
        String className;
        Object bean;
        /**
         * 加载配置文件
         */
        Properties prop = new Properties();
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES));
            className = prop.getProperty(beanType.name());
        } catch (IOException e) {
            e.printStackTrace();
            throw new DaoException("无法加载配置文件 ：" + PROPERTIES, e);
        }
        try {
            bean = Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DaoException("无法加载类 : " + className, e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new DaoException("无法实例化类 : " + className, e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new DaoException("无法初始化实例 ：" + className, e);
        }
        return bean;
    }

}
