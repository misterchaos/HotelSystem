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

import com.hyc.www.dao.inter.RemarkDao;
import com.hyc.www.po.Remark;
import com.hyc.www.util.JdbcUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description RemarkDao的实现类
 * @date 2019-04-23 01:15
 */
public class RemarkDaoImpl extends BaseDaoImpl implements RemarkDao {

    /**
     *
     */
    private final int limit = 10;

    /**
     * 本类操作的数据库表名
     */
    private final String TABLE_NAME = " " + JdbcUtils.getTableName(Remark.class) + " ";

    /**
     * 负责将一条评论插入数据库
     *
     * @param remark
     * @return 成功返回true, 否则返回false
     * @name add
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/23
     */
    @Override
    public boolean add(Remark remark) {
        return super.insert(remark) == 1;
    }

    /**
     * 返回所有评论
     *
     * @return 评论集合
     * @name listAll
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/23
     */
    @Override
    public LinkedList<Remark> listAll() {
        String sql = "select id,user_name,remark,status,gmt_create,gmt_modified from " + TABLE_NAME + " order by gmt_create desc";
        LinkedList<Remark> remarks = new LinkedList<>();
        List list = super.queryList(sql, new String[0], Remark.class);
        if (list != null) {
            for (Object obj : list) {
                Remark remark = (Remark) obj;
                remarks.add(remark);
            }
            return remarks;
        }
        return null;
    }


    /**
     * 返回该用户名对应留言数量
     *
     * @param userName 用户名
     * @return
     * @name getUserRemarkCount
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/26
     */
    @Override
    public int getUserRemarkCount(String userName) {
        String sql = "select count(*) from " + TABLE_NAME + " where user_name = ? ";
        return Math.toIntExact((Long) super.queryValue(sql, new String[]{userName}));
    }
}
