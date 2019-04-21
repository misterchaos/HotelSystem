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

import com.hyc.www.po.User;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 提供User类的Dao接口
 * @date 2019-04-08 23:02
 */
public interface UserDao {

    /**
     * 通过用户名检查一个用户是否已经存在
     *
     * @param userName 用户名
     * @return boolean
     * @name isExist
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/14
     */
    boolean isExist(String userName);

    /**
     * 添加一个用户到数据库
     *
     * @param user 要添加的用户对象
     * @return boolean
     * @name addUser
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    boolean addUser(User user);

    /**
     * 根据id查询一个用户的所有信息
     *
     * @param id 用户id
     * @return com.hyc.www.po.User
     * @name getUser
     * @notice 如果id为空或者没有该用户，则返回null;
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/21
     */
    User getUserById(String id);

    /**
     * 根据用户名查询一个用户的所有信息
     *
     * @param userName 用户名
     * @return com.hyc.www.po.User
     * @name getUser
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/10
     */
    User getUser(String userName);

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
    String getPassword(String userName);


    /**
     * 返回该用户名对应的id
     *
     * @param userName 用户名
     * @return java.math.String
     * @name getId
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    String getId(String userName);

    /**
     * 获取表中所有用户的信息，并以LinkedList的形式返回
     *
     * @return java.util.LinkedList
     * @name qgetAllUsers
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    LinkedList<User> getAllUsers();

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
    boolean deleteById(String Id);


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
    boolean deleteByUserName(String userName);


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
    boolean delete(User user);


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
    boolean update(User user);


    /**
     * 更新一个用户的信息，包括密码
     *
     * @param user 要更新的用户对象
     * @return boolean
     * @name updateAll
     * @notice 此方法会更新用户的密码，请只在用户更新密码时使用，否则md5的摘要将覆盖原来的摘要
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/11
     */
    boolean updateAll(User user);


}
