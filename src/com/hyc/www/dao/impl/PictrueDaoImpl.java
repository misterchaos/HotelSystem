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

import com.hyc.www.po.Picture;
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
    private final String TABLE_NAME = " " + JdbcUtils.getTableName(Picture.class) + " ";


    /**
     * 表中所有字段对应的查询语句
     */
    private final String ALL_FIELD_NAME = " id,author_id,pictrue,gmt_create,gmt_modified ";
private String[] ALL_FIELD_ARRAY = new String[]{ "id","author_id","pictrue","gmt_create","gmt_modified" };
    public boolean add(Picture picture){
        if(picture !=null){
            return super.insert(picture)==1;
        }
        return false;
    }

    public LinkedList<Picture> list(String authorId){
        if(authorId!=null){
            Picture picture = new Picture();
            picture.setId(authorId);
            LinkedList list=  new LinkedList<>();
            LinkedList<Picture> pictures = new LinkedList();
            list = super.queryWhereAndEquals(ALL_FIELD_ARRAY, picture);
            for(int i=0;i<list.size();i++){
                Picture pic = (Picture) list.get(i);
                pictures.add(pic);
            }
            return pictures;
        }
        return null;
    }
}
