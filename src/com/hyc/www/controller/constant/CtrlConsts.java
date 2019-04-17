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

package com.hyc.www.controller.constant;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 与流程跳转相关的常量
 * @date 2019-04-13 23:20
 */
public class CtrlConsts {

    /**
     * request中method的枚举常量
     */
    public enum Method {


        /**
         * 显示主页
         */
        INDEX_VIEW("index.view"),

        /*
         **************************************************************
         *               用户
         **************************************************************
         */
        /**
         * 执行登陆方法
         */
        LOGIN_DO("login.do"),
        /**
         * 显示登陆界面
         */
        LOGIN_VIEW("login.view"),
        /**
         * 执行注册方法
         */
        REGIST_DO("regist.do"),
        /**
         * 显示注册界面
         */
        REGIST_VIEW("regist.view"),
        /**
         * 查看个人信息
         */
        MY_INFO_DO("myinfo.do"),
        /**
         * 个人信息界面
         */
        MY_INFO_VIEW("myinfo.view"),
        /**
         * 执行更新信息操作
         *
         */
        UPDATE_INFO_DO("update_info.do"),
        /**
         * 执行更新登陆密码操作
         */
        UPDATE_PWD_DO("update_pwd.do"),

        /**
         * 执行更新支付密码操作
         */
        UPDATE_PAY_PWD_DO("update_pay_pwd.do"),
        /**
         * 显示退出成功界面
         */
        LOGOUT_SUCCESS_VIEW("logout.view"),
        /**
         * 执行退出登陆方法
         */
        LOGOUT_DO("logout.do"),

        /*
         **************************************************************
         *               房间
         **************************************************************
         */
        /**
         * 添加房间
         */
        ADD_ROOM("add_room.do"),
        /**
         * 删除房间
         */
        DELETE_ROOM("delete_room.do"),
        /**
         * 更新房间信息
         */
        UPDATE_ROOM("update_room.do"),
        /**
         * 查找房间
         */
        FIND_ROOM("find_room.do"),

        /*
         **************************************************************
         *               房间订单
         **************************************************************
         */
        ADD_ORDER_ROOM("add_order_room.do"),
        DELETE_ORDER_ROOM("delete_order_room.do");

        private String name;


        /**
         * 返回该名称对应的方法
         *
         * @param name 方法名称
         * @return 枚举项
         * @name getValue
         * @notice none
         * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
         * @date 2019/4/14
         */
        public static Method getValue(String name) {
            for (Method mt : Method.values()) {
                if (mt.getName().equalsIgnoreCase(name)) {
                    return mt;
                }
            }
            return INDEX_VIEW;
        }

        public String getName() {
            return name;
        }

        Method(String name) {
            this.name = name;
        }
    }

    /**
     * 界面的地址常量
     */
    public enum Pages {
        /**
         * 登陆界面
         */
        LOGIN_PAGE("login.jsp", "login.jsp"),
        REGIST_PAGE("regist.jsp", "regist.jsp"),
        LOGOUT_SUCCESS_PAGE("logout.jsp", "logout.jsp"),
        INDEX_PAGE("index.jsp", "index.jsp");

        private String name;
        private String path;

        Pages(String name, String path) {
            this.name = name;
            this.path = path;
        }
    }



}
