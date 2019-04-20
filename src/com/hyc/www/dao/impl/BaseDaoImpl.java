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
import com.hyc.www.dao.inter.ResultMapper;
import com.hyc.www.dao.inter.SqlMapper;
import com.hyc.www.exception.DaoException;
import com.hyc.www.util.JdbcUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;

import static com.hyc.www.util.ReflectUtils.getFields;
import static com.hyc.www.util.ReflectUtils.getMethods;
import static com.hyc.www.util.StringUtils.field2SqlField;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 所有Dao接口实现类的父类，提供共有数据库操作
 * @date 2019-04-09 00:26
 */
public class BaseDaoImpl implements BaseDao {

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
    @Override
    public int executeUpdate(Object obj, SqlMapper sqlMapper) {
        if (obj == null) {
            return 0;
        }
        LinkedList fieldNames = new LinkedList<>();
        LinkedList fieldValues = new LinkedList<>();
        /**
         * 使用fieldMapper将对象映射成要更新的字段名集合和字段值集合
         */
        fieldMapper(obj, fieldNames, fieldValues);
        /**
         * 使用sqlMapper将字段名映射成sql语句，使用paramMapper将字段值映射成属性值数组
         */
        String sql = sqlMapper.doMap(fieldNames.toArray());
        Object[] params = fieldValues.toArray();
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
            /**
             * 将ps填入参数后的完整语句赋值给sql
             */
            sql = ps.toString();
            //TODO
            System.out.println(sql);
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("预编译更新语句异常：" + sql, e);
        } finally {
            JdbcUtils.close(conn);
        }
        return result;
    }

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
    @Override
    public int insert(Object obj) {
        return obj == null ? 0 : executeUpdate(obj, params -> {
            /**
             * updateRunner会传入一个属性值集合
             */
            Object[] fieldNames = params;
            /**
             * 根据属性名生成预编译sql插入语句
             */
            StringBuilder sql = new StringBuilder("insert into " + JdbcUtils.getTableName(obj) + " (");
            for (Object name : fieldNames) {
                sql.append(name.toString() + ",");
            }
            sql.setCharAt(sql.length() - 1, ')');
            sql.append(" values (");
            for (int i = 0; i < fieldNames.length; i++) {
                sql.append("?,");
            }
            sql.setCharAt(sql.length() - 1, ')');
            return sql.toString();
        });
    }

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
    @Override
    public int update(Object obj) {
        return obj == null ? 0 : executeUpdate(obj, params -> {
            /**
             * updateRunner会传入一个属性值LinkedList
             */
            Object[] fieldNames = params;
            /**
             * 根据属性名生成预编译sql更新语句
             */
            Object id = null;
            StringBuilder sql = new StringBuilder("update " + JdbcUtils.getTableName(obj) + " set ");
            for (Object name : fieldNames) {
                sql.append(name + " = ?,");
            }
            sql.setCharAt(sql.length() - 1, ' ');
            try {
                for (Class clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
                    try {
                        id = clazz.getDeclaredMethod("getId").invoke(obj);
                    } catch (NoSuchMethodException e) {
                        /**
                         * 此处不能终止循环
                         */
                        System.out.println("查找父类getId方法...");
                    }
                }
                sql.append(" where id = \"" + id + "\"");
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                throw new DaoException("反射执行getId方法异常：无法执行getId方法", e);
            }
            return sql.toString();
        });
    }

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
    @Override
    public int delete(Object obj) {
        return obj == null ? 0 : executeUpdate(obj, params -> "delete from " + JdbcUtils.getTableName(obj) + " where id = ?");
    }


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
    @Override
    public Object executeQuery(String sql, Object[] params, ResultMapper mapper) {

        Connection conn = JdbcUtils.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            JdbcUtils.setParams(ps, params);
            /**
             * 将ps填入参数后的完整语句赋值给sql
             */
            sql = ps.toString();
            ResultSet rs = ps.executeQuery();
            /**
             * 调用接口中的方法映射结果集，使用时该接口必须有实现类
             */
            //TODO debug
            System.out.println(sql);
            return mapper.doMap(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("预编译查询语句异常：" + sql, e);
        } finally {
            JdbcUtils.close(conn);
        }
    }

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
    @Override
    public LinkedList queryList(String sql, Object[] params, Class clazz) {
        return (LinkedList) executeQuery(sql, params, rs -> {
            /**
             * ResultMapper的一个实现类，提供将结果集映射为一个List的方法<br>
             * 此类的对象在使用前必须设置一个用于映射结果的实体类
             *
             * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
             * @name ListMapper
             * @notice 如果查询结果为空，则返回一个空集合
             * @date 2019/4/10
             * @see com.hyc.www.dao.inter.ResultMapper
             */
            LinkedList list = new LinkedList<>();
            try {
                ResultSetMetaData md = rs.getMetaData();
                /**
                 * 取出包括父类方法在内的所有方法
                 * 这里clazz必须用claz代替，否则clazz将被修改
                 */
                LinkedList<Method> methods =getMethods(clazz.newInstance());
                /**
                 * 取得字段名,存在columns数组中，并映射成setter方法数组
                 */
                int colCount = md.getColumnCount();
                String[] setters = new String[colCount + 1];
                String[] columns = new String[colCount + 1];
                for (int i = 0; i < colCount; i++) {
                    columns[i] = md.getColumnLabel(i + 1);
                    /**
                     * 取得字段名并映射为setter方法名，忽略大小写,存在setters数组中
                     */
                    String[] split = md.getColumnLabel(i + 1).split("_");
                    StringBuilder setter = new StringBuilder("set");
                    for (int j = 0; j < split.length; j++) {
                        setter.append(split[j]);
                    }
                    setters[i] = setter.toString();
                }

                while (rs.next()) {
                    Object obj = clazz.newInstance();
                    for (int i = 0; i < colCount; i++) {
                        /**
                         * 执行对应的set方法，忽略大小写
                         */
                        for (Method ms : methods) {
                            if (ms.getName().equalsIgnoreCase(setters[i])) {
                                ms.invoke(obj, rs.getObject(columns[i]));
                            }
                        }
                    }
                    list.add(obj);
                }
            } catch (SQLException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
                throw new DaoException("映射结果集产生异常：" + e.getMessage(), e);
            }
            return list;
        });
    }

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
    @Override
    public Object queryObject(String sql, Object[] params, Class clazz) {
        LinkedList list = queryList(sql, params, clazz);
        return list.size() > 0 ? list.get(0) : null;
    }

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
    @Override
    public Object queryValue(String sql, Object[] params) {
        return executeQuery(sql, params, new ResultMapper() {
            @Override
            public Object doMap(ResultSet rs) {
                try {
                    if (rs.next()) {
                        return rs.getObject(1);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DaoException("查询一个字段产生异常：" + sql, e);
                }
                return null;

            }
        });
    }

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
    @Override
    public LinkedList queryOrderBy(String[] selectFields, String orderBy, boolean isDesc, String tableName) {
        StringBuilder sql = new StringBuilder(selectMapper(tableName, selectFields));
        if (orderBy != null) {
            sql.append(orderByMapper(orderBy, isDesc));
        }
        return queryList(sql.toString(), new Object[0], JdbcUtils.getClass(tableName));
    }

    /*
     **************************************************************
     *              统计查询
     **************************************************************
     */

    @Override
    public Long queryCount(String tableName, String countField) {
        return (Long) queryValue(selectMapper(tableName, new String[]{"count(" + countField + ")"}), new Object[0]);
    }

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
     * @param condition    where语句的比较条件，如 = ,< ,> , <= ,>=
     * @return java.util.LinkedList
     * @name queryWhere
     * @notice 连接词不能为not
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/13
     */
    @Override
    public LinkedList queryWhere(String[] selectFields, Object obj, String conj, String condition) {
        if (selectFields.length == 0) {
            return null;
        }
        LinkedList fieldNames = new LinkedList();
        LinkedList fieldValues = new LinkedList<>();
        /**
         * 使用fieldMapper将对象映射成要更新的字段名集合和字段值集合<br>
         * 其中字段名即为参数
         */
        fieldMapper(obj, fieldNames, fieldValues);
        /**
         * 映射预编译语句,如果where条件数量大于0，则追加where语句
         */
        StringBuilder sql = new StringBuilder(selectMapper(JdbcUtils.getTableName(obj), selectFields));
        if (fieldNames.size() > 0) {
            /**
             * 检查是否为模糊查询
             */
            if (conj.equalsIgnoreCase("like")) {
                sql.append(likeMapper(fieldNames.toArray(), conj));
            } else {
                sql.append(whereMapper(fieldNames.toArray(), conj, condition));
            }
        }
        return queryList(sql.toString(), fieldValues.toArray(), obj.getClass());
    }

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
    @Override
    public LinkedList queryWhereAndEquals(String[] selectFields, Object obj) {
        return queryWhere(selectFields, obj, "and", "=");
    }


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
    @Override
    public LinkedList queryWhereLikeAnd(String[] selectFields, Object obj) {
        return queryWhere(selectFields, obj, "and", "like");
    }

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
    @Override
    public LinkedList queryWhereLikeOr(String[] selectFields, Object obj) {
        return queryWhere(selectFields, obj, "or", "like");
    }

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
    @Override
    public LinkedList queryPages(String[] selectFields, String tableName, String limit, String offset) {
        StringBuilder sql = new StringBuilder(selectMapper(tableName, selectFields));
        sql.append(pageMapper(limit, offset));
        return queryList(sql.toString(), new Object[0], JdbcUtils.getClass(tableName));
    }

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
    @Override
    public void fieldMapper(Object obj, LinkedList fieldNames, LinkedList fieldValues) {
        if (obj == null) {
            return;
        }

        /**
         * 取出包括父类在内的所有方法和属性
         */
        LinkedList<Method> methods = getMethods(obj);
        LinkedList<Field> fields = getFields(obj);
        for (Field field : fields) {
            /**
             * 取出每个属性的值
             */
            for (Method method : methods) {
                if (method.getName().startsWith("get") && method.getName().substring(3).equalsIgnoreCase(field.getName())) {
                    Object value = null;
                    try {
                        value = method.invoke(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new DaoException("反射执行get方法异常：" + method.getName(), e);
                    }
                    /**
                     * 只添加不为null值的字段
                     */
                    if (value != null) {
                        fieldValues.add(value);
                        /**
                         * 取出该属性的名称，映射成数据库字段名
                         */
                        fieldNames.add(field2SqlField(field.getName()));
                    }
                }
            }
        }
    }


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
    @Override
    public String selectMapper(String tableName, Object[] selectFields) {
        StringBuilder sql = new StringBuilder("select ");
        for (int i = 0; i < selectFields.length; i++) {
            sql.append(selectFields[i] + ",");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" from " + tableName);
        return sql.toString();
    }

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
    @Override
    public String whereMapper(Object[] whereFields, String conj, String condition) {

        StringBuilder sql = new StringBuilder();
        if (whereFields.length == 0) {
            return sql.toString();
        }
        sql.append(" where ");
        for (int i = 0; i < whereFields.length; i++) {
            sql.append(whereFields[i] + " " + condition + "?  " + conj + " ");

        }
        sql.delete(sql.length() - 4, sql.length());
        return sql.toString();
    }

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
    @Override
    public String likeMapper(Object[] likeFields, String conj) {
        StringBuilder sql = new StringBuilder();
        if (likeFields.length == 0) {
            return sql.toString();
        }
        sql.append(" where ");
        for (int i = 0; i < likeFields.length; i++) {
            sql.append(likeFields[i] + " like  ?  " + conj + " ");

        }
        sql.delete(sql.length() - 4, sql.length());
        return sql.toString();
    }

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
    @Override
    public String orderByMapper(String orderBy, boolean isDesc) {
        /**
         * 标志是否逆序
         * true--------逆序
         * false-------正序(默认值)
         */
        StringBuilder sql = new StringBuilder();
        sql.append(" order by " + orderBy);
        /**
         * 如果是逆序模式，追加desc
         */
        if (isDesc) {
            sql.append(" desc ");
        }
        return sql.toString();
    }

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
    @Override
    public String pageMapper(String limit, String offset) {
        return " limit " + limit + " offset " + offset + " ";
    }


}

