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
 * request中method的枚举常量
 *
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description
 * @date 2019-04-18 12:45
 */

public enum Methods {

    /**
     * 显示主页
     */
    INDEX_VIEW,

    /*
     **************************************************************
     *               用户
     **************************************************************
     */
    /**
     * 执行登陆方法
     */
    LOGIN_DO,
    /**
     * 执行注册方法
     */
    REGIST_DO,

    /**
     * 执行退出登陆方法
     */
    LOGOUT_DO,

    /*
     **************************************************************
     *               通用操作方法
     **************************************************************
     */
    /**
     * 添加
     */
    ADD_DO,
    /**
     * 删除
     */
    DELETE_DO,
    /**
     * 更新
     */
    UPDATE_DO,

    /**
     * 查找
     */
    FIND_DO;


}

