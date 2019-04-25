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

import com.hyc.www.util.BeanFactory;
import com.hyc.www.dao.impl.BaseDaoImpl;
import com.hyc.www.dao.inter.UserDao;
import com.hyc.www.po.User;

import java.util.Iterator;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试Dao实现类
 * @date 2019-04-09 00:15
 */
public class TestDao {
    public static void main(String[] args) {
        UserDao userDao = (UserDao) BeanFactory.getBean(BeanFactory.DaoType.UserDao);
        /**
         * 测试BaseDao
         */
        BaseDaoImpl baseDao = new BaseDaoImpl();
        User user = new User();

        System.out.println(baseDao.queryCount("t_user", "balance"));
        System.out.println(baseDao.queryWhereAndEquals(new String[]{"user_name"}, user).size());

        /**
         * 测试插入
         */
        user.setName("test");
        baseDao.insert(null);

        /***
         * 测试分页查询
         */
        System.out.println("pages num " + baseDao.queryPages(new String[]{"user_name"}, "t_user", "30", "0").size());
        Iterator it = baseDao.queryPages(new String[]{"user_name"}, "t_user", "10", "0").listIterator();
        while (it.hasNext()) {
            user = (User) it.next();
            System.out.println(user.getName());
        }

        /**
         * 测试模糊查询
         */
        user.setName("%new%");
        user.setPassword("12345");
        it = baseDao.queryWhereLikeAnd(new String[]{"user_name"}, user).listIterator();
        while (it.hasNext()) {
            user = (User) it.next();
            System.out.println(user.getName());
        }
        /**
         * 测试查询很多记录
         */
        System.out.println(baseDao.queryList("select * from t_user",new Object[]{},User.class).size());
    }
}
