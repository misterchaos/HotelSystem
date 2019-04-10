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

import com.hyc.www.dao.impl.BaseDaoImpl;
import com.hyc.www.exception.DaoException;
import com.hyc.www.util.JdbcUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 提供共有数据库操作
 * @date 2019-04-08 23:05
 */
public interface BaseDao {
    /**
     * 执行一个预编译更新语句
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
    public int executeUpdate(String sql, Object[] params);


    /**
     * @param sql    要执行的预编译sql语句
     * @param params 参数
     * @param mapper 结果集映射器，需要实现ResultMapper接口的doMap方法
     * @return java.lang.Object
     * @name executeQuery
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/9
     */
    public Object executeQuery(String sql, Object[] params, ResultMapper mapper);

    /**
     * @param table 要插入的表名
     * @param obj   要插入的对象
     * @return int 更新的数据库记录数
     * @name insert
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/9
     */
    public int insert(String table, Object obj);





    /**
     * 根据传入的表名和id，从该表中删除该条记录
     *
     * @param table 要删除记录所在的表名
     * @param id    要删除的记录的id
     * @return int 更新的数据库记录数
     * @name delete
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    public int delete(String table, Object id);


    /**
     * 根据传入的表名和id，从该表中更新一条记录
     *
     * @param table 要操作的目标表名
     * @param obj 要更新的记录对应的实体类对象
     * @return int 更新的数据库记录数
     * @name update
     * @notice 请注意此方法默认更新该对象中所有不为null的属性到数据库<br>
     * 如果不希望更新某些字段，请将其设置为null
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    public int update(String table, Object obj);

    /**
     * 执行输入的sql语句，并且将结果映射为对象集合，以LinkedList的形式返回
     *
     * @param sql    查询的预编译sql语句
     * @param params 预编译的参数
     * @param clazz  用于映射结果集的实体类
     * @return java.util.LinkedList
     * @name queryList
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    public LinkedList<Object> queryList(String sql, Object[] params, Class clazz);


}
