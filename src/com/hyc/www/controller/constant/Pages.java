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
 * 界面的地址常量
 *
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description
 * @date 2019-04-18 12:48
 */
public enum Pages {


    /**
     * 注册界面
     */
    REGIST_JSP,
    /**
     * 网站首页
     */
    INDEX_JSP,
    /**
     * 错误页面
     */
    ERROR_JSP,
    /**
     * 房间页面
     */
    ROOM_JSP,
    /**
     * 登陆界面
     */
    LOGIN_JSP,
    /**
     * 用户界面
     */
    USER_JSP,
    /**
     * 订单界面
     */
    ORDER_JSP,
    /**
     * 成功页面
     */
    SUCCESS_JSP,
    /**
     * 相册页面
     */
    PICTRUES_JSP;


    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        return super.toString().toLowerCase().replace("_", ".");
    }}