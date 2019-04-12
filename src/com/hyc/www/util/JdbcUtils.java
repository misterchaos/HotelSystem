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

package com.hyc.www.util;

import com.hyc.www.dao.impl.MyDataSourceImpl;
import com.hyc.www.dao.inter.MyDataSource;
import com.hyc.www.exception.DaoException;

import java.sql.*;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于从数据库连接池中获取连接和将连接放回数据库连接池
 * @date 2019-04-08 03:00
 */
public class JdbcUtils {

    private static MyDataSource dataSrc = MyDataSourceImpl.getInstance();

    private JdbcUtils() {

    }


    /**
     * 负责从数据库连接池中获取数据库连接
     *
     * @return java.sql.Connection
     * @name getConnection
     * @notice 数据库连接的数量受到配置文件中最大值的限制
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    public static Connection getConnection() {
        return dataSrc.getConnection();
    }


    /**
     * 用于将数据库连接放回连接池中,并释放Statement和ResultSet的资源
     *
     * @param conn 数据库连接
     * @name close
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            dataSrc.free(conn);
        }
    }

    /**
     * 用于将一个数据库连接放回连接池中
     *
     * @param conn 数据库连接
     * @name close
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    public static void close(Connection conn) {
        if (conn != null) {
            dataSrc.free(conn);
        }
    }


    /**
     * 负责返回当前池中剩余的空闲连接数
     *
     * @return int 当前空闲连接数
     * @name getfreeCount
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    public static int getfreeCount() {
        return dataSrc.getfreeCount();
    }


    /**
     * 负责返回当前已经创建的连接数
     *
     * @return int 当前已经创建的连接数
     * @name getCurrentCount
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    public static int getCurrentCount() {
        return dataSrc.getCurrentCount();
    }

    /**
     * 负责根据传入的参数数组给PreparedStatement填入参数
     *
     * @param ps     需要设参的预编译sql语句
     * @param params 参数数组
     * @name setParams
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    public static void setParams(PreparedStatement ps, Object[] params) {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                try {
                    ps.setObject(i+1, params[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DaoException("预编译参数异常："+ps.toString(),e);
                }
            }
        }
    }

}
