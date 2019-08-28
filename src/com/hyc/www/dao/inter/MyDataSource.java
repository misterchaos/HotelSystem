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

package com.hyc.www.dao.inter;

import com.hyc.www.exception.DaoException;

import java.sql.Connection;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责提供数据库连接池，向dao实现类提供数据库连接
 * @date 2019-04-08 00:29
 */
public interface MyDataSource {


    /**
     * 负责从数据库连接池中获取数据库连接
     *
     * @return java.sql.Connection
     * @throws DaoException 如果数据库连接已经达到最大值时仍然调用此方法，则抛出此异常
     * @name getConnection
     * @notice 数据库连接的数量受到配置文件中最大值的限制
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    Connection getConnection() throws DaoException;


    /**
     * 用于将数据库连接放回连接池中
     *
     * @param conn 数据库连接
     * @name freeConnection
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    void freeConnection(Connection conn);


    /**
     * 负责返回当前已经创建的连接数
     *
     * @return int 当前已经创建的连接数
     * @name getCurrentCount
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    int getCurrentCount();

    /**
     * 负责返回当前池中剩余的空闲连接数
     *
     * @return int 当前空闲连接数
     * @name getfreeCount
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    int getfreeCount();

}
