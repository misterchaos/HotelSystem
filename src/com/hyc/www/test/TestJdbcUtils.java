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

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试JdbcUtils
 * @date 2019-04-08 23:24
 */
public class TestJdbcUtils {
    public static void main(String[] args) {
        System.out.println("测试通过jdbcUtil获取连接");
        Connection conn = JdbcUtils.getConnection();

        for (int i = 0; i < 9; i++) {
            conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }
        System.out.println("释放一个连接");
        JdbcUtils.close(null,null,conn);
        System.out.println("当前已创建连接数 = " + JdbcUtils.getCurrentCount());
        System.out.println("当前空闲连接数 = " + JdbcUtils.getfreeCount());

        System.out.println(JdbcUtils.getTableName(new User()));
        System.out.println(JdbcUtils.getTableName(new Room()));
    }
}
