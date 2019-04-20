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

import com.hyc.www.po.User;
import com.hyc.www.util.BeanUtils;

import java.util.*;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试BeanUtils工具类
 * @date 2019-04-15 18:38
 */
public class TestBeanUtils {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        String[] value = new String[1];
        value[0]="test";
        map.put("userName", value);
        value[0]="3";
        map.put("balance", value);
        Date d = new Date();
        Class clazz = User.class;
        User user = (User) BeanUtils.toObject(map,clazz);
        System.out.println(user.getName());
        System.out.println(user.getBalance());
    }
}
