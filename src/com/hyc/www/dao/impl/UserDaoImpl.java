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

import com.hyc.www.dao.inter.UserDao;
import com.hyc.www.po.User;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责提供User类到数据库的CRUD操作
 * @date 2019-04-09 00:13
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    /**
     * 本类操作的数据库表名
     */
    String TABLE_NAME = " user ";


    /**
     * 表中所有字段对应的查询语句
     */
    String ALL_FIELD_NAME = " id,user_name,password,phone_number,id_number,nick_name,"
            + "photo,status,balance,pay_pwd,gmt_create,gmt_modified ";



    /**
     * 添加一个用户到数据库
     *
     * @name addUser
     * @param user 要添加的用户对象
     * @return boolean
     * @notice 无法添加用户名为空的用户
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean addUser(User user){
        if(user==null||user.getUserName()==null) {
            return false;
        }
        return super.insert(TABLE_NAME, user) == 1;
    }

    /**
     * 根据用户名查询一个用户的所有信息
     *
     * @param userName 用户名
     * @return com.hyc.www.po.User
     * @name getUser
     * @notice 如果用户名为空或者没有该用户，则返回null;
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    @Override
    public User getUser(String userName) {
        if(userName==null){
            return null;
        }
        String sql = "select " + ALL_FIELD_NAME + " from " + TABLE_NAME + " where user_name = ?";
        return (User) super.queryObject(sql, new Object[]{userName}, User.class);
    }

    /**
     * 返回该用户名对应的登陆密码
     *
     * @param userName 需要查询登陆密码的用户名
     * @return java.lang.String
     * @name getPassword
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public String getPassword(String userName) {
        String sql = "select password from " + TABLE_NAME + " where user_name = ?";
        return (String) super.queryValue(sql, new Object[]{userName});
    }


    /**
     * 返回该用户名对应的id
     *
     * @param userName 用户名
     * @return java.math.BigInteger
     * @name getId
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public BigInteger getId(String userName) {
        String sql = "select id from " + TABLE_NAME + " where user_name = ?";
        return (BigInteger) super.queryValue(sql, new Object[]{userName});
    }

    /**
     * 获取表中所有用户的信息，并以LinkedList的形式返回
     *
     * @return java.util.LinkedList
     * @name qgetAllUsers
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public LinkedList<User> getAllUsers() {
        String sql = "select " + ALL_FIELD_NAME + " from " + TABLE_NAME;
        LinkedList<Object> list = super.queryList(sql, null, User.class);
        LinkedList<User> users = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            User user = (User) list.get(i);
            users.add(user);
        }
        return users;
    }


    /**
     * 将该id对应的用户从数据库中删除
     *
     * @param Id 要删除用户的id
     * @return boolean
     * @name deleteById
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean deleteById(BigInteger Id) {
        return super.delete(TABLE_NAME, Id) == 1;
    }


    /**
     * 将该用户名对应的用户从数据库中删除
     *
     * @param userName 要删除的用户的用户名
     * @return boolean
     * @name deleteByUserName
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean deleteByUserName(String userName) {
        return deleteById(getId(userName));
    }

    /**
     * 将一个用户对象从数据库中删除
     *
     * @param user 要删除的用户对象
     * @return boolean
     * @name delete
     * @notice 该用户对象必须至少包含用户的id
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean delete(User user) {
        return deleteById(user.getId());
    }


    /**
     * 更新一个用户的信息，不包括登陆密码和支付密码
     *
     * @param user 要更新的用户对象
     * @return boolean
     * @name update
     * @notice 此方法不会更新用户的密码，需要更新密码请使用updateWithPassword
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean update(User user) {
        if(user==null){
            return false;
        }
        /**
         * 使用克隆对象，防止影响原来对象的值
         */
        User clone = user.clone();
        clone.setPassword(null);
        clone.setPayPwd(null);
        return super.update(TABLE_NAME, clone) == 1;
    }


    /**
     * 更新一个用户的信息，包括密码
     *
     * @param user 要更新的用户对象
     * @return boolean
     * @name updateAll
     * @notice 此方法会更新用户的密码，请只在用户更新密码时使用，否则md5的摘要将覆盖原来的摘要<br>
     * 如果传入的对象为null或者找不到该用户，则返回false
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    @Override
    public boolean updateAll(User user) {
        return super.update(TABLE_NAME, user) == 1;
    }
}
