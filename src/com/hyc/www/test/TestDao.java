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

import com.hyc.www.dao.DaoFactory;
import com.hyc.www.dao.impl.BaseDaoImpl;
import com.hyc.www.dao.inter.BaseDao;
import com.hyc.www.dao.inter.UserDao;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试Dao实现类
 * @date 2019-04-09 00:15
 */
public class TestDao {
    public static void main(String[] args) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        /**
         * 测试BaseDao
         */
        BaseDao baseDao =new BaseDaoImpl();
        ((BaseDaoImpl) baseDao).executeUpdate("insert into ? (user_name,balance) values (?,?)",new Object[]{"tb_user","testdao",100f});

    }
}
