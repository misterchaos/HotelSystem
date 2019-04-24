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
    /*
     **************************************************************
     *          负责数据库insert,update,delete等功能
     **************************************************************
     */

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
    int executeUpdate(Object obj, SqlMapper sqlMapper);

    /**
     * 把一个对象插入一张表
     *
     * @param obj 要插入的对象
     * @return int 更新的数据库记录数
     * @name insert
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/9
     */
    int insert(Object obj);

    /**
     * 根据传入的表名和id，从该表中更新一条记录
     *
     * @param obj 要更新的记录对应的实体类对象
     * @return int 更新的数据库记录数
     * @name update
     * @notice 请注意此方法默认更新该对象中所有不为null的属性到数据库<br>
     * 如果不希望更新某些字段，请将其设置为null
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    int update(Object obj);

    /**
     * 将一个对象从表中删除
     *
     * @param obj 要删除的对象
     * @return int
     * @name delete
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    int delete(Object obj);


    /*
     **************************************************************
     *            负责数据库各类查询功能
     **************************************************************
     */

    /**
     * 执行一条预编译指令，并且填入参数
     *
     * @param sql    要执行的预编译sql语句
     * @param params 参数,如果没有参数需要填，则赋值为null即可
     * @param mapper 结果集映射器，需要实现ResultMapper接口的doMap方法
     * @return java.lang.Object
     * @name executeQuery
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/9
     */
    Object executeQuery(String sql, Object[] params, ResultMapper mapper);

    /*
     **************************************************************
     *              通过sql语句进行查询
     **************************************************************
     */

    /**
     * 执行输入的sql语句，并且将结果以LinkedList的形式返回
     *
     * @param sql    查询的预编译sql语句
     * @param params 预编译的参数,如果没有参数需要填，则赋值为null即可
     * @param clazz  用于映射结果集的实体类
     * @return java.util.LinkedList
     * @name queryList
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    LinkedList queryList(String sql, Object[] params, Class clazz);

    /**
     * 执行输入的sql语句，并且将结果映射为对象，以对象的形式返回<br>
     * 此方法用于查询单行的数据
     *
     * @param sql    查询的预编译sql语句
     * @param params 预编译的参数,如果没有参数需要填，则赋值为null即可
     * @param clazz  用于映射结果集的实体类
     * @return Object
     * @name queryList
     * @notice 如果查询结果为空，则返回null
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    Object queryObject(String sql, Object[] params, Class clazz);

    /**
     * 执行一条sql语句，返回一个字段的值
     *
     * @param sql    查询的预编译sql语句
     * @param params 预编译的参数,如果没有参数需要填，则赋值为null即可
     * @return 查询的字段值
     * @name queryValue
     * @notice 如果查询结果为空，则返回null
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    Object queryValue(String sql, Object[] params);

    /*
     **************************************************************
     *              自动生成sql语句并进行查询
     **************************************************************
     */


    /*
     **************************************************************
     *              排序查询
     **************************************************************
     */

    /**
     * 返回一个排序结果
     *
     * @param selectFields 查询的字段数组，如{"user_name","password"}
     * @param orderBy      按此字段排序
     * @param isDesc       是否逆序排列
     * @param tableName    查询的表名
     * @return java.util.LinkedList
     * @name queryOrderBy
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    LinkedList queryOrderBy(String[] selectFields, String orderBy, boolean isDesc, String tableName);

    /*
     **************************************************************
     *              统计查询
     **************************************************************
     */

    Long queryCount(String tableName, String countField);

    /*
     **************************************************************
     *              条件查询，模糊查询
     **************************************************************
     */

    /**
     * 返回一个where A ? B and/or/not C ? D 形式查询语句的查询结果
     *
     * @param selectFields 查询的字段数组，如{"user_name","password"}
     *                     * @param obj          用于描述附加查询条件的对象<br>
     *                     查询时，将匹配该对象已经被赋值的属性<br>
     *                     比如，传入一个User对象，其Id为1，其余属性为null<br>
     *                     则会匹配所有id为1的用户记录，如果属性全为null<br>
     *                     则会匹配所有用户记录
     * @param conj         where语句的连接词，如 and, or
     * @param condition    where语句的比较条件
     * @return java.util.LinkedList
     * @name queryWhere
     * @notice 连接词不能为not
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    LinkedList queryWhere(String[] selectFields, Object obj, String conj, String condition);

    /**
     * 返回一个where A = B and C = D 形式查询语句的查询结果
     *
     * @param selectFields 查询的字段数组，如{"user_name","password"}
     * @param obj          用于描述附加查询条件的对象<br>
     *                     查询时，将匹配该对象已经被赋值的属性<br>
     *                     比如，传入一个User对象，其Id为1，其余属性为null<br>
     *                     则会匹配所有id为1的用户记录，如果属性全为null<br>
     *                     则会匹配所有用户记录
     * @return java.util.LinkedList
     * @name queryWhereAndEquals
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    LinkedList queryWhereAndEquals(String[] selectFields, Object obj);


    /**
     * 返回一个where A like B and C like D 形式查询语句的查询结果
     *
     * @param selectFields 查询的字段数组，如{"user_name","password"}
     * @param obj          用于描述附加查询条件的对象<br>
     *                     查询时，将匹配该对象已经被赋值的属性<br>
     *                     比如，传入一个User对象，其Id为1，其余属性为null<br>
     *                     则会匹配所有id为1的用户记录，如果属性全为null<br>
     *                     则会匹配所有用户记录
     * @return java.util.LinkedList
     * @name queryWhereLikeAnd
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    LinkedList queryWhereLikeAnd(String[] selectFields, Object obj);

    /**
     * 返回一个where A like B or C like D 形式查询语句的查询结果
     *
     * @param selectFields 查询的字段数组，如{"user_name","password"}
     * @param obj          用于描述附加查询条件的对象<br>
     *                     查询时，将匹配该对象已经被赋值的属性<br>
     *                     比如，传入一个User对象，其Id为1，其余属性为null<br>
     *                     则会匹配所有id为1的用户记录，如果属性全为null<br>
     *                     则会匹配所有用户记录
     * @return java.util.LinkedList
     * @name queryWhereLikeAnd
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    LinkedList queryWhereLikeOr(String[] selectFields, Object obj);

    /*
     **************************************************************
     *              分页查询
     **************************************************************
     */

    /**
     * 返回一个分页查询的结果
     *
     * @param selectFields 查询的字段数组，如{"user_name","password"}
     * @param tableName    查询的表名
     * @param limit        该页最多查询的记录数
     * @param offset       该页查询的起始记录数
     * @return java.util.LinkedList
     * @name queryPages
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    LinkedList queryPages(String[] selectFields, String tableName, String limit, String offset);

    /*
     **************************************************************
     *  各个功能模块共同依赖的映射功能
     **************************************************************
     */

    /**
     * 把一个对象映射成为属性名集合和属性值集合
     *
     * @param obj         需要被映射的对象
     * @param fieldNames  将映射的属性名返回在这个集合中
     * @param fieldValues 将映射的属性值返回在这个集合中
     * @name fieldMapper
     * @notice 只映射该对象中值不为null的属性
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/9
     */
    void fieldMapper(Object obj, LinkedList fieldNames, LinkedList fieldValues);

    /**
     * 根据传入的表名生成一个select语句，如select user_name from user
     *
     * @param tableName    表名
     * @param selectFields select字段
     * @return java.lang.String
     * @name selectMapper
     * @notice 请注意本方法产生的语句不带有预编译参数
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    String selectMapper(String tableName, Object[] selectFields);

    /**
     * 生成一个where语句，如where id = ?
     *
     * @param whereFields where条件的字段名数组,比如where id = 1,应该传入 {id}
     * @param conj        逻辑连接词：and , or , not
     * @return java.lang.String 返回映射之后的预编译where语句,如where id = ? and user_name = ?
     * @name whereMapper
     * @notice 请注意此语句只用于追加where语句，不能单独用来查询
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    String whereMapper(Object[] whereFields, String conj, String condition);

    /**
     * 生成一个where like 语句，如where id like ?
     *
     * @param likeFields where条件的字段名数组,比如where id like 1,应该传入 {id}
     * @param conj       逻辑连接词：and , or , not
     * @return java.lang.String 返回映射之后的预编译where语句,如where id like ? and user_name like ?
     * @name likeMapper
     * @notice 请注意此语句只用于追加where语句，不能单独用来查询
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    String likeMapper(Object[] likeFields, String conj);

    /**
     * 返回一个Order语句，如order by id
     *
     * @param orderBy 按此字段排序
     * @param isDesc  是否逆序排列
     * @return java.lang.String
     * @name orderByMapper
     * @notice 请注意此语句只用于追加where语句，不能单独用来查询
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    String orderByMapper(String orderBy, boolean isDesc);

    /**
     * 返回一个分页查询语句，如limit 3 offset 0
     *
     * @param limit  该页最多查询的记录数
     * @param offset 该页查询的起始记录数
     * @return java.lang.String
     * @name pageMapper
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    String pageMapper(String limit, String offset);


    /**
     * 返回一个每页LIMIT条记录的分页查询语句，如limit 10 offset 0
     * LIMIT 由本类的成员变量控制
     *
     * @param offset 该页查询的起始记录数
     * @return java.lang.String
     * @name pageMapper
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    String pageOffsetMapper(String offset);

}
