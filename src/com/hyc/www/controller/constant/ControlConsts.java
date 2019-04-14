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
public class ControlConsts {

    /**
     * request中method的枚举常量
     */
    public enum Methods {
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
         * 显示退出成功界面
         */
        LOGOUT_SUCCESS_VIEW("logout.view"),
        /**
         * 执行退出登陆方法
         */
        LOGOUT_DO("logout.do");

        private final String name;
        Methods(String name){
            this.name = name;
        }
    }

    /**
     * 界面的地址常量
     */
    public enum Pages{
        /**
         * 登陆界面
         */
        LOGIN_PAGE(),
        REGIST_PAGE(),
        LOGOUT_SUCCESS_PAGE(),
        INDEX_PAGE();

    }


}
