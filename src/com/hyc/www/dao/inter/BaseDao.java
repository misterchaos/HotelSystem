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

import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 提供共有数据库操作
 * @date 2019-04-08 23:05
 */
public interface BaseDao {

    /***************************************************************************************
     *          负责数据库insert,update,delete等功能
     ***************************************************************************************/
    /**
     * 将一个对象映射成预编译sql语句并执行<br>
     * 需要一个SqlMapper的具体实现
     *
     * @param obj       更新的对象
     * @param sqlMapper 用于映射sql语句的实现类
     * @return int 执行sql语句后影响记录的行数
     * @name executeUpdate
     * @notice 必须传入一个SqlMapper的实现类用于映射预编译语句
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/9
     * @see SqlMapper
     */
    int executeUpdate(Object obj,SqlMapper sqlMapper);


    /**
     * 执行一条预编译指令，并且填入参数
     *
     * @param sql    要执行的预编译sql语句
     * @param params 参数
     * @param mapper 结果集映射器，需要实现ResultMapper接口的doMap方法
     * @return java.lang.Object
     * @name executeQuery
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/9
     */
    Object executeQuery(String sql, Object[] params, ResultMapper mapper);

    /**
     * 把一个对象插入一张表
     *
     * @param obj   要插入的对象
     * @return int 更新的数据库记录数
     * @name insert
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/9
     */
    int insert(Object obj);


    /**
     * 将一个对象从表中删除
     * @name delete
     * @param obj 要删除的对象
     * @return int
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    int delete( Object obj);


    /**
     * 根据传入的表名和id，从该表中更新一条记录
     *
     * @param obj   要更新的记录对应的实体类对象
     * @return int 更新的数据库记录数
     * @name update
     * @notice 请注意此方法默认更新该对象中所有不为null的属性到数据库<br>
     * 如果不希望更新某些字段，请将其设置为null
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    int update( Object obj);

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
    LinkedList<Object> queryList(String sql, Object[] params, Class clazz);

    /**
     * 执行输入的sql语句，并且将结果映射为对象，以对象的形式返回<br>
     * 此方法用于查询单行的数据
     * @param sql    查询的预编译sql语句
     * @param params 预编译的参数
     * @param clazz  用于映射结果集的实体类
     * @return Object
     * @name queryList
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    Object queryObject(String sql, Object[] params, Class clazz);


    /**
     * 执行一条sql语句，返回一个字段的值
     *
     * @param sql    查询的预编译sql语句
     * @param params 预编译的参数
     * @return 查询的字段值
     * @name queryValue
     * @notice 如果查询结果为空，则返回一个空的字符串
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    Object queryValue(String sql, Object[] params);


}
