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

import com.hyc.www.po.Room;
import com.hyc.www.po.User;
import com.hyc.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

import static com.hyc.www.util.JdbcUtils.getConnection;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试JdbcUtils
 * @date 2019-04-08 23:24
 */
public class TestJdbcUtils {
    public static void main(String[] args) throws SQLException {

        /*
         ***************************************************************
         *              测试从jdbcUtils取链接
         * ************************************************************
         * */

        System.out.println("当前连接数：" + JdbcUtils.getCurrentCount());
        System.out.println("空闲连接数：" + JdbcUtils.getfreeCount());
        for (int i = 0; i < 3; i++) {

            System.out.println(getConnection());
        }
        System.out.println("当前连接数：" + JdbcUtils.getCurrentCount());
        System.out.println("空闲连接数：" + JdbcUtils.getfreeCount());

        Connection conn=null;
        for (int i = 0; i < 10; i++) {
            conn = getConnection();
            JdbcUtils.close(conn);
            System.out.println(conn);
        }
        System.out.println("当前连接数：" + JdbcUtils.getCurrentCount());
        System.out.println("空闲连接数：" + JdbcUtils.getfreeCount());
    }
}
