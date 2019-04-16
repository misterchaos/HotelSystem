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
import com.hyc.www.util.StringUtils;
import sun.awt.SunHints;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.hyc.www.util.UUIDUtils.getUUID;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试String工具类
 * @date 2019-04-15 17:37
 */
public class TestStringUtils {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println(StringUtils.field2GetMethod("userName"));
        System.out.println(StringUtils.field2SqlField("userName"));
        Field f = User.class.getDeclaredField("userName");
        Method m = User.class.getDeclaredMethod("setUserName",f.getType());
        Object obj = User.class.newInstance();
            m.invoke(obj,"test");
        System.out.println(((User) obj).getUserName());
        System.out.println(getUUID());
    }
}
