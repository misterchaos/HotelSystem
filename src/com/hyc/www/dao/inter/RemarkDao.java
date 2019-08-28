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

import com.hyc.www.po.Remark;

import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责评论的CRUD
 * @date 2019-04-23 01:10
 */
public interface RemarkDao {

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
    boolean add(Remark remark);

    /**
     * 返回所有评论
     *
     * @return 评论集合
     * @name listAll
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/23
     */
    LinkedList<Remark> listAll();
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
    int getUserRemarkCount(String userName);
}
