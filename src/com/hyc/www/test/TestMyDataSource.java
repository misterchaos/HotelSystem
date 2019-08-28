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

import com.hyc.www.dao.impl.MyDataSourceImpl;
import com.hyc.www.dao.inter.MyDataSource;
import com.hyc.www.util.JdbcUtils;

import java.sql.Connection;

import static com.hyc.www.util.JdbcUtils.getConnection;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试数据库连接池
 * @date 2019-04-08 02:11
 */
public class TestMyDataSource {


    public static void main(String[] args) throws ClassNotFoundException {

        getConnection();
        System.out.println("测试直接从连接池获取连接");
        MyDataSource dataSource = MyDataSourceImpl.getInstance();
        Connection conn = dataSource.getConnection();
        System.out.println("获取一个连接\n");
        System.out.println(conn);
        System.out.println("当前已创建连接数 = " + dataSource.getCurrentCount());
        System.out.println("当前空闲连接数 = " + dataSource.getfreeCount());
        System.out.println("释放一个连接");
        dataSource.freeConnection(conn);
        for (int i = 0; i < 10; i++) {
            conn = dataSource.getConnection();
            System.out.println(conn);
            dataSource.freeConnection(conn);
        }
        System.out.println("释放一个连接");
        dataSource.freeConnection(conn);
        System.out.println("当前已创建连接数 = " + dataSource.getCurrentCount());
        System.out.println("当前空闲连接数 = " + dataSource.getfreeCount());



    }
}
