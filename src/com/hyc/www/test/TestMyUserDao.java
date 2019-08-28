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

import com.hyc.www.dao.inter.MyUserDao;
import com.hyc.www.po.User;
import com.hyc.www.proxy.SQLHandler;

import java.lang.reflect.Proxy;

import static com.hyc.www.util.UUIDUtils.getUUID;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description
 * @date 2019-05-01 10:47
 */
public class TestMyUserDao {
    public static void main(String[] args) {
        User user = new User();
        user.setId(getUUID());
        user.setName("testtest");
        MyUserDao dao = (MyUserDao) Proxy.newProxyInstance(SQLHandler.class.getClassLoader(),new Class[]{MyUserDao.class},new SQLHandler());
        dao.insert(user);

    }
}
