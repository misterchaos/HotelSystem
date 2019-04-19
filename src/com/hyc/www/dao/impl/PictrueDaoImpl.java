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

import com.hyc.www.po.Pictrue;
import com.hyc.www.util.JdbcUtils;

import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责图片的CRUD
 * @date 2019-04-19 18:57
 */
public class PictrueDaoImpl extends BaseDaoImpl {
    /**
     * 本类操作的数据库表名
     */
    private final String TABLE_NAME = " " + JdbcUtils.getTableName(Pictrue.class) + " ";


    /**
     * 表中所有字段对应的查询语句
     */
    private final String ALL_FIELD_NAME = " id,author_id,pictrue,gmt_create,gmt_modified ";
private String[] ALL_FIELD_ARRAY = new String[]{ "id","author_id","pictrue","gmt_create","gmt_modified" };
    public boolean add(Pictrue pictrue){
        if(pictrue!=null){
            return super.insert(pictrue)==1;
        }
        return false;
    }

    public LinkedList<Pictrue> list(String authorId){
        if(authorId!=null){
            Pictrue pictrue = new Pictrue();
            pictrue.setId(authorId);
            LinkedList list=  new LinkedList<>();
            LinkedList<Pictrue> pictrues = new LinkedList();
            list = super.queryWhereAndEquals(ALL_FIELD_ARRAY,pictrue);
            for(int i=0;i<list.size();i++){
                Pictrue pic = (Pictrue) list.get(i);
                pictrues.add(pic);
            }
            return pictrues;
        }
        return null;
    }
}
