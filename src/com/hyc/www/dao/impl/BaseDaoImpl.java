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

package com.hyc.www.dao.impl;

import com.hyc.www.dao.inter.BaseDao;
import com.hyc.www.exception.DaoException;
import com.hyc.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 所有Dao接口实现类的父类，提供共有数据库操作
 * @date 2019-04-09 00:26
 */
public class BaseDaoImpl implements BaseDao {

    /**
     * 执行一个预编译语句
     *
     * @param sql    sql语句
     * @param params 参数
     * @return int 执行sql语句后影响记录的行数
     * @name executeUpdate
     * @notice sql语句中的表名不能在预编译中设置，sql语句必须已经填好表名，只有字段可以使用占位符<br>
     * 请不要使用以下这种sql语句：<br>
     * executeUpdate("insert into ? (user_name) values (?)",new Object[]{"tb_user","testdao"});<br>
     * 这种语句设置参数后是下面这样：<br>
     * insert into 'tb_user' (user_name) values ('testdao')<br>
     * 表名带上了引号，这种语句显然无法正常执行<br>
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/9
     */
    public int executeUpdate(String sql, Object[] params) {

        /**
         * 请不要对Connection使用auto-close，应该使用JdbcUtils提供的close方法放回数据库连接池
         */
        Connection conn = JdbcUtils.getConnection();
        int result = 0;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            /**
             * 给预编译语句填入参数
             */
            JdbcUtils.setParams(ps, params);
            //TODO debug
            System.out.println(ps.toString());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("执行预编译语句异常："+sql,e);
        } finally {
            JdbcUtils.close(conn);
        }
        return result;
    }
}
