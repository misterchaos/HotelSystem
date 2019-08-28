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

import com.hyc.www.annotation.DML;
import com.hyc.www.annotation.InsertSQL;
import com.hyc.www.annotation.SQLParam;
import com.hyc.www.po.User;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description
 * @date 2019-05-01 10:46
 */
public interface MyUserDao extends BaseDao {

    @InsertSQL("insert into t_user (id,name) values (?,?) ")
    boolean insert(@SQLParam() String id,@SQLParam (index = 2)String name);


}
