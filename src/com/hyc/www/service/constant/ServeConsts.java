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

package com.hyc.www.service.constant;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于service层的常量
 * @date 2019-04-15 00:49
 */
public class ServeConsts {
    /**
     * 用于描述服务的状态
     */
    public enum Status {
        /*
         **************************************************************
         *              注册状态
         **************************************************************
         */
        /**
         * 注册成功
         */
        REGIST_SUCCESS,
        /**
         * 重复注册
         */
        ACCOUNT_ALREADY_EXIST,
        /**
         * 数据不合法
         */
        DATA_ILLEGAL,


        /*
         **************************************************************
         *              登陆状态
         **************************************************************
         */

        /**
         * 登陆成功
         */
        LOGIN_SUCCESS,
        /**
         * 找不到账户
         */
        ACCOUNT_NOT_FOUNT,
        /**
         * 密码错误
         */
        PASSWORD_INCORRECT,
        /*
         **************************************************************
         *              修改信息状态
         **************************************************************
         */
        UPDATE_SUCCESS,
        PERMISSION_DENY,


        /**
         * 服务成功
         */
        SUCCESS,
        /**
         * 服务异常
         */
        ERROR;

        /**
         * 状态码
         */
        String name;
        /**
         * 提示消息
         */
        String message;
    }
}
